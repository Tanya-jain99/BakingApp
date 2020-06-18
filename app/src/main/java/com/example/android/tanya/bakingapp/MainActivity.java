package com.example.android.tanya.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.android.tanya.bakingapp.Fragments.IngridientFragment;
import com.example.android.tanya.bakingapp.adapter.RecipieAdapter;
import com.example.android.tanya.bakingapp.model.Ingredient;
import com.example.android.tanya.bakingapp.model.Recipe;
import com.example.android.tanya.bakingapp.model.Step;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecipieAdapter.OnClickListener  {
private ArrayList<Recipe> Recipies=new ArrayList<>();
RecipieAdapter RecipieStore;
RecyclerView dishList;


public static final String INGRIDIENTS="Ingridients";
    public static final String STEPS="Steps";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dishList=findViewById(R.id.recipieList);
        RecipieStore=new RecipieAdapter(this,Recipies,this);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        dishList.setLayoutManager(manager);
        DividerItemDecoration decoration=new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        dishList.addItemDecoration(decoration);
        dishList.setAdapter(RecipieStore);

        getRecipies();
    }
    private void getRecipies(){
        Call<List<Recipe>> recipies= ApiClient.getInstance().getRecipie().getDetails();
        recipies.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null)
                 Recipies.addAll(response.body());
                    RecipieStore.notifyDataSetChanged();
                }
                else
                    Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.d("error",t.getMessage()+"");
            }
        });
    }




    @Override
    public void click(int pocition) {
        Recipe recipie=Recipies.get(pocition);

        ArrayList<Ingredient> ingredientArrayList=new ArrayList<>(recipie.getIngredients());
        ArrayList<Step> stepArrayList=new ArrayList<>(recipie.getSteps());
        Intent in=new Intent(this, DetailsActivity.class);
        in.putParcelableArrayListExtra(INGRIDIENTS,ingredientArrayList);
        Bundle bundle=new Bundle();
        bundle.putParcelableArrayList(INGRIDIENTS,ingredientArrayList);
        bundle.putParcelableArrayList(STEPS,stepArrayList);
        in.putExtras(bundle);
        in.putExtra("position",pocition);
        startActivity(in);
    }

}
