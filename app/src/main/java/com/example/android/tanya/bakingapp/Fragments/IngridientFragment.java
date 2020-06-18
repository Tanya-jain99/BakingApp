package com.example.android.tanya.bakingapp.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tanya.bakingapp.R;
import com.example.android.tanya.bakingapp.adapter.IngridientAdapter;
import com.example.android.tanya.bakingapp.adapter.StepAdapter;
import com.example.android.tanya.bakingapp.model.Ingredient;

import java.util.ArrayList;


public class IngridientFragment extends Fragment {

    public IngridientFragment() {
        // Required empty public constructor
    }
   private IngridientAdapter ingridientAdapter;
    private RecyclerView mIngridientList;
    private static ArrayList<Ingredient> items=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_ingridients, container, false);
        mIngridientList=view.findViewById(R.id.ingridientList);
        Bundle bundle=getArguments();
        if(bundle!=null)

        items=bundle.getParcelableArrayList("Ingridients");

        ingridientAdapter=new IngridientAdapter(getContext(),items);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        mIngridientList.setLayoutManager(manager);
        mIngridientList.setAdapter(ingridientAdapter);
        return view;
    }
public static ArrayList<Ingredient> getIngredients(){
        return items;
}



}