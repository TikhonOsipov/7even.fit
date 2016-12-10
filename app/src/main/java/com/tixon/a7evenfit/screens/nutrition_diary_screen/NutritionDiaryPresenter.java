package com.tixon.a7evenfit.screens.nutrition_diary_screen;

import com.tixon.a7evenfit.model.Meal;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 10.10.16
 */
public class NutritionDiaryPresenter implements INutritionDiaryPresenter {
    private INutritionDiaryView view;

    @Inject
    public NutritionDiaryPresenter(INutritionDiaryView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Buckheat porridge", 1, 6.4, 1.6, 34.2, 180, 200));
        meals.add(new Meal("Meal 2", 1, 6.4, 1.6, 34.2, 180, 200));

        meals.add(new Meal("Eggs 1", 2, 7.7, 0, 0, 30.3, 3));
        meals.add(new Meal("Eggs 2", 2, 7.7, 0, 0, 30.3, 3));
        meals.add(new Meal("Eggs 3", 2, 7.7, 0, 0, 30.3, 3));

        meals.add(new Meal("Scrambled egg whites", 3, 7.7, 0, 0, 30.3, 3));
        view.setMeals(meals);
    }

    @Override
    public void addMealClicked() {

    }
}
