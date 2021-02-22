package com.assignment;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplacingRegex {

	public static void main(String args[])
	{
		String inputString;
		String regex;
		String replaceString;
		
		Scanner sc= new Scanner(System.in);
			
		System.out.println("Enter the input string:");
		inputString = sc.nextLine();
		System.out.println("Enter the Regular Expression:");
		regex = sc.nextLine();
		System.out.println("Enter the Replace String:");
		replaceString = sc.nextLine();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputString);
		String result = matcher.replaceAll(replaceString);
		System.out.println(result);
		sc.close();
		
	}
	
	
}
