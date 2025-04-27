
package com.example.DivineCuisine.controller;

import com.example.DivineCuisine.composite.MenuComponent;
import com.example.DivineCuisine.model.Order;
import com.example.DivineCuisine.repository.OrderRepository;
import com.example.DivineCuisine.service.MenuInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    private final MenuInitializer menuInitializer;
    private final OrderRepository orderRepository;

    public OrderController(MenuInitializer menuInitializer, OrderRepository orderRepository) {
        this.menuInitializer = menuInitializer;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/submitOrder")
    public String submitOrder(@RequestParam String mealType,
                              @RequestParam String menuItem,
                              Model model) {

        MenuComponent selectedItem = findMenuItemByName(mealType, menuItem);
        if (selectedItem == null) {
            model.addAttribute("error", "Invalid menu item.");
            return "menu";
        }

        double price = selectedItem.getPrice();
        Order order = new Order();
        order.setMealType(mealType);
        order.setItemName(selectedItem.getName());
        order.setPrice(price);

        System.out.println("Mealtype: "+mealType+"\nMenuItem: "+ menuItem);

        orderRepository.save(order);
        model.addAttribute("item", selectedItem);
        return "orderConfirmation";
    }

        private MenuComponent findMenuItemByName(String mealType, String itemName) {
        List<MenuComponent> menu = switch (mealType) {
            case "Breakfast" -> menuInitializer.getBreakfast().getItems();
            case "Lunch" -> menuInitializer.getLunch().getItems();
            case "Dinner" -> menuInitializer.getDinner().getItems();
            default -> List.of();
        };

        for (MenuComponent item : menu) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}