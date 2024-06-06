package com.c196.degreeplanner.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.c196.degreeplanner.DAO.AssessmentsD;
import com.c196.degreeplanner.DAO.CoursesD;
import com.c196.degreeplanner.DAO.InstructorsD;
import com.c196.degreeplanner.DAO.TermsD;
import com.c196.degreeplanner.Entities.Assessments;
import com.c196.degreeplanner.Entities.Courses;
import com.c196.degreeplanner.Entities.Instructors;
import com.c196.degreeplanner.Entities.Terms;

@Database(entities = {Assessments.class, Courses.class, Instructors.class, Terms.class},version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})

public abstract class PlannerDatabaseBuilder extends RoomDatabase {


    public abstract AssessmentsD assessmentsD();
    public abstract CoursesD coursesD();
    public abstract InstructorsD instructorsD();
    public abstract TermsD termsD();
    private static volatile PlannerDatabaseBuilder INSTANCE;


    public static synchronized PlannerDatabaseBuilder getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (PlannerDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PlannerDatabaseBuilder.class, "DegreePlannerDatabase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
