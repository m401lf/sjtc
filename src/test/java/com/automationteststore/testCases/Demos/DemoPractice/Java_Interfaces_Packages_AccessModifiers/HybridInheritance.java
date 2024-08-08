package com.automationteststore.testCases.Demos.DemoPractice.Java_Interfaces_Packages_AccessModifiers;

interface B1 {
    void m2();
}


interface B2 {
    void m3();
}

class A1 {
    void m1() {
        System.out.println("This is m1 method from A1 Class");
    }
}

public class HybridInheritance extends A1 implements B1, B2 {

    public static void main(String[] args) {

        HybridInheritance mi = new HybridInheritance();
        mi.m1();
        mi.m2();
        mi.m3();

    }

    public void m2() {
        System.out.println("this m2 method from B1 interface");
    }

    public void m3() {
        System.out.println("this is m3 method from B2 interface");
    }

}
