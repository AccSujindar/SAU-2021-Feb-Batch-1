package com.assignment;

import java.math.BigInteger;

class MyException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4591581822091043260L;

	public MyException(String s)
	{
		super(s);
	}
}
public class CustomException {
	
	public static void main(String args[])
	{
		for(int i=1;i<=100;i++)
		{
			try
			{
				BigInteger b = new BigInteger(String.valueOf(i));
				if(b.isProbablePrime(1))
				{
					throw new MyException(i + " is a prime number");
				}
			}
			catch(MyException e)
			{
				System.out.println(e);
				continue;
			}
		}
	}
}
