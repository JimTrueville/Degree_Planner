package com.c196.degreeplanner.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.c196.degreeplanner.Entities.Instructors;

import java.util.List;

@Dao
public interface InstructorsD{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Instructors instructors);

    @Update
    void update(Instructors instructors);

    @Delete
    void delete(Instructors instructors);

    @Query("SELECT * FROM Instructors ORDER BY instructorID ASC")
    List<Instructors> getAllInstructors();

}
