package com.tixon.a7evenfit.screens.nutrition_diary_screen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.tixon.a7evenfit.R;
import com.tixon.a7evenfit.dagger.components.DaggerIScreensComponent;
import com.tixon.a7evenfit.dagger.components.IAppComponent;
import com.tixon.a7evenfit.dagger.components.IScreensComponent;
import com.tixon.a7evenfit.dagger.modules.ScreensModule;
import com.tixon.a7evenfit.databinding.ActivityNutritionDiaryBinding;
import com.tixon.a7evenfit.model.Meal;
import com.tixon.a7evenfit.screens.base.BaseActivity;
import com.tixon.a7evenfit.screens.nutrition_diary_screen.adapter.MealGrouper;
import com.tixon.a7evenfit.screens.nutrition_diary_screen.adapter.MealsRecyclerAdapter;
import com.tixon.a7evenfit.ui.SectionedRecyclerAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 10.10.16
 */
public class NutritionDiaryActivity extends BaseActivity implements INutritionDiaryView {
    IScreensComponent component;
    ActivityNutritionDiaryBinding binding;

    private MealsRecyclerAdapter adapter;
    private SectionedRecyclerAdapter sectionedAdapter;

    @Inject
    NutritionDiaryPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nutrition_diary);
        adapter = new MealsRecyclerAdapter();

        binding.nutritionList.setLayoutManager(new LinearLayoutManager(this));
        presenter.onCreate();

        //binding.nutritionList.setAdapter(adapter);
    }

    ///////////////////////////////////////////////////////////////////////////
    // UI
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void setMeals(List<Meal> meals) {
        adapter.setMeals(meals);
        sectionedAdapter = new SectionedRecyclerAdapter(adapter);
        binding.nutritionList.setAdapter(sectionedAdapter);
        sectionedAdapter.setGrouper(new MealGrouper(meals));
    }

    ///////////////////////////////////////////////////////////////////////////
    // BaseActivity abstract implemented methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected void setupComponent(IAppComponent appComponent) {
        component = DaggerIScreensComponent.builder()
                .iAppComponent(appComponent)
                .screensModule(new ScreensModule(this))
                .build();
        component.inject(this);
    }
}
