package com.micamash.kitchencompanion.model;

import java.time.LocalDate;

public class MealPlan {

    private int mealPlanId;
    private int userId;
    private String name;
    private LocalDate dateCreated;

    public MealPlan() {
    }

    public MealPlan(int mealPlanId, int userId, String name, LocalDate dateCreated) {
        this.mealPlanId = mealPlanId;
        this.userId = userId;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
