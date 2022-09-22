package Marathontwo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import ExcelIntegration.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonClass {
	public RemoteWebDriver driver;
	public String fileName;//globalize the variable
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void preCondition(String browser, String url, String username, String password) throws InterruptedException {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ch = new ChromeOptions();
		    ch.addArguments("--disable-notifications");
			driver=new ChromeDriver(ch);
			}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			EdgeOptions ed = new EdgeOptions();
		    ed.addArguments("--disable-notifications");
			driver=new EdgeDriver(ed);
				}
			
	//Load the uRL https://login.salesforce.com/
	driver.get(url);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    Thread.sleep(3000);
    //02) Login to Salesforce with your username and password
    driver.findElement(By.id("username")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("Login")).click();
    //03) Click on the App Launcher (dots)
    driver.findElement(By.xpath("//div[@class='slds-r4']/following-sibling::div[1]")).click();
    //04) Click View All
    driver.findElement(By.xpath("//button[text()='View All']")).click();
    Thread.sleep(3000);
}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	@DataProvider//(name="fetchData")
	public String[][] testData() throws IOException{
		String[][] readData=ReadExcelFile.readData(fileName);
		return readData;
	}
	
}
