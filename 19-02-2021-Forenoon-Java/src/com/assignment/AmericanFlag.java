package com.assignment;

import java.util.Scanner;

public class AmericanFlag {
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int size=1;
		System.out.println("Enter the flag size:");
		size = sc.nextInt();
		for(int i=1;i<=8;i++)
		{
			if(i%2 == 1)
			{
				for(int j=0;j<6;j++)
				{
					System.out.print("*");
					for(int k=0;k<size;k++)
					{
						System.out.print(" ");
					}
				}
			}
			else
			{
				for(int j=0;j<5;j++)
				{
					for(int k=0;k<size;k++)
					{
						System.out.print(" ");
					}
					System.out.print("*");
				}
				for(int k=0;k<size;k++)
				{
					System.out.print(" ");
				}
				System.out.print(" ");
			}
			int width = (6 * 2 * size-1) + 44;
			for(int j=0;j<width;j++)
			{
				System.out.print("=");
			}
			if(i!=8)
			{
				for(int j=0;j<size-1;j++)
				{
					System.out.println("");
					for(int k=0;k<6*(size+1);k++)
					{
						System.out.print(" ");
					}
					width = (6 * 2 * size-1) + 44;
					for(int k=0;k<width;k++)
					{
						System.out.print("=");
					}
				}
				System.out.println("");
			}
			else
			{
				System.out.println("");
			}
		}
		
		int width,height;
		width = 6*(size+1) + 44 + (6 * 2 * size-1);
		height = 8 * (size);
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				System.out.print("=");
			}
			System.out.println("");
		}
		sc.close();
	}

}








