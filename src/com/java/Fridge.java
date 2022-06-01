package com.java;

import java.util.*;
import java.util.HashMap;

public class Fridge extends Thread implements ProductMethods  {
    public HashMap<String, HashMap<String, List<Object>>> allProd = new HashMap<>();
    public ArrayList<String> recipe = new ArrayList<String>(Arrays.asList("apple", "beef"));

    public void run() {

        Fridge fridge = new Fridge();
//------------ mapdan value olinganda 0 = product type,1 = amount,2 = exp.date shu korinishda chaqirilsin----------//
        HashMap<String, List<Object>> fruits = new HashMap<>();
        fruits.put("apple", Arrays.asList("apple", "fruit", 30, "15 days"));
        fruits.put("olivie", Arrays.asList("olivie", "fruit", 30, "13 days"));
        HashMap<String, List<Object>> vegetables = new HashMap<>();
        vegetables.put("carrot", Arrays.asList("carrot", "vegetable", 30, "15 days"));
        vegetables.put("onion", Arrays.asList("onion", "vegetable", 30, "2 days"));
        vegetables.put("tomato", Arrays.asList("tomato", "vegetable", 30, "10 days"));
        vegetables.put("pepper", Arrays.asList("pepper", "vegetable", 30, "5 days"));
        vegetables.put("potato", Arrays.asList("potato", "vegetable", 30, "15 days"));
        HashMap<String, List<Object>> meat = new HashMap<>();
        meat.put("beef", Arrays.asList("beef", "meat", 2, "0 days"));
        meat.put("salami", Arrays.asList("salami", "meat", 2, "15 days"));
        meat.put("cheese", Arrays.asList("cheese", "milk", 2, "7 days"));
        HashMap<String, List<Object>> fish = new HashMap<>();
        fish.put("salmon", Arrays.asList("salmon", "fish", 30, "15 days"));
        fridge.allProd.put("fruits", fruits);
        fridge.allProd.put("vegetables", vegetables);
        fridge.allProd.put("meat", meat);
        fridge.allProd.put("fish", fish);

//        ProductMethods.FindProduct(fridge.recipe,fridge.allProd);
//        ProductMethods.Order(fridge.allProd);
//        System.out.println(ProductMethods.ShowExpired(fridge.allProd));
//        ProductMethods.RemoveExpired(fridge.allProd);
    }
}
