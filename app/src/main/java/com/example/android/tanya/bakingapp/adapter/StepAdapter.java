package com.example.android.tanya.bakingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.tanya.bakingapp.R;
import com.example.android.tanya.bakingapp.model.Step;
import java.util.ArrayList;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepVH>  {
    private Context ctx;
    private  ArrayList<Step> list=new ArrayList<>();
    OnClickListener onClickListener;

    public StepAdapter(Context ctx, ArrayList<Step> list,OnClickListener onclick){
        this.ctx=ctx;
        this.list=list;
        this.onClickListener=onclick;
    }

    @NonNull
    @Override
    public StepVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new StepVH(inflater.inflate(R.layout.step_list_item, parent, false),onClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull StepVH holder, int position) {
        Step item=list.get(position);
        holder.name.setText(position+" "+item.getShortDescription());
    }



    public class StepVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        OnClickListener onClickListener;

        public StepVH(@NonNull View itemView,OnClickListener onclick) {
            super(itemView);
            name=itemView.findViewById(R.id.stepdesc);
            this.onClickListener=onclick;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
          int adapterposition=getAdapterPosition();
          onClickListener.click(adapterposition);
        }

    }
    public interface OnClickListener{
        void click(int pocition);
    }
}
