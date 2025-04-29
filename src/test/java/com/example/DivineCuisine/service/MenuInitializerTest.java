package com.example.DivineCuisine.service;
import com.example.DivineCuisine.composite.MealType;
import com.example.DivineCuisine.composite.MenuComponent;
import com.example.DivineCuisine.composite.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class MenuInitializerTest {

    private MenuInitializer menuInitializer;

    @BeforeEach
    void setUp() {
        menuInitializer = new MenuInitializer();
        menuInitializer.init();
    }

    @Test
    void testBreakfastMenu() {
        MealType breakfast = menuInitializer.getBreakfast();
        if (breakfast == null) throw new IllegalStateException("Breakfast menu is null");
        if (!"Breakfast".equals(breakfast.getName()))
            throw new IllegalStateException("Expected name 'Breakfast' but got: " + breakfast.getName());

        List<MenuComponent> items = breakfast.getItems();
        if (items.size() != 3)
            throw new IllegalStateException("Expected 3 breakfast items but got: " + items.size());

        MenuItem first = (MenuItem) items.get(0);
        if (!"Pancakes".equals(first.getName()))
            throw new IllegalStateException("Expected first item 'Pancakes' but got: " + first.getName());
        if (Math.abs(first.getPrice() - 5.99) > 0.001)
            throw new IllegalStateException("Expected price 5.99 but got: " + first.getPrice());
    }

    @Test
    void testLunchMenu() {
        MealType lunch = menuInitializer.getLunch();
        if (lunch == null) throw new IllegalStateException("Lunch menu is null");
        if (!"Lunch".equals(lunch.getName()))
            throw new IllegalStateException("Expected name 'Lunch' but got: " + lunch.getName());
        if (lunch.getItems().size() != 2)
            throw new IllegalStateException("Expected 2 lunch items but got: " + lunch.getItems().size());
    }

    @Test
    void testDinnerMenu() {
        MealType dinner = menuInitializer.getDinner();
        if (dinner == null) throw new IllegalStateException("Dinner menu is null");
        if (!"Dinner".equals(dinner.getName()))
            throw new IllegalStateException("Expected name 'Dinner' but got: " + dinner.getName());
        if (dinner.getItems().size() != 3)
            throw new IllegalStateException("Expected 3 dinner items but got: " + dinner.getItems().size());
    }
}
