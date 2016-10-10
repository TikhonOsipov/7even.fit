package com.tixon.a7evenfit.model;

/**
 * Created by tikhon.osipov on 10.10.16
 */
public class Meal {
    private String name;
    private double proteins;
    private double fat;
    private double carbs;
    private double calories;
    private double weight;

    public Meal(String name, double proteins, double fat,
                double carbs, double calories, double weight) {
        this.name = name;
        this.proteins = proteins;
        this.fat = fat;
        this.carbs = carbs;
        this.calories = calories;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}