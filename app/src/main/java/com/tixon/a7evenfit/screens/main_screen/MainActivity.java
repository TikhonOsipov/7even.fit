package com.tixon.a7evenfit.screens.main_screen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.CalendarView;

import com.tixon.a7evenfit.R;
import com.tixon.a7evenfit.dagger.components.DaggerIScreensComponent;
import com.tixon.a7evenfit.dagger.components.IAppComponent;
import com.tixon.a7evenfit.dagger.components.IScreensComponent;
import com.tixon.a7evenfit.dagger.modules.ScreensModule;
import com.tixon.a7evenfit.databinding.ActivityMainBinding;
import com.tixon.a7evenfit.screens.base.BaseActivity;

import javax.inject.Inject;

import static android.R.attr.y;

public class MainActivity extends BaseActivity implements IMainView {
    IScreensComponent component;
    ActivityMainBinding binding;

    @Inject
    IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //presenter.onCreate();

        binding.calendarNutrition.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView,
                                            int year, int month, int day) {
                //Log.d("myLogs", "year: " + year + " month: " + (month+1) + " day: " + day + "'");
                presenter.onDateSelected(year, month, day);
            }
        });
    }

    @Override
    protected void setupComponent(IAppComponent appComponent) {
        component = DaggerIScreensComponent.builder()
                .iAppComponent(appComponent)
                .screensModule(new ScreensModule(this))
                .build();
        component.inject(this);
    }
}
