package com.company;

public class Interval {
    double a;
    double b;


    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setParams(double a, double b) {
        if (a > b) {
            throw new RuntimeException("A is bigger then B, try again");
        } else {
            this.a = a;
            this.b = b;
        }

    }

    public String outputInterval() {
        return "[ " + a + " ; " + b + " ]";
    }
}
