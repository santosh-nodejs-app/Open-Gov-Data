package com.open.gov.data.entity;

public class DatasetAPIEntity {

    int id = 0;
    String title;
    String desc;
    String sector;
    String createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = "Sector : "+sector;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = "Created : " + createdDate;
    }


}
