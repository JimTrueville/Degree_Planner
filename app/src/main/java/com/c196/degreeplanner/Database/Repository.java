package com.c196.degreeplanner.Database;

import android.app.Application;

import com.c196.degreeplanner.DAO.AssessmentsD;
import com.c196.degreeplanner.DAO.CoursesD;
import com.c196.degreeplanner.DAO.InstructorsD;
import com.c196.degreeplanner.DAO.TermsD;
import com.c196.degreeplanner.Entities.Assessments;
import com.c196.degreeplanner.Entities.Courses;
import com.c196.degreeplanner.Entities.Instructors;
import com.c196.degreeplanner.Entities.Terms;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private AssessmentsD mAssessmentsD;
    private CoursesD mCoursesD;
    private InstructorsD mInstructorsD;
    private TermsD mTermsD;

    private List<Assessments> mAllAssessments;
    private List<Courses> mAllCourses;
    private List<Instructors> mAllInstructors;
    private List<Terms> mAllTerms;

    //Don't forget to add get all associated lists or something like that

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        PlannerDatabaseBuilder db=PlannerDatabaseBuilder.getInstance(application);
        mAssessmentsD = db.assessmentsD();
        mCoursesD = db.coursesD();
        mInstructorsD = db.instructorsD();
        mTermsD = db.termsD();
    }

    public void openDatabase(){
        Terms terms = new Terms("test", new Date(), new Date());
        this.insert(terms);
        this.delete(terms);
    }

    public List<Assessments>getAllAssessments(){
        databaseExecutor.execute(() ->{
            mAllAssessments = mAssessmentsD.getAllAssessments();
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return mAllAssessments;
    }

    public void insert(Assessments assessments){
        databaseExecutor.execute(()->{
            mAssessmentsD.insert(assessments);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void update(Assessments assessments){
        databaseExecutor.execute(()->{
            mAssessmentsD.update(assessments);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete(Assessments assessments){
        databaseExecutor.execute(()->{
            mAssessmentsD.delete(assessments);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<Courses>getAllCourses(){
        databaseExecutor.execute(()->{
            mAllCourses=mCoursesD.getAllCourses();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllCourses;
    }
    public void insert(Courses courses){
        databaseExecutor.execute(()->{
            mCoursesD.insert(courses);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void update(Courses courses){
        databaseExecutor.execute(()->{
            mCoursesD.update(courses);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete(Courses courses){
        databaseExecutor.execute(()->{
            mCoursesD.delete(courses);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Instructors>getAllInstructors(){
        databaseExecutor.execute(()->{
            mAllInstructors=mInstructorsD.getAllInstructors();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllInstructors;
    }

    public void insert(Instructors instructors){
        databaseExecutor.execute(()->{
            mInstructorsD.insert(instructors);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void update(Instructors instructors){
        databaseExecutor.execute(()->{
            mInstructorsD.update(instructors);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete(Instructors instructors){
        databaseExecutor.execute(()->{
            mInstructorsD.delete(instructors);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<Terms>getAllTerms(){
        databaseExecutor.execute(()->{
            mAllTerms=mTermsD.getAllTerms();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllTerms;
    }
    public void insert(Terms terms){
        databaseExecutor.execute(()->{
            mTermsD.insert(terms);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void update(Terms terms){
        databaseExecutor.execute(()->{
            mTermsD.update(terms);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete(Terms terms){
        databaseExecutor.execute(()->{
            mTermsD.delete(terms);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
