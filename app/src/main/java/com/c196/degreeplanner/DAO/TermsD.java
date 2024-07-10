package com.c196.degreeplanner.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.c196.degreeplanner.Entities.Courses;
import com.c196.degreeplanner.Entities.Terms;

import java.util.List;

@Dao
public interface TermsD {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Terms terms);

    @Update
    void update(Terms terms);

    @Delete
    void delete(Terms terms);

    @Query("SELECT * FROM terms ORDER BY termID ASC")
    List<Terms> getAllTerms();

}
