package com.c196.degreeplanner.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.c196.degreeplanner.Entities.Courses;

import java.util.List;

@Dao
public interface CoursesD {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Courses courses);

    @Update
    void update(Courses courses);

    @Delete
    void delete(Courses courses);

    @Query("SELECT * FROM Courses ORDER BY courseID ASC")
    List<Courses> getAllCourses();

    @Query("SELECT * FROM courses WHERE termID = :term ORDER BY CourseID ASC")
    List<Courses> getAssociatedCourses(int term);

}
