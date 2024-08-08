package com.automationteststore.testCases.Demos.DemoPractice;

public class ThisKeyword {

    int a, b; // instance varaibles or class varaibles

    public static void main(String[] args) {

        ThisKeyword th = new ThisKeyword();
        th.getValues(10, 20);
        th.printValues();


    }

    void getValues(int a, int b) // method varaibles/external varaibles
    {
        this.a = a;
        this.b = b;
    }

    void printValues() {
        System.out.println(a);
        System.out.println(b);
    }

}
