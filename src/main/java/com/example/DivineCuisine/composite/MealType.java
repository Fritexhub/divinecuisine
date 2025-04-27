package com.example.DivineCuisine.composite;

import java.util.ArrayList;
import java.util.List;
public class MealType implements MenuComponent {
    private String name;
    private List<MenuComponent> items = new ArrayList<>();

    public MealType(String name) {
        this.name = name;
    }
    public void add(MenuComponent item) {
        items.add(item);
    }
    public List<MenuComponent> getItems() {
        return items;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return 0;
    }
}