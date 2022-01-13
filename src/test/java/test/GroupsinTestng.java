package test;

import org.testng.annotations.Test;

public class GroupsinTestng {
	
	@Test(groups= {"Regression"})
	public void m1()
	{
		System.out.println("M1 is Regression test");
	}
	
	@Test(groups= {"Regression"})
	public void m2()
	{
		System.out.println("M2 is Regression test");
	}
	
	@Test(groups= {"Smoke"})
	public void m3()
	{
		System.out.println("M2 is Smoke test");
	}
	
	@Test(groups= {"Regression","Smoke"})
	public void m4()
	{
		System.out.println("M2 is Regression and Smoke test");
	}

}
