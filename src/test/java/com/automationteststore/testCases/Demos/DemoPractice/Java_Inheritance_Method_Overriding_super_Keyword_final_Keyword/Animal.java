package com.automationteststore.testCases.Demos.DemoPractice.Java_Inheritance_Method_Overriding_super_Keyword_final_Keyword;

public class Animal {

    String color = "white";

    Animal() {
        System.out.println("Animal is created");
    }

    void eating() {
        System.out.println("Eating........");
    }

}

class Dog extends Animal {
    String color = "Black";

    Dog() {
        super();//Invoked paraent class constructor
        System.out.println("Dog is created");

    }
	
	
	/*void displaycolor()
	{
		System.out.println(color);
		System.out.println(super.color);
	}*/
	
	/*void eating()
	{
		System.out.println("Eating Bread........");
		super.eating();
	}*/
}
