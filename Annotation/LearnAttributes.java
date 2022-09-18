package Annotation;

import org.testng.annotations.Test;

public class LearnAttributes {
	@Test
	public void createLead()
	{
		System.out.println("Create Lead");
	}
	@Test(invocationCount=3, threadPoolSize=2,invocationTimeOut=1000)
	public void deleteLead()
	{
	
		System.out.println("Delete Lead");
	}
	@Test
	public void duplicateLead()
	{
		System.out.println("duplicate Lead");
	}
	@Test
	public void editLead()
	{
		System.out.println("Edit Lead");
	}
	@Test
	public void mergeLead()
	{
		System.out.println("Merge Lead");
	}
	
	

}
