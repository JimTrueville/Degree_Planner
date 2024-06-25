package com.c196.degreeplanner.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.c196.degreeplanner.Entities.Courses;
import com.c196.degreeplanner.R;

import org.w3c.dom.Text;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{


    public class CourseViewHolder extends RecyclerView.ViewHolder {
        public final TextView courseItemView;
        public final TextView courseItemView2;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseItemView = itemView.findViewById(R.id.courseTextView);
            courseItemView2 = itemView.findViewById(R.id.associatedTermTextView);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                final Courses current = mCourses.get(position);
                Intent intent = new Intent(context, CourseDetails.class);
                intent.putExtra("name", current.getCourseName());
                intent.putExtra("start date", current.getStartDate());
                intent.putExtra("end date", current.getEndDate());
                intent.putExtra("status", current.getStatus());
                intent.putExtra("notes", current.getNotes());
                context.startActivity(intent);

            });
        }
    }

    private List<Courses> mCourses;
    private final Context context;
    private final LayoutInflater mInflater;

    public CourseAdapter(Context context){
        mInflater= LayoutInflater.from(context);
        this.context= context;
    }

    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= mInflater.inflate(R.layout.course_list_item, parent, false);
        return new CourseAdapter.CourseViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourses!= null){
            Courses current= mCourses.get(position);
            String courseName = current.getCourseName();
            int termID = current.getTermID();
            holder.courseItemView.setText(courseName);
            holder.courseItemView2.setText(Integer.toString(termID));


        }
        else{
            holder.courseItemView.setText("No Course Name");
            holder.courseItemView.setText("No Term ID");

        }

    }

    @Override
    public int getItemCount() {
        if (mCourses!= null){
            return mCourses.size();
        }
        else return 0;
    }

    public void setCourses(List<Courses> courses) {
        mCourses= courses;
        notifyDataSetChanged();
    }
}
