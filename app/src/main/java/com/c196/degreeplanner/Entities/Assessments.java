package com.c196.degreeplanner.Entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "assessments")

public class Assessments {

    @PrimaryKey(autoGenerate = true)
    public int assessmentID;

    private String assessmentTittle;
    private String assessmentType;
    private Date startDate;
    private Date endDate;
    private int courseID;
    private int termID;

    public Assessments(String assessmentTittle, String assessmentType, Date startDate, Date endDate, int courseID, int termID) {
        this.assessmentTittle = assessmentTittle;
        this.assessmentType = assessmentType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseID = courseID;
        this.termID = termID;
    }

    //Getters
    public int getAssessmentID() {
        return assessmentID;
    }

    public String getAssessmentTittle() {
        return assessmentTittle;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getTermID() {
        return termID;
    }

    //Setters
    public void setAssessmentTittle(String assessmentTittle) {
        this.assessmentTittle = assessmentTittle;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }
}
