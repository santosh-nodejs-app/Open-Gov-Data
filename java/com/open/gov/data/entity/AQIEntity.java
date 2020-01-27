package com.open.gov.data.entity;

import com.open.gov.data.R;

public class AQIEntity {

    String state;
    String city;
    String station;
    int level_icon = 0;
    String level_title;
    String updated;
    String a1_1;
    String a1_2;
    String a1_3;
    String a2_1;
    String a2_2;
    String a2_3;
    String a3_1;
    String a3_2;
    String a3_3;
    String a4_1;
    String a4_2;
    String a4_3;
    String a5_1;
    String a5_2;
    String a5_3;
    String a6_1;
    String a6_2;
    String a6_3;
    String row1;
    String row2;
    String row3;
    String row4;
    String row5;
    String row6;
    String a7_1;
    String a7_2;
    String a7_3;
    String row7;
    String pm;

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = "Prominent Pollutant is "+pm;
    }

    public String getRow7() {
        return row7;
    }

    public void setRow7(String row7) {
        this.row7 = row7;
    }

    public String getA7_1() {
        return a7_1;
    }

    public void setA7_1(String a7_1) {
        this.a7_1 = a7_1;
    }

    public String getA7_2() {
        return a7_2;
    }

    public void setA7_2(String a7_2) {
        this.a7_2 = a7_2;
    }

    public String getA7_3() {
        return a7_3;
    }

    public void setA7_3(String a7_3) {
        this.a7_3 = a7_3;
    }

    public String getRow1() {
        return row1;
    }

    public void setRow1(String row1) {
        this.row1 = row1;
    }

    public String getRow2() {
        return row2;
    }

    public void setRow2(String row2) {
        this.row2 = row2;
    }

    public String getRow3() {
        return row3;
    }

    public void setRow3(String row3) {
        this.row3 = row3;
    }

    public String getRow4() {
        return row4;
    }

    public void setRow4(String row4) {
        this.row4 = row4;
    }

    public String getRow5() {
        return row5;
    }

    public void setRow5(String row5) {
        this.row5 = row5;
    }

    public String getRow6() {
        return row6;
    }

    public void setRow6(String row6) {
        this.row6 = row6;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getLevel_icon() {
        return level_icon;
    }

    public void setLevel_icon(int level_icon) {
        this.level_icon = level_icon;
    }

    public String getLevel_title() {
        return level_title;
    }

    public void setLevel_title(String level_title) {
        this.level_title = level_title;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getA1_1() {
        return a1_1;
    }

    public void setA1_1(String a1_1) {
        this.a1_1 = a1_1;
    }

    public String getA1_2() {
        return a1_2;
    }

    public void setA1_2(String a1_2) {
        this.a1_2 = a1_2;
    }

    public String getA1_3() {
        return a1_3;
    }

    public void setA1_3(String a1_3) {
        if(null != a1_3 && !a1_3.equalsIgnoreCase("NA")){
        int i = Integer.parseInt(a1_3);
        if (i <= 50) {
            this.setLevel_icon(1);
        } else if (i <= 100) {
            this.setLevel_icon(2);
        } else if (i <= 150) {
            this.setLevel_icon(3);
        } else if (i <= 200) {
            this.setLevel_icon(4);
        } else if (i <= 300) {
            this.setLevel_icon(5);
        } else if (i <= 400) {
            this.setLevel_icon(6);
        }
    }
        this.a1_3 = a1_3;
    }

    public String getA2_1() {
        return a2_1;
    }

    public void setA2_1(String a2_1) {
        this.a2_1 = a2_1;
    }

    public String getA2_2() {
        return a2_2;
    }

    public void setA2_2(String a2_2) {
        this.a2_2 = a2_2;
    }

    public String getA2_3() {
        return a2_3;
    }

    public void setA2_3(String a2_3) {
        if(null != a2_3 && null != this.getRow2() && this.getRow2().equalsIgnoreCase("PM10")){
            int i = Integer.parseInt(a2_3);
            if(i <= 50 ){
                this.setLevel_icon(1);
            }else if(i <= 100 ){
                this.setLevel_icon(2);
            }else if(i <= 150 ){
                this.setLevel_icon(3);
            }else if(i <= 200 ){
                this.setLevel_icon(4);
            }else if(i <= 300 ){
                this.setLevel_icon(5);
            }else if(i <= 400 ){
                this.setLevel_icon(6);
            }
        }
        this.a2_3 = a2_3;
    }

    public String getA3_1() {
        return a3_1;
    }

    public void setA3_1(String a3_1) {
        this.a3_1 = a3_1;
    }

    public String getA3_2() {
        return a3_2;
    }

    public void setA3_2(String a3_2) {
        this.a3_2 = a3_2;
    }

    public String getA3_3() {
        return a3_3;
    }

    public void setA3_3(String a3_3) {
        this.a3_3 = a3_3;
    }

    public String getA4_1() {
        return a4_1;
    }

    public void setA4_1(String a4_1) {
        this.a4_1 = a4_1;
    }

    public String getA4_2() {
        return a4_2;
    }

    public void setA4_2(String a4_2) {
        this.a4_2 = a4_2;
    }

    public String getA4_3() {
        return a4_3;
    }

    public void setA4_3(String a4_3) {
        if(null != a4_3 && this.getLevel_icon() == 0 && null != this.getRow4() && this.getRow4().equalsIgnoreCase("CO")){
            int i = Integer.parseInt(a4_3);
            if(i <= 50 ){
                this.setLevel_icon(1);
            }else if(i <= 100 ){
                this.setLevel_icon(2);
            }else if(i <= 150 ){
                this.setLevel_icon(3);
            }else if(i <= 200 ){
                this.setLevel_icon(4);
            }else if(i <= 300 ){
                this.setLevel_icon(5);
            }else if(i <= 400 ){
                this.setLevel_icon(6);
            }
        }
        this.a4_3 = a4_3;
    }

    public String getA5_1() {
        return a5_1;
    }

    public void setA5_1(String a5_1) {
        this.a5_1 = a5_1;
    }

    public String getA5_2() {
        return a5_2;
    }

    public void setA5_2(String a5_2) {
        this.a5_2 = a5_2;
    }

    public String getA5_3() {
        return a5_3;
    }

    public void setA5_3(String a5_3) {
        this.a5_3 = a5_3;
    }

    public String getA6_1() {
        return a6_1;
    }

    public void setA6_1(String a6_1) {
        this.a6_1 = a6_1;
    }

    public String getA6_2() {
        return a6_2;
    }

    public void setA6_2(String a6_2) {
        this.a6_2 = a6_2;
    }

    public String getA6_3() {
        return a6_3;
    }

    public void setA6_3(String a6_3) {
        this.a6_3 = a6_3;
    }
}
