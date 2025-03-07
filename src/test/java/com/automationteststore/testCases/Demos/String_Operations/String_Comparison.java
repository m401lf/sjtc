package com.automationteststore.testCases.Demos.String_Operations;

public class String_Comparison {

	public static void main(String[] args) {
		
		/**
		 * Equals
		 * Compare To
		 * Matches
		 */
		String str1 = "ABCDE";
		String str2 = "aBCDE";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		
		if (str1.equals(str2)) {
			System.out.println("Strings are equal");
		} else {
			System.out.println("Strings not equal");
		}
		
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.compareToIgnoreCase(str2));
		
		String patt = "[A-Z]{1,}";
		
		System.out.println(str1.matches(patt));

	}

}
