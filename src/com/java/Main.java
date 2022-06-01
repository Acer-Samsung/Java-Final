package com.java;

import java.util.Timer;
import java.util.TimerTask;

public class Main implements ProductMethods {

    public static void main(String[] args) {

        //uncomment fridge class methods to test pr.finder and order methods

        Fridge fridge = new Fridge();
        fridge.start();

    }
}
