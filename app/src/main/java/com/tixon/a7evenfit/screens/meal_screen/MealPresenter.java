package com.tixon.a7evenfit.screens.meal_screen;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 04.12.16
 */

public class MealPresenter implements IMealPresenter {
    private IMealView view;

    @Inject
    public MealPresenter(IMealView view) {
        this.view = view;
    }
}
