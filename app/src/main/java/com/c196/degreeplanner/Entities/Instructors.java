package com.c196.degreeplanner.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "instructors")
public class Instructors {
    @PrimaryKey(autoGenerate = true)
    private int instructorID;

    private String instructorName;
    private String instructorPhone;
    private String instructorEmail;

    //Constructor

    public Instructors(String instructorName, String instructorPhone, String instructorEmail) {
        this.instructorName = instructorName;
        this.instructorPhone = instructorPhone;
        this.instructorEmail = instructorEmail;
    }

    //Getters

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getInstructorPhone() {
        return instructorPhone;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    //Setters

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setInstructorPhone(String instructorPhone) {
        this.instructorPhone = instructorPhone;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }
}
