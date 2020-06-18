package com.example.android.tanya.bakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.tanya.bakingapp.Fragments.StepFragment;
import com.example.android.tanya.bakingapp.Fragments.VideoFragment;

public class DetailsStepActivity extends AppCompatActivity  {
boolean fragmentCreated=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_step);
        Intent in=getIntent();
        Bundle bundle=in.getExtras();
        if(!fragmentCreated) {
            VideoFragment videoFragment = new VideoFragment();
            videoFragment.setArguments(bundle);
            fragmentCreated = true;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.video_fragment, videoFragment).commit();
        }
    }
}
