package com.open.gov.data.adapter;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.open.gov.data.R;
import com.open.gov.data.entity.DatasetAPIEntity;
import android.content.Intent;

public class DataSetAdaptor extends ArrayAdapter<DatasetAPIEntity> {
    Context context;
    int layoutResourceId;
    List<DatasetAPIEntity> data = new ArrayList<DatasetAPIEntity>();
    LayoutInflater inflater;
    Intent intent;

    public DataSetAdaptor(Context context, int layoutResourceId,List<DatasetAPIEntity> data, Intent intent) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        this.intent = intent;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public DatasetAPIEntity getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.indexOf(data.get(position));
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        inflater = ((Activity) context).getLayoutInflater();
        final DatasetAPIEntity item = data.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.inc_api_dataset, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if(null != item.getTitle() && !item.getTitle().equalsIgnoreCase("null")) {
            holder.title.setText(item.getTitle());
        }
        if(null != item.getDesc() && !item.getDesc().equalsIgnoreCase("null")) {
            holder.desc.setText(item.getDesc());
        }
        if(null != item.getSector() && !item.getSector().equalsIgnoreCase("null")) {
            holder.sector.setText(item.getSector());
        }
        if(null != item.getCreatedDate() && !item.getCreatedDate().equalsIgnoreCase("null")) {
            holder.createdDate.setText(item.getCreatedDate());
        }
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        TextView desc;
        TextView sector;
        TextView createdDate;
        LinearLayout layout;
        ViewHolder(View root) {
            layout = (LinearLayout)root.findViewById(R.id.layout);
            title = (TextView)root.findViewById(R.id.dataset_title);
            desc = (TextView)root.findViewById(R.id.dataset_desc);
            sector = (TextView)root.findViewById(R.id.dataset_sector);
            createdDate = (TextView)root.findViewById(R.id.dataset_date);
        }
    }
}
