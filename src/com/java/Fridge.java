package com.java;

import java.util.*;

public class Fridge implements ProductMethods {
    public HashMap<String, HashMap<String, List<Object>>> allProd = new HashMap<>();
    public ArrayList<String> recipe = new ArrayList<String>(Arrays.asList("apple", "beef"));

    public static void main(String[] args) {

        Main main = new Main();
        Fridge fridge = new Fridge();
//------------ mapdan value olinganda 0 = product type,1 = amount,2 = exp.date shu korinishda chaqirilsin----------//
        HashMap<String, List<Object>> fruits = new HashMap<>();
        fruits.put("apple", Arrays.asList("apple", "fruit", 30, "2023"));
        HashMap<String, List<Object>> vegetables = new HashMap<>();
        vegetables.put("carrot", Arrays.asList("carrot", "vegetable", 30, "2023"));
        HashMap<String, List<Object>> meat = new HashMap<>();
        meat.put("beef", Arrays.asList("beef", "meat", 2, "2023"));
        HashMap<String, List<Object>> fish = new HashMap<>();
        fish.put("salmon", Arrays.asList("salmon", "fish", 30, "2023"));
        fridge.allProd.put("fruits", fruits);
        fridge.allProd.put("vegetables", vegetables);
        fridge.allProd.put("meat", meat);
        fridge.allProd.put("fish", fish);

        ProductMethods.FindProduct(fridge.recipe,fridge.allProd);
        ProductMethods.Order(fridge.allProd);
    }
}
