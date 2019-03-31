package com.company;

import java.util.Scanner;

public class Main {

    public static void mainMenu() {
        int decision = 0;
        System.out.println("*****____Interval Calculus_____*****");
        System.out.println("Choose the app you want to use");
        System.out.println("1. Properties of interval given ");
        System.out.println("2. Interval calculus");
        System.out.println("3. Interval system solve");

        try {
            Scanner sc = new Scanner(System.in);
            decision = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Incorrect input, please type the number of your decision");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            mainMenu();
        }

        switch (decision) {
            case 1: {
                if (Functions.firstOptionMenu() == 0) mainMenu();
                break;
            }
            case 2: {
                if (Functions.secondOption() == 0) mainMenu();
                break;
            }
            case 3: {
                if (Functions.thirdOption() == 0) mainMenu();
                break;
            }
            case -1:{
                System.out.println("Bye bye!");
                return;
            }
        }
        System.out.println("Invalid decision");
        mainMenu();

    }


    public static void deciderMethod(int decision) {

    }

    public static void main(String[] args) {

       mainMenu();

    }
}
