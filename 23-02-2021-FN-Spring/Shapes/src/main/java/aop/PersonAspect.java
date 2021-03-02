package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PersonAspect {
	
	@Before("execution(public String getName())")
	public void getNameAdvice(){
		System.out.println("Using Before - Executing Advice on getName()");
	}
	@After("args(name)")
	public void logStringArguments(String name){
		System.out.println("Using After - Running After Advice. String argument passed="+name);
	}
	@AfterThrowing("execution(public void myThrowFunction())")
	public void logExceptions(JoinPoint joinPoint){
		System.out.println("After Throwing - Exception thrown in Person Method=" + joinPoint.toString());
	}

	@AfterReturning(pointcut="execution(* getName())", returning="returnString")
	public void getNameReturningAdvice(String returnString){
		System.out.println("After Returning - getNameReturningAdvice executed. Returned String="+returnString);
	}
	
	@Around("execution(* getName())")
	public Object personAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Using Around - Before invoking getName() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Using Around - After invoking getName() method. Return value="+value);
		return value;
	}
}
