package com.c196.degreeplanner.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.c196.degreeplanner.Entities.Assessments;
import com.c196.degreeplanner.R;
import java.util.List;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder> {

    private List<Assessments> mAssessments;
    private final Context context;
    private final LayoutInflater mInflater;

    public AssessmentAdapter(Context context){
        mInflater= LayoutInflater.from(context);
        this.context= context;
    }



    public class AssessmentViewHolder extends RecyclerView.ViewHolder {
        public final TextView assessmentItemView;


        public AssessmentViewHolder(@NonNull View itemView) {
            super(itemView);
            assessmentItemView= itemView.findViewById(R.id.assessmentTextView);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                final Assessments current = mAssessments.get(position);
                Intent intent = new Intent(context, AssessmentDetails.class);
                intent.putExtra("title", current.getAssessmentTitle());
                intent.putExtra("type", current.getAssessmentType());
                intent.putExtra("start date", current.getStartDate());
                intent.putExtra("end date", current.getEndDate());
                context.startActivity(intent);

            });
        }
    }



    @NonNull
    @Override
    public AssessmentAdapter.AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= mInflater.inflate(R.layout.assessment_list_item, parent, false);
        return new AssessmentViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull AssessmentAdapter.AssessmentViewHolder holder, int position) {
        if(mAssessments!= null){
            Assessments current= mAssessments.get(position);
            String type= current.getAssessmentType();
            holder.assessmentItemView.setText(type);
        }
        else{
            holder.assessmentItemView.setText("No Assessment Title");
        }

    }

    @Override
    public int getItemCount() {
        if (mAssessments!= null){
            return mAssessments.size();
        }
        else return 0;
    }

    public void setAssessments(List<Assessments> assessments) {
        mAssessments= assessments;
        notifyDataSetChanged();
    }

}
