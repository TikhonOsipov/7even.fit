package com.tixon.a7evenfit.screens.nutrition_diary_screen.adapter;

import android.util.SparseArray;

import com.tixon.a7evenfit.model.Meal;
import com.tixon.a7evenfit.ui.IGrouper;

import java.util.List;

/**
 * Created by tikhon.osipov on 16.11.16
 */

public class MealGrouper implements IGrouper<SparseArray<String>> {
    private SparseArray<String> mealSections;
    private List<Meal> meals;

    public MealGrouper(List<Meal> meals) {
        this.meals = meals;
        this.mealSections = new SparseArray<>();
    }

    @Override
    public SparseArray<String> group() {
        int position = 0;
        int mealOrder = -1;

        if(meals == null || meals.isEmpty()) return mealSections;

        for(Meal meal: meals) {
            if(meal.getOrder() > mealOrder) {
                mealOrder = meal.getOrder();
                mealSections.append(position, "meal " + mealOrder);
                position++;
            }
            position++;
        }
        return mealSections;
    }
}
