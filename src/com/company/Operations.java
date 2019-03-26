package com.company;

public class Operations {

    /**
     *
     * @param a
     * @param b
     * @return a+b
     */
    public static Interval sum(Interval a, Interval b) {

        Interval suma = new Interval();
        suma.setParams((a.getA() + b.getA()), (a.getB()) + b.getB());

        return suma;
    }

    /**
     *
     * @param a
     * @param b
     * @return a-b
     */
    public static Interval substraction(Interval a, Interval b) {
        Interval riznucya = new Interval();
        riznucya.setParams((a.getA() - b.getB()), (a.getB()) - b.getA());

        return riznucya;
    }

    /**
     *
     * @param a
     * @param b
     * @return a*b
     */
    public static Interval multiply (Interval a, Interval b) {
        double first = Math.min(Math.min(a.getB()*b.getB(),a.getB()*b.getA()),Math.min(a.getA()*b.getB(),a.getA()*b.getA()));
        double second = Math.max(Math.max(a.getB()*b.getB(),a.getB()*b.getA()),Math.max(a.getA()*b.getB(),a.getA()*b.getA()));

        Interval result = new Interval();
        result.setParams(first,second);

        return result;
    }

    /**
     *
     * @param a
     * @param b shouldn;t contains zero
     * @return a/b
     * @throws RuntimeException
     */
    public static Interval divide (Interval a, Interval b) throws RuntimeException{
        if(b.getA()==0|| b.getB()==0) {
            throw new RuntimeException("Interval b contains zero");
        }
        Interval temp1 = new Interval();
        temp1.setParams((1/b.getB()),(1/b.getA()));

        Interval result = multiply(a,temp1);
        return result;
    }
}

