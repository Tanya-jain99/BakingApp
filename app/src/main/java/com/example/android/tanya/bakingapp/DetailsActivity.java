package com.example.android.tanya.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.tanya.bakingapp.Fragments.IngridientFragment;
import com.example.android.tanya.bakingapp.Fragments.StepFragment;
import com.example.android.tanya.bakingapp.adapter.ViewPagerAdapter;
import com.example.android.tanya.bakingapp.model.Ingredient;
import com.example.android.tanya.bakingapp.model.Recipe;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class DetailsActivity extends AppCompatActivity {
    ViewPager viewpager;
    TabLayout tablayout;
    Toolbar toolbar;
    ViewPagerAdapter viewPagerAdapter;
    Bundle bundle;
    FloatingActionButton fabWidget;
    Intent in;
  public static ArrayList<Ingredient> ingridientWidget=new ArrayList<>();
    private static final String SHARED_PREF="Shared_Prefs";
    private static final String RECIPIE="Recipie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        fabWidget=findViewById(R.id.fab_widget);
        viewpager = findViewById(R.id.viewpager);
        tablayout = findViewById(R.id.tab_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("BakingApp");
        in=getIntent();
        ingridientWidget=in.getParcelableArrayListExtra("Ingredients");
         bundle=in.getExtras();
         final int position=in.getIntExtra("position",0);
         bundle.getParcelableArrayList("Ingridients");
        initUI(viewpager,bundle);
        tablayout.setupWithViewPager(viewpager);
        fabWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("Recipie",position);
                editor.apply();
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(DetailsActivity.this);
                int appWidgetId = bundle.getInt(
                        AppWidgetManager.EXTRA_APPWIDGET_ID,
                        AppWidgetManager.INVALID_APPWIDGET_ID);
                RecipieWidget.updateAppWidget(DetailsActivity.this, appWidgetManager, appWidgetId,
                        bundle.<Ingredient>getParcelableArrayList("Ingridients"));
                Toast.makeText(DetailsActivity.this,"Added to Widegt",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void initUI(ViewPager viewpager,Bundle bundle) {
        FragmentManager fm = getSupportFragmentManager();
        viewPagerAdapter = new ViewPagerAdapter(fm);
        IngridientFragment ingridientFragment =new IngridientFragment();
        ingridientFragment.setArguments(bundle);
        viewPagerAdapter.addFragment(ingridientFragment, "Ingridients");
        StepFragment stepFragment=new StepFragment();
        stepFragment.setArguments(bundle);
        viewPagerAdapter.addFragment(stepFragment, "Steps");
        viewpager.setAdapter(viewPagerAdapter);


//        Fragment fragment = fm.findFragmentById(R.id.viewpager);
//        if (fragment == null) {
//            fragment = new IngridientFragment();
//            fm.beginTransaction()
//                    .add(R.id.viewpager, fragment, "HOME")
//                    .commit();
//        }
    }
public static ArrayList<Ingredient> getIngridients(){
        return  ingridientWidget;
}

}
