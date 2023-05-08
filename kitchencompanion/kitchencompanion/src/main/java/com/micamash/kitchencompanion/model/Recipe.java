package com.micamash.kitchencompanion.model;

public class Recipe {

    private int recipeId;
    private int userId;
    private String recipeName;
    private String cuisineType;
    private String description;
    private int servings;
    private int cookMinutes;
    private String instruction;
    private String imageName;

    public Recipe() {
    }

    public Recipe(int recipeId, int userId, String recipeName, String cuisineType, String description, int servings, int cookMinutes, String instruction, String imageName) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.recipeName = recipeName;
        this.cuisineType = cuisineType;
        this.description = description;
        this.servings = servings;
        this.cookMinutes = cookMinutes;
        this.instruction = instruction;
        this.imageName = imageName;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getCookMinutes() {
        return cookMinutes;
    }

    public void setCookMinutes(int cookMinutes) {
        this.cookMinutes = cookMinutes;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
