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

    private List<Courses> mAssociatedCourses;


    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        PlannerDatabaseBuilder db=PlannerDatabaseBuilder.getInstance(application);
        mAssessmentsD = db.assessmentsD();
        mCoursesD = db.coursesD();
        mInstructorsD = db.instructorsD();
        mTermsD = db.termsD();
    }

    public List<Assessments>getAllAssessments(){
        databaseExecutor.execute(() ->
                mAllAssessments = mAssessmentsD.getAllAssessments());
        awaitExecution();
        return mAllAssessments;
    }

    public void insert(Assessments assessments){
        databaseExecutor.execute(()-> mAssessmentsD.insert(assessments));
       awaitExecution();
    }
    public void update(Assessments assessments){
        databaseExecutor.execute(()-> mAssessmentsD.update(assessments));
      awaitExecution();
    }
    public void delete(Assessments assessments){
        databaseExecutor.execute(()-> mAssessmentsD.delete(assessments));
        awaitExecution();
    }
    public List<Courses>getAllCourses(){
        databaseExecutor.execute(()-> mAllCourses = mCoursesD.getAllCourses());
        awaitExecution();
        return mAllCourses;
    }
    public void insert(Courses courses) {
        databaseExecutor.execute(() -> mCoursesD.insert(courses));
        awaitExecution();
    }
    public void update(Courses courses){
        databaseExecutor.execute(()-> mCoursesD.update(courses));
        awaitExecution();
    }
    public void delete(Courses courses){
        databaseExecutor.execute(()-> mCoursesD.delete(courses));
        awaitExecution();
    }

    public List<Courses>getAssociatedCourses(int termId){
        databaseExecutor.execute(()-> mAssociatedCourses = mCoursesD.getAssociatedCourses(termId));
        awaitExecution();
        return mAssociatedCourses;

    }

    public List<Instructors>getAllInstructors(){
        databaseExecutor.execute(()-> mAllInstructors = mInstructorsD.getAllInstructors());
        awaitExecution();
        return mAllInstructors;
    }

    public void insert(Instructors instructors){
        databaseExecutor.execute(()-> mInstructorsD.insert(instructors));
        awaitExecution();
    }
    public void update(Instructors instructors){
        databaseExecutor.execute(()-> mInstructorsD.update(instructors));
        awaitExecution();
    }
    public void delete(Instructors instructors){
        databaseExecutor.execute(()-> mInstructorsD.delete(instructors));
        awaitExecution();
    }
    public List<Terms>getAllTerms(){
        databaseExecutor.execute(()-> mAllTerms = mTermsD.getAllTerms());
        awaitExecution();
        return mAllTerms;
    }
    public void insert(Terms terms){
        databaseExecutor.execute(()-> mTermsD.insert(terms));
        awaitExecution();
    }
    public void update(Terms terms){
        databaseExecutor.execute(()-> mTermsD.update(terms));
        awaitExecution();
    }
    public void delete(Terms terms){
        databaseExecutor.execute(()-> mTermsD.delete(terms));
        awaitExecution();
    }

    private void awaitExecution() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
