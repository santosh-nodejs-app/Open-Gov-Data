package com.open.gov.data.adapter;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import com.open.gov.data.R;
import com.open.gov.data.entity.AQIEntity;

public class AQIAdaptor extends ArrayAdapter<AQIEntity> {
    Context context;
    int layoutResourceId;
    List<AQIEntity> data = new ArrayList<AQIEntity>();
    LayoutInflater inflater;

    public AQIAdaptor(Context context, int layoutResourceId,List<AQIEntity> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public AQIEntity getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.indexOf(data.get(position));
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        inflater = ((Activity) context).getLayoutInflater();
        final AQIEntity item = data.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.inc_aqi_layout, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if(null != item.getUpdated() && !item.getUpdated().equalsIgnoreCase("null")) {
            holder.updated.setText(item.getUpdated());
        }
        if(null != item.getA1_1() && !item.getA1_1().equalsIgnoreCase("null")) {
            holder.a1_1.setText(item.getA1_1());
        }
        if(null != item.getA1_2() && !item.getA1_2().equalsIgnoreCase("null")) {
            holder.a1_2.setText(item.getA1_2());
        }
        if(null != item.getA1_3() && !item.getA1_3().equalsIgnoreCase("null")) {
            holder.a1_3.setText(item.getA1_3());
        }
        if(null != item.getA2_1() && !item.getA2_1().equalsIgnoreCase("null")) {
            holder.a2_1.setText(item.getA2_1());
        }
        if(null != item.getA2_2() && !item.getA2_2().equalsIgnoreCase("null")) {
            holder.a2_2.setText(item.getA2_2());
        }
        if(null != item.getA2_3() && !item.getA2_3().equalsIgnoreCase("null")) {
            holder.a2_3.setText(item.getA2_3());
        }
        if(null != item.getA3_1() && !item.getA3_1().equalsIgnoreCase("null")) {
            holder.a3_1.setText(item.getA3_1());
        }
        if(null != item.getA3_2() && !item.getA3_2().equalsIgnoreCase("null")) {
            holder.a3_2.setText(item.getA3_2());
        }
        if(null != item.getA3_3() && !item.getA3_3().equalsIgnoreCase("null")) {
            holder.a3_3.setText(item.getA3_3());
        }
        if(null != item.getA4_1() && !item.getA4_1().equalsIgnoreCase("null")) {
            holder.a4_1.setText(item.getA4_1());
        }
        if(null != item.getA4_2() && !item.getA4_2().equalsIgnoreCase("null")) {
            holder.a4_2.setText(item.getA4_2());
        }
        if(null != item.getA4_3() && !item.getA4_3().equalsIgnoreCase("null")) {
            holder.a4_3.setText(item.getA4_3());
        }
        if(null != item.getA5_1() && !item.getA5_1().equalsIgnoreCase("null")) {
            holder.a5_1.setText(item.getA5_1());
        }
        if(null != item.getA5_2() && !item.getA5_2().equalsIgnoreCase("null")) {
            holder.a5_2.setText(item.getA5_2());
        }
        if(null != item.getA5_3() && !item.getA5_3().equalsIgnoreCase("null")) {
            holder.a5_3.setText(item.getA5_3());
        }
        if(null != item.getA6_1() && !item.getA6_1().equalsIgnoreCase("null")) {
            holder.a6_1.setText(item.getA6_1());
        }
        if(null != item.getA6_2() && !item.getA6_2().equalsIgnoreCase("null")) {
            holder.a6_2.setText(item.getA6_2());
        }
        if(null != item.getA6_3() && !item.getA6_3().equalsIgnoreCase("null")) {
            holder.a6_3.setText(item.getA6_3());
        }
        if(null != item.getA7_1() && !item.getA7_1().equalsIgnoreCase("null")) {
            holder.a7_1.setText(item.getA7_1());
        }
        if(null != item.getA7_2() && !item.getA7_2().equalsIgnoreCase("null")) {
            holder.a7_2.setText(item.getA7_2());
        }
        if(null != item.getA7_3() && !item.getA7_3().equalsIgnoreCase("null")) {
            holder.a7_3.setText(item.getA7_3());
        }
        if(null != item.getPm() && !item.getPm().equalsIgnoreCase("null")) {
            holder.AIR_PM.setText(item.getPm());
        }
        if(null != item.getRow1() && !item.getRow1().equalsIgnoreCase("null")) {
            holder.row1.setText(item.getRow1());
            holder.p_row1.setVisibility(View.VISIBLE);
        }else{
            holder.p_row1.setVisibility(View.GONE);
        }
        if(null != item.getRow2() && !item.getRow2().equalsIgnoreCase("null")) {
            holder.row2.setText(item.getRow2());
            holder.p_row2.setVisibility(View.VISIBLE);
        }else{
            holder.p_row2.setVisibility(View.GONE);
        }
        if(null != item.getRow3() && !item.getRow3().equalsIgnoreCase("null")) {
            holder.row3.setText(item.getRow3());
            holder.p_row3.setVisibility(View.VISIBLE);
        }else{
            holder.p_row3.setVisibility(View.GONE);
        }
        if(null != item.getRow4() && !item.getRow4().equalsIgnoreCase("null")) {
            holder.row4.setText(item.getRow4());
            holder.p_row4.setVisibility(View.VISIBLE);
        }else{
            holder.p_row4.setVisibility(View.GONE);
        }
        if(null != item.getRow5() && !item.getRow5().equalsIgnoreCase("null")) {
            holder.row5.setText(item.getRow5());
            holder.p_row5.setVisibility(View.VISIBLE);
        }else{
            holder.p_row5.setVisibility(View.GONE);
        }
        if(null != item.getRow6() && !item.getRow6().equalsIgnoreCase("PM2.5")) {
            holder.row6.setText(item.getRow6());
            holder.p_row6.setVisibility(View.VISIBLE);
        }else{
            holder.p_row6.setVisibility(View.GONE);
        }
        if(null != item.getRow7() && !item.getRow7().equalsIgnoreCase("NO2")) {
            holder.row7.setText(item.getRow7());
            holder.p_row7.setVisibility(View.VISIBLE);
        }else{
            holder.p_row7.setVisibility(View.GONE);
        }
        if(item.getLevel_icon()  > 0) {
            if(item.getLevel_icon() == 1) {
                holder.level_icon.setImageResource(R.drawable.aqi_level_1);
                holder.level_title.setText(R.string.aqi_level1);
                holder.level_title.setTextColor(context.getResources().getColor(R.color.aqi_level_1));
            }else if(item.getLevel_icon() == 2){
                holder.level_icon.setImageResource(R.drawable.aqi_level_2);
                holder.level_title.setText(R.string.aqi_level2);
                holder.level_title.setTextColor(context.getResources().getColor(R.color.aqi_level_2));
            }else if(item.getLevel_icon() == 3){
                holder.level_icon.setImageResource(R.drawable.aqi_level_3);
                holder.level_title.setText(R.string.aqi_level3);
                holder.level_title.setTextColor(context.getResources().getColor(R.color.aqi_level_3));
            }else if(item.getLevel_icon() == 4){
                holder.level_icon.setImageResource(R.drawable.aqi_level_4);
                holder.level_title.setText(R.string.aqi_level4);
                holder.level_title.setTextColor(context.getResources().getColor(R.color.aqi_level_4));
            }else if(item.getLevel_icon() == 5){
                holder.level_icon.setImageResource(R.drawable.aqi_level_5);
                holder.level_title.setText(R.string.aqi_level5);
                holder.level_title.setTextColor(context.getResources().getColor(R.color.aqi_level_5));
            }else if(item.getLevel_icon() == 6) {
                holder.level_icon.setImageResource(R.drawable.aqi_level_6);
                holder.level_title.setText(R.string.aqi_level6);
                holder.level_title.setTextColor(context.getResources().getColor(R.color.aqi_level_6));
            }
        }
        return convertView;
    }

    static class ViewHolder {
        ImageView level_icon;
        TextView level_title;
        TextView updated;
        TextView a1_1;
        TextView a1_2;
        TextView a1_3;
        TextView a2_1;
        TextView a2_2;
        TextView a2_3;
        TextView a3_1;
        TextView a3_2;
        TextView a3_3;
        TextView a4_1;
        TextView a4_2;
        TextView a4_3;
        TextView a5_1;
        TextView a5_2;
        TextView a5_3;
        TextView a6_1;
        TextView a6_2;
        TextView a6_3;
        TextView row1;
        TextView row2;
        TextView row3;
        TextView row4;
        TextView row5;
        TextView row6;
        TextView row7;
        TextView a7_1;
        TextView a7_2;
        TextView a7_3;
        TextView AIR_PM;
        TableRow p_row1;
        TableRow p_row2;
        TableRow p_row3;
        TableRow p_row4;
        TableRow p_row5;
        TableRow p_row6;
        TableRow p_row7;
        ViewHolder(View root) {
            AIR_PM= (TextView)root.findViewById(R.id.AIR_PM);
            level_icon= (ImageView)root.findViewById(R.id.AIR_LEVEL);
            level_title= (TextView)root.findViewById(R.id.AIR_STATUS);
            updated= (TextView)root.findViewById(R.id.AIR_UPDATE);
            row1= (TextView)root.findViewById(R.id.row1);
            row2= (TextView)root.findViewById(R.id.row2);
            row3= (TextView)root.findViewById(R.id.row3);
            row4= (TextView)root.findViewById(R.id.row4);
            row5= (TextView)root.findViewById(R.id.row5);
            row6= (TextView)root.findViewById(R.id.row6);
            row7= (TextView)root.findViewById(R.id.row7);
            a1_1= (TextView)root.findViewById(R.id.A1_1);
            a1_2= (TextView)root.findViewById(R.id.A1_2);
            a1_3= (TextView)root.findViewById(R.id.A1_3);
            a2_1= (TextView)root.findViewById(R.id.A2_1);
            a2_2= (TextView)root.findViewById(R.id.A2_2);
            a2_3= (TextView)root.findViewById(R.id.A2_3);
            a3_1= (TextView)root.findViewById(R.id.A3_1);
            a3_2= (TextView)root.findViewById(R.id.A3_2);
            a3_3= (TextView)root.findViewById(R.id.A3_3);
            a4_1= (TextView)root.findViewById(R.id.A4_1);
            a4_2= (TextView)root.findViewById(R.id.A4_2);
            a4_3= (TextView)root.findViewById(R.id.A4_3);
            a5_1= (TextView)root.findViewById(R.id.A5_1);
            a5_2= (TextView)root.findViewById(R.id.A5_2);
            a5_3= (TextView)root.findViewById(R.id.A5_3);
            a6_1= (TextView)root.findViewById(R.id.A6_1);
            a6_2= (TextView)root.findViewById(R.id.A6_2);
            a6_3= (TextView)root.findViewById(R.id.A6_3);
            a7_1= (TextView)root.findViewById(R.id.A7_1);
            a7_2= (TextView)root.findViewById(R.id.A7_2);
            a7_3= (TextView)root.findViewById(R.id.A7_3);
            p_row1= (TableRow)root.findViewById(R.id.p_row1);
            p_row2= (TableRow)root.findViewById(R.id.p_row2);
            p_row3= (TableRow)root.findViewById(R.id.p_row3);
            p_row4= (TableRow)root.findViewById(R.id.p_row4);
            p_row5= (TableRow)root.findViewById(R.id.p_row5);
            p_row6= (TableRow)root.findViewById(R.id.p_row6);
            p_row7= (TableRow)root.findViewById(R.id.p_row7);
        }
    }
}
