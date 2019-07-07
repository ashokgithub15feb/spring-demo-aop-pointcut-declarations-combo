package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related to advices for logging
	
	//let's start with the @Before advice
	
//	@Before("execution(public void addAccount())")
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}
	
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}
	
//	@Before("execution(public void add*())")
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}
	
//	@Before("execution(* add*(Account))") //exception thrown
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}
	
//	@Before("execution(* add*(com.luv2code.aopdemo.Account))")
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}
	
//	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}
	
//	@Before("execution(* add*(..))")
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}
	
//	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}
	
//	@Before("execution(* com.luv2code.aopdemo.dao.*.add*(..))")
//	public void beforeAddAccountAdvice()
//	{
//		System.out.println("\n=======>>>>> Execution @Before advice on method");
//	}

	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create point cut for getter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter()
	{
	}
	
	//create point cut for setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter()
	{
	}
	
	//create pointcut: include package ..... execute getter and setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter()
	{
	}
	
	//applied pointcut declration yo advices
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n=======>>>>> Execution @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performAnalytcs()
	{
		System.out.println("\n=======>>>>> Performing API analytics" );
	}
	
	
}





















