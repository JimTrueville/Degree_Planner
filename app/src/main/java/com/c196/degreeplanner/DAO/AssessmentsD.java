package com.c196.degreeplanner.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.c196.degreeplanner.Entities.Assessments;
import java.util.List;

@Dao
public interface AssessmentsD {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Assessments assessments);

    @Update
    void update(Assessments assessments);

    @Delete
    void delete(Assessments assessments);

    @Query("SELECT * FROM Assessments ORDER BY assessmentID ASC")
    List<Assessments> getAllAssessments();

}
