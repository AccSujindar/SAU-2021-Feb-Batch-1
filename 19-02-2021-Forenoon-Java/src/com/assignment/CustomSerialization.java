package com.assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dummy implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8867539627519254470L;
	int a;
	int b;
	int c;
	transient int d;
	transient int e;
	
	public Dummy(int a, int b, int c, int d, int e) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}

	@Override
	public String toString() {
		return "dummy [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + "]";
	}
	
}

public class CustomSerialization {

	public static void main(String args[])
	{
		Dummy d = new Dummy(1,2,3,4,5);
		String filename = "sujindar.txt"; 
		
		System.out.println("Serializing..\n");
		
		try
		{
			FileOutputStream file = new FileOutputStream (filename); 
			ObjectOutputStream out = new ObjectOutputStream (file); 
			out.writeObject(d); 
            out.close(); 
            file.close();
		}
		catch (Exception e) { 
            System.out.println("Exception is caught." + e); 
        } 
		
		System.out.println("Serialization Complete.\n");
		
		System.out.println("Serialized object: " + d.toString()+"\n");
		
		System.out.println("Deserializing..\n");
		try
		{
			Dummy newD = null;
			FileInputStream file = new FileInputStream (filename); 
			ObjectInputStream in = new ObjectInputStream(file); 
			newD = (Dummy)in.readObject();
			System.out.println("Deserialized object: " + newD.toString()+"\n");
			in.close();
			file.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception is caught." + e);
		}
	}
}


