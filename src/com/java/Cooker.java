package com.java;

import java.util.*;

public class Cooker implements ProductMethods
{
    Scanner input=new Scanner(System.in);
    Fridge fridge = new Fridge();
    Map<String, HashMap<String, Integer>> recipes = new HashMap();

    Cooker(){};
    //["Name of the dish", [ingredients, amount]]

    public void recipesInit(){
        HashMap<String, Integer> Ing = new HashMap<>();

        Ing.put("beef", 5);
        Ing.put("carrot", 4);
        Ing.put("onion", 3);
        recipes.put("plov", Ing);

        Ing.clear();
        Ing.put("salami", 5);
        Ing.put("cheese", 6);
        Ing.put("tomato", 3);
        Ing.put("olives", 3);
        Ing.put("pepper", 3);
        recipes.put("pizza", Ing);

        Ing.clear();
        Ing.put("beef", 5);
        Ing.put("carrot", 3);
        Ing.put("tomato", 2);
        Ing.put("potato", 5);
        Ing.put("onion", 1);
        recipes.put("soup", Ing);

    }
    public String giveSuggestion(){
        List<String> almostExpire = Arrays.asList("beef", "сarrot", "tomato", "olives", "pepper"); // Fridge returns these values
        // [String, int]
        Map<String, Integer> dishRecommendationRating = new HashMap<>();
        for (String dish : recipes.keySet() ) {
            // Going through recipes
            HashMap<String, Integer> ingredients = recipes.get("dish");
            for (String ingredient: ingredients.keySet()) {
                // Going through ingredients
                Integer amount = ingredients.get(ingredient);
                for (String item : almostExpire) {
                    if(item.equalsIgnoreCase(ingredient)){
                        int score = dishRecommendationRating.get(dish)+ amount;
                        dishRecommendationRating.remove(dish);
                        dishRecommendationRating.put(dish, score);
                    }
                }
            }
        }
        //sort dishRecommendationRating by score
        //return dish with the highest score
        return null;
    }
    public ArrayList<String> createMenu(){
        ArrayList<String> menu = new ArrayList<>();

        for (String dish:recipes.keySet()){
            if(ProductMethods.FindProduct(ingList(recipes.get(dish)), fridge.allProd)) menu.add(dish);
        }

        return menu;
    }
    private ArrayList<String> ingList(HashMap<String, Integer> ingredients){
        ArrayList<String> ingList = new ArrayList<String>();
        for (String ing : ingredients.keySet()){
            ingList.add(ing);
        }
        return ingList;
    }
    public String cook(String order){
        return order + " from the RobotChef";
    }


}