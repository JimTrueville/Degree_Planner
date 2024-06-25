package com.c196.degreeplanner.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "assessments")

public class Assessments {

    @PrimaryKey(autoGenerate = true)

    public int assessmentID;


    private String assessmentTitle;
    private String assessmentType;
    private Date startDate;
    private Date endDate;


    public Assessments(String assessmentTitle, String assessmentType, Date startDate, Date endDate) {
        this.assessmentTitle = assessmentTitle;
        this.assessmentType = assessmentType;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    //Getters
    public int getAssessmentID() {
        return assessmentID;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
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


    //Setters
    public void setAssessmentTitle(String assessmentTitle) {
        this.assessmentTitle = assessmentTitle;
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

}
