package com.example.android.tanya.bakingapp.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.tanya.bakingapp.R;
import com.example.android.tanya.bakingapp.model.Ingredient;
import java.util.ArrayList;

public class IngridientAdapter extends RecyclerView.Adapter<IngridientAdapter.IngridientVH> {
    private Context ctx;
    private  ArrayList<Ingredient> list=new ArrayList<>();

    public IngridientAdapter(Context ctx, ArrayList<Ingredient> list){
        this.ctx=ctx;
        this.list=list;
    }

    @NonNull
    @Override
    public IngridientVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new IngridientVH(inflater.inflate(R.layout.ingridient_list_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull IngridientVH holder, int position) {
        Ingredient item=list.get(position);
        holder.name.setText(item.getIngredient());
        holder.qty.setText(item.getQuantity()+"");
    }

    public class IngridientVH extends RecyclerView.ViewHolder{
        TextView name,qty;

        public IngridientVH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.ingridientName);
            qty=itemView.findViewById(R.id.ingridientQuantity);
        }
    }
}