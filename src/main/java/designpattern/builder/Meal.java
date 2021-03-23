package designpattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getPrice() {
        float pri = 0;
        for(Item it : items) {
            pri += it.price();
        }
        return pri;
    }

    public void showItem(){
        for(Item it : items) {
            System.out.println("name: " + it.name());
            System.out.println("packing: " + it.packing());
            System.out.println("price: " + it.price());
        }
    }
}
