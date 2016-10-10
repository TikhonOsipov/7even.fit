package com.tixon.a7evenfit.dagger.components;

import com.tixon.a7evenfit.dagger.modules.ScreensModule;
import com.tixon.a7evenfit.screens.main_screen.MainActivity;
import com.tixon.a7evenfit.screens.nutrition_diary_screen.NutritionDiaryActivity;

import dagger.Component;

/**
 * Created by tikhon.osipov on 08.10.16
 */
@Component(dependencies = {IAppComponent.class}, modules = {ScreensModule.class})
public interface IScreensComponent {
    void inject(MainActivity activity);
    void inject(NutritionDiaryActivity activity);
}
