package com.automationteststore.testCases.Demos.SpecialAndUsefulClassesInJava;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		
		/*
		 * Scanner class is used to accept the user input 
		 * during execution of a java program
		 */
		
		Scanner s1 = new Scanner(System.in);
		
		System.out.println("Please enter a string:");
		
		String str1 = s1.nextLine();
		
		String temp = "";
		
		for (int i = 0; i <= str1.length()-1; i++) {
			temp = str1.charAt(i) + temp;
		}
		
		System.out.println("Reversed String is: " + temp);
	}

}
