package com.company;

import java.util.*;

public class Functions {

    public static Interval setInterval() {

        Interval interval = new Interval();
        boolean isTrue = true;

        while (isTrue) {
            try {
                double inputedInterval[] = setIntervalHelper();
                interval.setParams(inputedInterval[0], inputedInterval[1]);
                System.out.println(" ");
                System.out.println(interval.outputInterval());
                System.out.println(" ");
                return interval;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }



        }
        return null;
    }

    public static double[] setIntervalHelper() {
        double a,b;
        System.out.println(" ");
        System.out.println("Enter interval: [ a ; b ] ");
        while (true) {
            try {
                System.out.println("Enter a = ");
                Scanner sc = new Scanner(System.in);
                a = sc.nextDouble();
                break;

            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
        while (true) {
            try {
                System.out.println("Enter b = ");
                Scanner sc = new Scanner(System.in);
                b = sc.nextDouble();
                break;

            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
        double result[] = new double[2];
        result[0]=a;
        result[1]=b;


       return result;
    }
    public static int firstOptionMenu() {
        Interval current = setInterval();
        if(firstOptionHelper(current)==0) return 0;
        return 0;

    }

    public static int firstOptionHelper(Interval current) {
        int decision = 0;
        System.out.println("What property you need to know?");
        System.out.println("1. Center of the "+current.outputInterval());
        System.out.println("2. Width of the "+current.outputInterval());
        System.out.println("3. Radius of the "+current.outputInterval());
        System.out.println("4. Absolute value of the "+current.outputInterval());
        System.out.println("0. Main Menu");
        try {
            System.out.println(" ");
            System.out.println("Your decision = ");
            Scanner sc = new Scanner(System.in);
            decision = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Incorrect input");
            firstOptionMenu();
        }

        switch(decision) {
            case 1: {
                double center = (current.getB()+current.getA())/2.0;
                System.out.println(" Center of the "+current.outputInterval()+ " = "+center);
                System.out.println(" ");
                firstOptionHelper(current);
            }
            case 2: {
                double width = (current.getB()-current.getA());
                System.out.println(" Width of the "+current.outputInterval()+ " = "+width);
                System.out.println(" ");
                firstOptionHelper(current);
            }
            case 3: {
                double radius = (current.getB()-current.getA())/2.0;
                System.out.println(" Radius of the "+current.outputInterval()+ " = "+radius);
                System.out.println(" ");
                firstOptionHelper(current);
            }
            case 4: {
                double absolute = (Math.max(Math.abs(current.getB()),Math.abs(current.getA())));
                System.out.println(" Absolute value of the "+current.outputInterval()+ " = "+absolute);
                System.out.println(" ");
                firstOptionHelper(current);
            }

            case 0: {
                return 0;
            }

            default: {
                System.out.println("Bad decision, try again");
                firstOptionHelper(current);
            }
        }
        return 0;
    }


    public static int secondOption() {

        Interval first,second,result;
        String operator;

        System.out.println("Input first interval: ");
        first = setInterval();

        while (true) {

                System.out.println("Input operator: (+ or - or / or *)");
                Scanner sc = new Scanner(System.in);
                operator = sc.nextLine();
                if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) break;
                else {
                    System.out.println("Invalid input");
                    System.out.println(" ");
                }

        }

        while (true) {
            System.out.println("Input second interval: ");
            second = setInterval();

            switch (operator) {
                case "+": {
                    result = Operations.sum(first, second);
                    System.out.println(first.outputInterval() + " " + operator + " " + second.outputInterval() + " = " + result.outputInterval());
                    break;
                }
                case "-": {
                    result = Operations.substraction(first, second);
                    System.out.println(first.outputInterval() + " " + operator + " " + second.outputInterval() + " = " + result.outputInterval());
                    break;
                }
                case "*": {
                    result = Operations.multiply(first, second);
                    System.out.println(first.outputInterval() + " " + operator + " " + second.outputInterval() + " = " + result.outputInterval());
                    break;
                }
                case "/": {
                    if (second.getA() == 0 || second.getB() == 0) {
                        System.out.println(" ");
                        System.out.println("Second interval contains zeros, unable to divide, try again!");
                        System.out.println(" ");
                        continue;
                    }
                    result = Operations.sum(first, second);
                    System.out.println(first.outputInterval() + " " + operator + " " + second.outputInterval() + " = " + result.outputInterval());
                    break;
                }
            }

            while (true) {
                try {
                    System.out.println(" ");
                    System.out.println("Anything else? y/n");
                    Scanner sc = new Scanner(System.in);
                    String option = sc.nextLine();
                    if (option.equals("y"))  secondOption();
                } catch (Exception e) {
                    System.out.println("Incorrect input");
                }
                return 0;
            }
        }

    }

}
