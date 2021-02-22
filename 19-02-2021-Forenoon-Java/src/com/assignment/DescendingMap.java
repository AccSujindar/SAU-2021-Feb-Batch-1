package com.assignment;

import java.util.*;

public class DescendingMap {
	
	public static void main(String args[])
	{
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		
		tm.put(110,1);
		tm.put(220,2);
		tm.put(52,3);
		tm.put(143,4);
		tm.put(196,5);
		System.out.println("Inserted Order:\n");
		System.out.println(tm);
		System.out.println("\nReversed Order:\n");
		NavigableMap<Integer, Integer> nmap = tm.descendingMap();
		System.out.println(nmap);
	}

}
