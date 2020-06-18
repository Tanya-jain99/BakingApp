package com.example.android.tanya.bakingapp.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.android.tanya.bakingapp.Fragments.StepFragment;
import com.example.android.tanya.bakingapp.Fragments.VideoFragment;
import com.example.android.tanya.bakingapp.model.Step;

import java.util.ArrayList;

public class VideoFragmentAdapter extends FragmentStatePagerAdapter {
private static final String Description="description";

    public VideoFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        VideoFragment videoFragment=new VideoFragment();
        ArrayList<Step> stepsList=StepFragment.getSteps();
        Bundle bundle=new Bundle();
        bundle.putString(Description,stepsList.get(position).getDescription());
        videoFragment.setArguments(bundle);
        return videoFragment;
    }

    @Override
    public int getCount() {
        return StepFragment.getFragmentCount();
    }
}
