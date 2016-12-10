package com.tixon.a7evenfit.dagger.modules;

import com.tixon.a7evenfit.dagger.scopes.ActivityScope;
import com.tixon.a7evenfit.screens.main_screen.IMainPresenter;
import com.tixon.a7evenfit.screens.main_screen.IMainView;
import com.tixon.a7evenfit.screens.main_screen.MainPresenter;
import com.tixon.a7evenfit.screens.meal_screen.IMealPresenter;
import com.tixon.a7evenfit.screens.meal_screen.IMealView;
import com.tixon.a7evenfit.screens.meal_screen.MealPresenter;
import com.tixon.a7evenfit.screens.new_diary_record_screen.INewDiaryRecordPresenter;
import com.tixon.a7evenfit.screens.new_diary_record_screen.INewDiaryRecordView;
import com.tixon.a7evenfit.screens.new_diary_record_screen.NewDiaryRecordPresenter;
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
    private INewDiaryRecordView newDiaryRecordView;
    private IMealView mealView;

    public ScreensModule(IMainView view) {
        this.mainView = view;
    }

    public ScreensModule(INutritionDiaryView nutritionDiaryView) {
        this.nutritionDiaryView = nutritionDiaryView;
    }

    public ScreensModule(INewDiaryRecordView newDiaryRecordView) {
        this.newDiaryRecordView = newDiaryRecordView;
    }

    public ScreensModule(IMealView mealView) {
        this.mealView = mealView;
    }

    @Provides
    @ActivityScope
    public IMainView provideMainView() {
        return mainView;
    }

    @Provides
    @ActivityScope
    public INutritionDiaryView provideNutritionDiaryView() {
        return nutritionDiaryView;
    }

    @Provides
    @ActivityScope
    public IMainPresenter provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    public INutritionDiaryPresenter provideNutritionDiaryPresenter(NutritionDiaryPresenter presenter) {
        return presenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // NewDiaryRecord activity
    ///////////////////////////////////////////////////////////////////////////
    @Provides
    @ActivityScope
    public INewDiaryRecordView provideNewDiaryRecordView() {
        return this.newDiaryRecordView;
    }
    @Provides
    @ActivityScope
    public INewDiaryRecordPresenter provideNewDiaryRecordPresenter(NewDiaryRecordPresenter presenter) {
        return presenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Meal activity
    ///////////////////////////////////////////////////////////////////////////
    @Provides
    @ActivityScope
    public IMealView provideMealView() {
        return this.mealView;
    }
    @Provides
    @ActivityScope
    public IMealPresenter provideMealPresenter(MealPresenter presenter) {
        return presenter;
    }
}
