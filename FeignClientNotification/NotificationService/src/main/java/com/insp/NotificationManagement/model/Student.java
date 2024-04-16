package com.insp.NotificationManagement.model;

import java.util.List;

public class Student {
    private  int id;
    private String studentName;
    private String address;
    private long pincode;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getPincode() {
        return pincode;
    }
    public void setPincode(long pincode) {
        this.pincode = pincode;
    }


}
