package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Servant
{
    Scanner input = new Scanner(System.in);
    Main main = new Main();
    Fridge fridge = new Fridge();
    static Servant servant = new Servant();
    static Cooker cooker = new Cooker();
    List<String> menu = Arrays.asList("plov", "pizza", "soup");
    String cookSuggestion = "";
    String order;
    Servant(){
    }

    public static void main(String[] args) {
        System.out.println(servant.otherServices());

        servant.setCookSuggestion(cooker.giveSuggestion());
        servant.setMenu(cooker.createMenu());
    }


    //Main
    public void Order() {

        boolean shouldIContinueTakingOrder = false;

        do {
            String order = this.takeOrder();
            if (order != "") {
                String dish = cooker.cook(order);
                if (dish != "") {
                    this.bringOrder(dish);
                    System.out.println("Whould you like to order something else?");
                    System.out.println("Input\"Yes\" to show the list");
                    shouldIContinueTakingOrder = input.next().equalsIgnoreCase("yes") && this.otherServices();

                    if (!shouldIContinueTakingOrder) System.out.println("Well, I am leaving you");

                } else {
                    this.apologise("Cook doesn't have all ingredients");
                    shouldIContinueTakingOrder = true; // Принять другой заказ
                }
            } else {
                this.apologise("Dish is not found in the menu");
                shouldIContinueTakingOrder = true; // Принять другой заказ
            }

        } while (shouldIContinueTakingOrder == true);
    }


    // Setters
    public void setCookSuggestion(String cookSuggestion) {
        this.cookSuggestion = cookSuggestion;
    }
    public void setMenu(List<String> menu) {
        this.menu= menu;

    }


    // Sub functions
    public void showMenu(){
        System.out.println("Here is our menu:");
        int counter = 0;
        for (String item : menu) {
            System.out.println(++counter + ". " + item);
        }
    }
    private String takeOrder(){
        this.showMenu();
        System.out.println("Please input the name of the dish that you want: ");
        order = input.next();
        if (this.isValidOrder(order)){
            return order;
        }
        else {
            return "";
        }
    }
    private boolean otherServices(){

        System.out.println("If you want me to take Order - enter 1");
        System.out.println("If you want me to call Cleaner - enter 2");
        System.out.println("If you changed your mind - enter 0");
        do {
            int userChoice = input.nextInt();
            if (userChoice == 1) {
                return true;
            } else if (userChoice == 2) {
                this.callCleaner();
                return false;
            }else if (userChoice == 0) {
                return false;
            } else {
                System.out.println("No such option is found, please try again");
                continue;
            }
        }while(true);
    }
    private boolean isValidOrder(String order){
        for(String item:menu){
            if (item.equalsIgnoreCase(order))
                return true;
        }
        return false;
    }
    private void apologise(String reason){
        System.out.println("We are really sorry, but we can't complete this order");
        System.out.println(reason);

    }
    private void bringOrder(String dish){
        System.out.println("Here is your " + dish);
    }
    public void callCleaner(){
        Cleaner cleaner = new Cleaner();
        cleaner.clean();
    }
    //
    private void OrderMany(){
        ArrayList<String> orders = new ArrayList<String>();
        boolean shouldIContinueTakingOrder = false;
        do {
            orders.add(this.takeOrder());
            order = order +"\n" + this.takeOrder();
            if (order != "") {
                String dish = cooker.cook(order);
                if (dish != "") {
                    this.bringOrder(dish);
                    System.out.println("Would you like to order something else?");
                    System.out.println("Input \"Order\" to order something else");
                    String prosba = input.next(); // заказать, убрать со стола , ничего
                    if (prosba.equalsIgnoreCase("Order")) {
                        shouldIContinueTakingOrder = true; // Принять другой заказ
                    }
//                  else if (this.cleaner){
//                      Значит Убраться на столе, т.е. позвать уборщика
//                  }
                    else {
                        System.out.println("Ladno ya vas pokidayu");
                        shouldIContinueTakingOrder = false;
                    }
                } else {
                    this.apologise("Cook doesn't have all ingredients");
                    shouldIContinueTakingOrder = true; // Принять другой заказ
                }
            } else {
                this.apologise("Dish is not found in the menu");
                shouldIContinueTakingOrder = true; // Принять другой заказ
            }

        } while (shouldIContinueTakingOrder == true);
        System.out.println("You ordered: ");

        for(String order: orders){
            System.out.println(order);
        }
    }

}
