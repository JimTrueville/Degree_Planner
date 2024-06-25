package com.c196.degreeplanner.Entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "courses")

public class Courses {
    @PrimaryKey(autoGenerate = true)
    public int courseID;

    private String courseName;
    private Date startDate;
    private Date endDate;
    private String status;
    private String notes;
    private int termID;

    public Courses(int courseID, String courseName, Date startDate, Date endDate, String status, String notes, int termID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.notes = notes;
        this.termID = termID;
    }

    //Getters
    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public int getTermID() { return termID; }


    //Setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setTermID(int termID) { this.termID = termID;}
}
