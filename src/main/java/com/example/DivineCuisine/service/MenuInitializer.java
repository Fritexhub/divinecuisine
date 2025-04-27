package com.example.DivineCuisine.service;

import jakarta.annotation.PostConstruct;
import com.example.DivineCuisine.composite.MealType;
import com.example.DivineCuisine.composite.MenuItem;
import org.springframework.stereotype.Component;

@Component
public class MenuInitializer {
    private MealType breakfast, lunch, dinner;

    @PostConstruct
    public void init() {
        breakfast = new MealType("Breakfast");
        breakfast.add(new MenuItem("Pancakes", 5.99));
        breakfast.add(new MenuItem("ScrambledEggs", 4.50));
        breakfast.add(new MenuItem("FruitSalad", 3.99));

        lunch = new MealType("Lunch");
        lunch.add(new MenuItem("ChickenSandwich", 8.99));
        lunch.add(new MenuItem("VeggieBurger", 7.99));

        dinner = new MealType("Dinner");
        dinner.add(new MenuItem("Carbonara", 12.99));
        dinner.add(new MenuItem("Salmon", 14.50));
        dinner.add(new MenuItem("BeefStirFry", 11.99));
    }

    public MealType getBreakfast() { return breakfast; }
    public MealType getLunch() { return lunch; }
    public MealType getDinner() { return dinner; }
}