package com.tixon.a7evenfit.screens.main_screen;

import com.tixon.a7evenfit.screens.nutrition_diary_screen.NutritionDiaryActivity;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 08.10.16
 */
public class MainPresenter implements IMainPresenter {
    IMainView view;

    @Inject
    public MainPresenter(IMainView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.startView(NutritionDiaryActivity.class);
    }

    @Override
    public void onDateSelected(int year, int month, int day) {
        view.startView(NutritionDiaryActivity.class);
    }
}
