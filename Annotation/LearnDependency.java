package Annotation;

import org.testng.annotations.Test;

public class LearnDependency {
	@Test(dependsOnMethods="login")
	public void createLead1()
	{
		System.out.println("Create Lead1");
	}
	@Test(dependsOnMethods="Annotation.LearnAttributes.createLead")
	public void deleteLead1()
	{
			System.out.println("Delete Lead1");
	}
	@Test
	public void duplicateLead1()
	{
		System.out.println("duplicate Lead1");
	}
	@Test
	public void editLead1()
	{
		System.out.println("Edit Lead1");
	}
	@Test
	public void mergeLead1()
	{
		System.out.println("Merge Lead1");
	}

	@Test
	public void login() throws Exception
	{
		//System.out.println("Login");
		throw new Exception();
	}

}
