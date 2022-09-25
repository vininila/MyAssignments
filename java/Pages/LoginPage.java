package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import BaseClass.ProjectSpecificMethod;
import BaseClass.ProjectSpecificMethod2;

public class LoginPage extends ProjectSpecificMethod2 {
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public LoginPage enterUsername(String uname) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
	    return this;
	}
	
	public LoginPage enterPassword(String pwd) {
		driver.findElement(By.xpath(" //input[@id='password']")).sendKeys(pwd);
		return this;
	}
	
	public WelcomePage clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage(driver);//creating constructor for WelcomePage
	}
	
	}

