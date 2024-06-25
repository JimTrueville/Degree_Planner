package com.c196.degreeplanner.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.c196.degreeplanner.Entities.Terms;
import com.c196.degreeplanner.R;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder>{

    private List<Terms> mTerms;
    private final Context context;
    private final LayoutInflater mInflater;


    public TermAdapter(Context context){
        mInflater= LayoutInflater.from(context);
        this.context= context;

    }

    public class TermViewHolder extends RecyclerView.ViewHolder {
        public final TextView termItemView;

        public TermViewHolder(@NonNull View itemView) {
            super(itemView);
            termItemView= itemView.findViewById(R.id.termTextView);
            itemView.setOnClickListener(view -> {
                int position= getAdapterPosition();
                final Terms current= mTerms.get(position);
                Intent intent= new Intent(context, TermDetails.class);
                intent.putExtra("title", current.getTermTitle());
                intent.putExtra("start date", current.getStartDate());
                intent.putExtra("end date", current.getEndDate());
                context.startActivity(intent);
            });
        }

    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermAdapter.TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if(mTerms!= null){
            Terms current= mTerms.get(position);
            String tittle = current.getTermTitle();
            holder.termItemView.setText(tittle);

        }else{
            holder.termItemView.setText("No Term Title");
        }

    }

    @Override
    public int getItemCount() {
        if (mTerms!= null){
            return mTerms.size();
        }
        else return 0;
    }

    public void setTerms(List<Terms> terms){
        mTerms= terms;
        notifyDataSetChanged();
    }
}
