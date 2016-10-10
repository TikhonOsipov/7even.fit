package com.tixon.a7evenfit.screens.nutrition_diary_screen.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tixon.a7evenfit.R;
import com.tixon.a7evenfit.databinding.MealItemViewBinding;
import com.tixon.a7evenfit.model.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tikhon.osipov on 10.10.16
 */
public class MealsRecyclerAdapter extends RecyclerView.Adapter<MealsRecyclerAdapter.MealViewHolder> {
    List<Meal> meals;

    public MealsRecyclerAdapter() {
        this.meals = new ArrayList<>();
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MealItemViewBinding binding = DataBindingUtil.inflate(inflater, R.layout.meal_item_view,
                parent, false);
        return new MealViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        holder.binding.setMeal(meals.get(position));
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder {
        MealItemViewBinding binding;
        public MealViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
