package com.example.android.tanya.bakingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.tanya.bakingapp.DetailsActivity;
import com.example.android.tanya.bakingapp.R;
import com.example.android.tanya.bakingapp.model.Recipe;

import java.util.ArrayList;

public class RecipieAdapter extends RecyclerView.Adapter<RecipieAdapter.RecipieViewHolder> {
    Context ctx;
    ArrayList<Recipe> list=new ArrayList<>();
    OnClickListener onClickListener;
public RecipieAdapter(Context ctx, ArrayList<Recipe> list,OnClickListener onClickListener){
    this.ctx=ctx;
    this.list=list;
    this.onClickListener=onClickListener;
}
    @NonNull
    @Override
    public  RecipieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)

    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new RecipieViewHolder(inflater.inflate(R.layout.recipie_listitem, parent, false),onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipieViewHolder holder, int position) {
      Recipe item=list.get(position);
      holder.name.setText(item.getName());
        switch(position) {
            case 0:
                holder.thumbnail.setImageDrawable(ctx.getResources().getDrawable(R.drawable.nutellapie));
                break;
            case 1: holder.thumbnail.setImageDrawable(ctx.getResources().getDrawable(R.drawable.brownies));
                break;
            case 2: holder.thumbnail.setImageDrawable(ctx.getResources().getDrawable(R.drawable.yellowcake));
                break;
            case 3: holder.thumbnail.setImageDrawable(ctx.getResources().getDrawable(R.drawable.cheesecake));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecipieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name;
        ImageView thumbnail;
    OnClickListener onclick;
        public RecipieViewHolder(@NonNull View itemView,OnClickListener onclick) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.onclick=onclick;
            thumbnail=itemView.findViewById(R.id.bakingRecipie);
            name=itemView.findViewById(R.id.Recipie_name);
        }

        @Override
        public void onClick(View view) {
        onclick.click(getAdapterPosition());
        }
    }
        public interface OnClickListener{
        void click(int pocition);
        }
        public void setImageRes(int position){


         }
        }


