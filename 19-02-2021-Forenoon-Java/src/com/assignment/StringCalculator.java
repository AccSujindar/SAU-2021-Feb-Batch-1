package com.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class StringCalculator {
	
	static int operation(int op1, int op2, char op) throws Exception
	{
		int value = 0;
		if(op == '+')
		{
			value = op1 + op2;
		}
		else if(op == '-')
		{
			value = op1 - op2;
		}
		else if(op == '*')
		{
			value = op1 * op2;
		}
		else if(op == '/')
		{
			value = op1 / op2;
		}
		else if(op == '%')
		{
			value = op1 % op2;
		}
		else
		{
			throw new Exception("Invalid string");
		}
		return value;
	}
	
	static int calc(String inp)
	{
		try
		{
			Stack<Character> prevOp = new Stack<Character>();
			Stack<Integer> flow = new Stack<Integer>();
			prevOp.push('+');
			int totalSum = 0;
			int currentSum = 0;
			for(int i=0;i<inp.length();i++)
			{
				char a = inp.charAt(i);
				if(a == '(')
				{
					flow.push(totalSum);
					if(currentSum != 0)
					{
						flow.push(currentSum);
					}
					totalSum = 0;
					currentSum = 0;
					prevOp.push('+');
				}
				else if(a == ')')
				{
					char op = prevOp.pop();
					currentSum = operation(totalSum,currentSum,op);
					totalSum = (flow.empty())?0:flow.pop();
					while(!prevOp.empty() && prevOp.peek() != '+' && prevOp.peek() != '-')
					{
						op = prevOp.pop();
						currentSum = operation(totalSum,currentSum,op);
						totalSum = (flow.empty())?0:flow.pop();
					}
				}
				else if(a == '+' || a == '-')
				{
					Character temp = prevOp.pop();
					totalSum = operation(totalSum,currentSum,temp);
					currentSum = 0;
					prevOp.push(a);
				}
				else if(a == '*' || a == '/' || a == '%')
				{
					prevOp.push(a);
				}
				else
				{
					int num = 0;
					while(i < inp.length())
					{
						char temp = inp.charAt(i);
						if(temp == ' ')
						{
							i++;
							continue;
						}
						else if(temp == '+' || temp=='-' || temp=='*' || temp=='/' || temp=='%' || temp=='(' || temp==')')
						{
							i--;
							break;
						}
						else if(inp.charAt(i) - '0' < 0 || inp.charAt(i) - '0' > 9)
						{
							throw new Exception("Could not parse input.");
						}
						num = (num * 10) + (inp.charAt(i) - '0');
						i++;
					}	
					if(currentSum == 0)
					{
						currentSum = num;
					}
					else
					{
						char op = prevOp.pop();
						currentSum = operation(currentSum,num,op);
					}
				}
			}
			while(!prevOp.empty())
			{
				char op = prevOp.pop();
				currentSum = operation(totalSum,currentSum,op);
				totalSum = (flow.empty())?0:flow.pop();
			}
			return currentSum;
		}
		catch(Exception e)
		{
			System.out.println("Could not process. " + e);
			return Integer.MAX_VALUE;
		}
	}
	static String checkAndCleanString(String str)
	{
		String newStr;
		try
		{
			newStr 	= str.replaceAll(" ", "");
			String regex = "[0-9+-\\\\*/%()]*";
			if(!Pattern.matches(regex, newStr) || newStr.contains("+++") || newStr.contains("---") || newStr.contains("**") || newStr.contains("//") 
					|| newStr.contains("%%") || str.charAt(0) == '*' || str.charAt(0) == '/' || str.charAt(0) == '%')
			{
				throw new Exception("Invalid Input..");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "Err";
		}
		return newStr;
	}
	public static void main(String args[])
	{
		List<String> list = new ArrayList<String>();
		list.add(new String("-5abc + 8 * 6"));
		list.add(new String("-5 + 8 * 6"));
		list.add(new String("(55+ 9) % 9"));
		list.add(new String("20 + -3*5 / 8"));
		list.add(new String("5 + 15 / 3 * 2 - 8 % 3"));
		list.add(new String("(( ( 3 + 2 ) * ( 6 - 4 )) + 2) * 4"));
	
		for(String str : list)
		{
			System.out.println("Given String: " + str);
			str = checkAndCleanString(str);
			if(str.contentEquals("Err"))
			{
				System.out.println("");
				continue;
			}
			System.out.println("Cleaned String: " + str);
			System.out.println("output: " + calc(str));
			System.out.println();System.out.println();
		}
	}
}
