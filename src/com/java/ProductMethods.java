package com.java;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public interface ProductMethods {

    // ------------------------Product finder metodi retseptni arraylist korinishida qabul qiladi------------------------ //

    static void FindProduct(ArrayList<String> recipe, HashMap<String, HashMap<String, List<Object>>> allProd) {
        for (String item : recipe) {
            if (allProd.get("fruits").get(item) != null) System.out.println(allProd.get("fruits").get(item));
            else if (allProd.get("vegetables").get(item) != null)
                System.out.println(allProd.get("vegetables").get(item));
            else if (allProd.get("meat").get(item) != null) System.out.println(allProd.get("meat").get(item));
            else if (allProd.get("fish").get(item) != null) System.out.println(allProd.get("fish").get(item));
        }
    }


    //Order()
    //-scanns the array to find products with low amount.
    //-if there is low amount product, it will order it.
    //-calculates the amount of time it takes to deliver
    ////array[product,product_amount]

    static void Order(HashMap<String, HashMap<String, List<Object>>> allProd) {
        Timer timer = new Timer();
        for (HashMap<String, List<Object>> value : allProd.values()) {
            for (List<Object> value2 : value.values()) {
                System.out.println(value2.get(0) + " - " + value2.get(2));
                int time = ThreadLocalRandom.current().nextInt(5000, 10000 + 1);

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        int a = (int) value2.get(2);
                        if (a < 8) {
                            System.out.println("Ordered " + (30 - (int) value2.get(2)) + "kg " + value2.get(0) + " estimated time " + time + "milliseconds");
                            value2.set(2, 30);
                        }
                    }
                } , 0,  time);

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Order successfully recieved");
                        timer.cancel();
                    }
                } , time+1000);
            }
        }

    }
}
