package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import BaseClass.ProjectSpecificMethod;
import BaseClass.ProjectSpecificMethod2;

public class WelcomePage extends ProjectSpecificMethod2{
	
	public WelcomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public Homepage clickCrmsfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		System.out.println(driver.getTitle());
		return new Homepage(driver);
	}
	
	public LoginPage clickLogout() {

	driver.findElement(By.className("decorativeSubmit")).click();
	return new LoginPage(driver);
	}
}

