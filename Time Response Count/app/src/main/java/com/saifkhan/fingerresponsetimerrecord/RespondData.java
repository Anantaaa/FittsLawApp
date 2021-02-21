package com.saifkhan.fingerresponsetimerrecord;

import java.util.List;

public class RespondData {
    private String age;
    private String gender;
    private List timearray,timearray2,widthList,amplitudeList;

    public RespondData()
    {

    }
    public RespondData(String age, String gender, List<String> timearray, List<String> timearray2, List<Integer> widthList,List<List> amplitudeList) {
        this.age = age;
        this.gender=gender;
        this.timearray = timearray;
        this.timearray2 = timearray2;
        this.widthList=widthList;
        this.amplitudeList=amplitudeList;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List gettimeArray() {
        return timearray;
    }

    public void settimeArray(List timearray) {
        this.timearray = timearray;
    }

    public List getWidthList() {
        return widthList;
    }

    public void setWidthList(List widthList) {
        this.widthList= widthList;
    }
}
