package ServiceNow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonClasss {
	public ChromeDriver driver;
	@Parameters({"url","user_name","user_password"})
 @BeforeMethod
	public  void precondition(String url, String uname, String pwd) {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		 //Launch ServiceNow application-"https://dev116151.service-now.com/"
		driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Login with valid credentials username as admin and password as India@123
        driver.findElement(By.id("user_name")).sendKeys(uname);
        driver.findElement(By.id("user_password")).sendKeys(pwd);
        driver.findElement(By.id("sysverb_login")).click();
	}
 @AfterMethod
	public void postcondition()
	{
		driver.close();
	}
	}


