package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import BaseClass.ProjectSpecificMethod;
import BaseClass.ProjectSpecificMethod2;

public class Homepage extends ProjectSpecificMethod2{
	

	public Homepage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public Homepage verifyPageTitle() {
		System.out.println(driver.getTitle());
		return this;
	}

	public LeadsPage clickLeads()
	{
		driver.findElement(By.linkText("Leads")).click();
		System.out.println(driver.getTitle());
		return new LeadsPage(driver);
	}
}
