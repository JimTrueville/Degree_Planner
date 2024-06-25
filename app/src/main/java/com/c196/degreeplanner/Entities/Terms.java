package com.c196.degreeplanner.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "terms")

public class Terms {

    @PrimaryKey(autoGenerate = true)
    public int termID;

    private String termTitle;

    private Date startDate;

    private Date endDate;


    //Constructor

    public Terms(String termTitle, Date startDate, Date endDate) {
        this.termTitle = termTitle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //Getters

    public int getTermID() {
        return termID;
    }

    public String getTermTitle() {
        return termTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    //Setters

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public void setTermTitle(String termTitle) {
        this.termTitle = termTitle;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
