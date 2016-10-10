package com.tixon.a7evenfit.screens.nutrition_diary_screen;

import com.tixon.a7evenfit.model.Meal;
import com.tixon.a7evenfit.screens.base.IBaseView;

import java.util.List;

/**
 * Created by tikhon.osipov on 10.10.16
 */
public interface INutritionDiaryView extends IBaseView {
    void setMeals(List<Meal> meals);
}
