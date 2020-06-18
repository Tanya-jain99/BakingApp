package com.example.android.tanya.bakingapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.android.tanya.bakingapp.Fragments.IngridientFragment;
import com.example.android.tanya.bakingapp.model.Ingredient;
import com.example.android.tanya.bakingapp.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of App Widget functionality.
 */

public class RecipieWidget extends AppWidgetProvider {
static ArrayList<Ingredient> list=new ArrayList<>();
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, ArrayList<Ingredient> ingredientList) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.recipie_widget);
      views.removeAllViews(R.id.widget_ingredients_container);
        for (Ingredient ingredient : ingredientList) {
            RemoteViews ingredientView = new RemoteViews(context.getPackageName(),
                    R.layout.widget_item);
            Log.d("hello",ingredient.getIngredient());
            ingredientView.setTextViewText(R.id.ingredient_widget,
                    ingredient.getIngredient() + " " +
                            ingredient.getMeasure());
            views.addView(R.id.widget_ingredients_container, ingredientView);
        }

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("SHARED_PREFS",Context.MODE_PRIVATE);
        list.addAll(IngridientFragment.getIngredients());
        Log.d("size",list.get(0).getIngredient()+"");
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId,list);
        }
    }

    @Override
    public void onEnabled(Context context) {
        Toast.makeText(context,"widget",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

