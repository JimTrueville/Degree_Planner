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

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{

    private List<Courses> mCourses;
    private final Context context;
    private final LayoutInflater mInflater;

    public CourseAdapter(Context context){
        mInflater= LayoutInflater.from(context);
        this.context= context;
    }



    public class CourseViewHolder extends RecyclerView.ViewHolder {
        public final TextView courseItemView;


        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseItemView = itemView.findViewById(R.id.courseTextView1);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                final Courses current = mCourses.get(position);
                Intent intent = new Intent(context, CourseDetails.class);
                intent.putExtra("name", current.getCourseName());
                context.startActivity(intent);

            });
        }
    }



    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewName) {
        View itemView= mInflater.inflate(R.layout.course_list_item, parent, false);
        return new CourseAdapter.CourseViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourses!= null){
            Courses current= mCourses.get(position);
            String name= current.getCourseName();
            holder.courseItemView.setText(name);
        }
        else{
            holder.courseItemView.setText("No Course Name");
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
