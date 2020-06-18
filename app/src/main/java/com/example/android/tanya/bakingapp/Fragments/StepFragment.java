package com.example.android.tanya.bakingapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tanya.bakingapp.DetailsActivity;
import com.example.android.tanya.bakingapp.DetailsStepActivity;
import com.example.android.tanya.bakingapp.R;
import com.example.android.tanya.bakingapp.adapter.StepAdapter;
import com.example.android.tanya.bakingapp.model.Step;

import java.util.ArrayList;


public class StepFragment extends Fragment implements StepAdapter.OnClickListener{


    public StepFragment() {
        // Required empty public constructor
    }

RecyclerView StepsList;
 static ArrayList<Step> steps;
StepAdapter stepAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_steps, container, false);
        StepsList=view.findViewById(R.id.StepList);
        Bundle bundle=getArguments();
        if(bundle!=null)
        steps=bundle.getParcelableArrayList("Steps");
        stepAdapter=new StepAdapter(getContext(),steps,this);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        StepsList.setLayoutManager(manager);
        StepsList.setAdapter(stepAdapter);
        return view;
    }
    public static int getFragmentCount(){
        return steps.size();
    }
    public static ArrayList<Step> getSteps(){
        return steps;
    }


    @Override
    public void click(int pocition) {
        Log.d("Clicked",pocition+"");
        Intent in=new Intent(getContext(), DetailsStepActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("step",steps.get(pocition));
        in.putExtras(bundle);
        startActivity(in);
    }
}
