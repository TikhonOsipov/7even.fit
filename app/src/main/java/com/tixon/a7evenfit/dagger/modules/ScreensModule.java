package com.tixon.a7evenfit.dagger.modules;

import com.tixon.a7evenfit.dagger.scopes.ActivityScope;
import com.tixon.a7evenfit.screens.main_screen.IMainPresenter;
import com.tixon.a7evenfit.screens.main_screen.IMainView;
import com.tixon.a7evenfit.screens.main_screen.MainPresenter;
import com.tixon.a7evenfit.screens.nutrition_diary_screen.INutritionDiaryPresenter;
import com.tixon.a7evenfit.screens.nutrition_diary_screen.INutritionDiaryView;
import com.tixon.a7evenfit.screens.nutrition_diary_screen.NutritionDiaryPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tikhon.osipov on 08.10.16
 */
@Module
public class ScreensModule {
    private IMainView mainView;
    private INutritionDiaryView nutritionDiaryView;

    public ScreensModule(IMainView view) {
        this.mainView = view;
    }

    public ScreensModule(INutritionDiaryView nutritionDiaryView) {
        this.nutritionDiaryView = nutritionDiaryView;
    }

    @Provides
    public IMainView provideMainView() {
        return mainView;
    }

    @Provides
    public INutritionDiaryView provideNutritionDiaryView() {
        return nutritionDiaryView;
    }

    @Provides
    @ActivityScope
    public IMainPresenter provideMainPresenter() {
        return new MainPresenter(mainView);
    }

    @Provides
    @ActivityScope
    public INutritionDiaryPresenter provideNutritionDiaryPresenter() {
        return new NutritionDiaryPresenter(nutritionDiaryView);
    }
}
