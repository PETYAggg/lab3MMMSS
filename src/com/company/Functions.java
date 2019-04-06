package com.company;

import java.lang.reflect.Array;
import java.net.InterfaceAddress;
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
        double a, b;
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
        result[0] = a;
        result[1] = b;


        return result;
    }

    public static int firstOptionMenu() {
        Interval current = setInterval();
        if (firstOptionHelper(current) == 0) return 0;
        return 0;

    }

    public static int firstOptionHelper(Interval current) {


        while (true) {
            int loopHelper = makeDecision(current);
            int decision = menuFirstOption(current, loopHelper);
            if (loopHelper == -1) break;
            if (decision == 0) break;
        }


        return 0;
    }

    public static int makeDecision(Interval current) {
        int decision = 0;
        System.out.println("What property you need to know?");
        System.out.println("1. Center of the " + current.outputInterval());
        System.out.println("2. Width of the " + current.outputInterval());
        System.out.println("3. Radius of the " + current.outputInterval());
        System.out.println("4. Absolute value of the " + current.outputInterval());
        System.out.println("0. Main Menu");
        try {
            System.out.println(" ");
            System.out.println("Your decision = ");
            Scanner sc = new Scanner(System.in);
            decision = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Incorrect input");
            return -1;
        }
        return decision;
    }

    public static int menuFirstOption(Interval current, int loopHelper) {
        switch (loopHelper) {
            case 1: {
                double center = (current.getB() + current.getA()) / 2.0;
                System.out.println(" Center of the " + current.outputInterval() + " = " + center);
                System.out.println(" ");
                return 1;
            }
            case 2: {
                double width = (current.getB() - current.getA());
                System.out.println(" Width of the " + current.outputInterval() + " = " + width);
                System.out.println(" ");
                return 1;
            }
            case 3: {
                double radius = (current.getB() - current.getA()) / 2.0;
                System.out.println(" Radius of the " + current.outputInterval() + " = " + radius);
                System.out.println(" ");
                return 1;
            }
            case 4: {
                double absolute = (Math.max(Math.abs(current.getB()), Math.abs(current.getA())));
                System.out.println(" Absolute value of the " + current.outputInterval() + " = " + absolute);
                System.out.println(" ");
                return 1;
            }

            case 0: {
                return 0;
            }

            default: {
                System.out.println("Bad decision, try again");
                return 1;
            }
        }
    }


    public static int secondOption() {

        Interval first, second, result;
        String operator;

        System.out.println("Input first interval: ");
        first = setInterval();

        while (true) {

            System.out.println("Input operator: (+ or - or / or *)");
            Scanner sc = new Scanner(System.in);
            operator = sc.nextLine();
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) break;
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
                    result = Operations.divide(first, second);
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
                    if (option.equals("y")) secondOption();
                } catch (Exception e) {
                    System.out.println("Incorrect input");
                }
                return 0;
            }
        }


    }

    public static int thirdOption() {
        Interval[][] intervals = new Interval[2][2];
        Interval[] result = new Interval[2];

//        System.out.println("Input an Interval matrix A(4 intervals 2x2");
//        for (int i = 0; i < 2; i++) {
//            System.out.println("Input a1" + i);
//            intervals.add(setInterval());
//        }
//
//        for (int i = 0; i < 2; i++) {
//            System.out.println("Input a2" + i);
//            intervals.add(setInterval());
//        }
//
//        System.out.println("Input a Matrix B(2 intervals");


        Interval a, b, c, d, e, f;

        a = new Interval();
        b = new Interval();
        c = new Interval();
        d = new Interval();
        e = new Interval();
        f = new Interval();
        Interval odunucya = new Interval();
        a.setParams(2, 4);
        b.setParams(-2, 1);
        c.setParams(-1, 2);
        d.setParams(2, 4);

        e.setParams(1, 2);
        f.setParams(1, 2);
        odunucya.setParams(1, 1);

        if (Operations.substraction(Operations.multiply(a, d), Operations.multiply(b, c)).getA() * Operations.substraction(Operations.multiply(a, d), Operations.multiply(b, c)).getB() <= 0) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Determinant of a contains zero: " + Operations.substraction(Operations.multiply(a, d), Operations.multiply(b, c)).outputInterval());
            System.out.println(" ");
            System.out.println(" ");
            return 0;
        }
        if (d.getA() * d.getB() > 0) {
            intervals[0][0] = Operations.divide(odunucya, Operations.substraction(a, Operations.divide(Operations.multiply(b, c), d)));
        } else {
            Interval temp = new Interval();
            Interval minTemp = new Interval();
            Interval maxTemp = new Interval();

//            Interval minTempC = new Interval();
//            Interval maxTempC = new Interval();
//
//            minTempC.setParams(c.getB(),c.getB());
//            maxTempC.setParams(c.getA(), c.getB());

            minTemp.setParams(d.getB(), d.getB());
            maxTemp.setParams(d.getA(), d.getA());

            double aMinus = Math.min(Operations.divide(minTemp, (Operations.substraction(Operations.multiply(a, minTemp), Operations.multiply(b, c)))).getA(), Operations.divide(minTemp, (Operations.substraction(Operations.multiply(a, minTemp), Operations.multiply(b, c)))).getB());
            double aPlus = Math.max(Operations.divide(maxTemp, (Operations.substraction(Operations.multiply(a, maxTemp), Operations.multiply(b, c)))).getA(), Operations.divide(maxTemp, (Operations.substraction(Operations.multiply(a, maxTemp), Operations.multiply(b, c)))).getB());
            temp.setParams(aMinus, aPlus);
            intervals[0][0] = temp;
        }

        if (b.getA() * b.getB() > 0) {
            intervals[0][1] = Operations.divide(odunucya, Operations.substraction(c, Operations.divide(Operations.multiply(a, d), b)));
        } else {
            Interval temp = new Interval();
            Interval minTemp = new Interval();
            Interval maxTemp = new Interval();
            minTemp.setParams(b.getB(), b.getB());
            maxTemp.setParams(b.getA(), b.getA());


            double aMinus = Math.min(Operations.divide(minTemp, (Operations.substraction(Operations.multiply(minTemp, c), Operations.multiply(a, d)))).getA(), Operations.divide(minTemp, (Operations.substraction(Operations.multiply(minTemp, c), Operations.multiply(a, d)))).getB());
            double aPlus = Math.max(Operations.divide(maxTemp, (Operations.substraction(Operations.multiply(maxTemp, c), Operations.multiply(a, d)))).getA(), Operations.divide(maxTemp, (Operations.substraction(Operations.multiply(maxTemp, c), Operations.multiply(a, d)))).getB());
            temp.setParams(aMinus, aPlus);
            intervals[0][1] = temp;
            // System.out.println(intervals[0][1].outputInterval());
        }

        if (c.getA() * c.getB() > 0) {
            intervals[1][0] = Operations.divide(odunucya, Operations.substraction(b, Operations.divide(Operations.multiply(a, d), c)));
        } else {
            Interval temp = new Interval();
            Interval minTemp = new Interval();
            Interval maxTemp = new Interval();
            minTemp.setParams(c.getB(), c.getB());
            maxTemp.setParams(c.getA(), c.getA());


            double aMinus = Math.min(Operations.divide(minTemp, (Operations.substraction(Operations.multiply(b, minTemp), Operations.multiply(a, d)))).getA(), Operations.divide(minTemp, (Operations.substraction(Operations.multiply(b, minTemp), Operations.multiply(a, d)))).getB());
            double aPlus = Math.max(Operations.divide(maxTemp, (Operations.substraction(Operations.multiply(b, maxTemp), Operations.multiply(a, d)))).getA(), Operations.divide(maxTemp, (Operations.substraction(Operations.multiply(b, maxTemp), Operations.multiply(a, d)))).getB());
            temp.setParams(aMinus, aPlus);
            intervals[1][0] = temp;
            //System.out.println(intervals[1][0].outputInterval());
        }

        if (a.getA() * a.getB() > 0) {
            intervals[1][1] = Operations.divide(odunucya, Operations.substraction(d, Operations.divide(Operations.multiply(b, c), a)));
        } else {
            Interval temp = new Interval();
            Interval minTemp = new Interval();
            Interval maxTemp = new Interval();
            minTemp.setParams(a.getB(), a.getB());
            maxTemp.setParams(a.getA(), a.getB());



            double aMinus = Math.min(Operations.divide(minTemp, (Operations.substraction(Operations.multiply(minTemp, d), Operations.multiply(b, c)))).getA(), Operations.divide(minTemp, (Operations.substraction(Operations.multiply(minTemp, d), Operations.multiply(b, c)))).getB());
            double aPlus = Math.max(Operations.divide(maxTemp, (Operations.substraction(Operations.multiply(maxTemp, d), Operations.multiply(b, c)))).getA(), Operations.divide(maxTemp, (Operations.substraction(Operations.multiply(maxTemp, d), Operations.multiply(b, c)))).getB());
            temp.setParams(aMinus, aPlus);
            intervals[1][1] = temp;
        }


        result[0] = Operations.sum(Operations.multiply(intervals[0][0], e), Operations.multiply(intervals[0][1], f));
        result[1] = Operations.sum(Operations.multiply(intervals[1][0], e), Operations.multiply(intervals[1][1], f));
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("A = " + a.outputInterval() + " " + b.outputInterval());
        System.out.println("    " + c.outputInterval() + " " + d.outputInterval());
        System.out.println(" ");
        System.out.println(" ");

        System.out.println(" ");
        System.out.println(" ");

        System.out.println("A-1 = " + intervals[0][0].outputInterval() + " " + intervals[0][1].outputInterval());
        System.out.println("    " + intervals[1][0].outputInterval() + " " + intervals[1][1].outputInterval());
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("B = " + e.outputInterval());
        System.out.println("    " + f.outputInterval());
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("X = " + result[0].outputInterval());
        System.out.println("    " + result[1].outputInterval());
        System.out.println(" ");
        System.out.println(" ");

        return 0;

    }

}
