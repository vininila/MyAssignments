package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethod {

	public static RemoteWebDriver driver;//globalize the driver and making it as static to share the memory
    public String fileName;//globalize the variable
	//@Parameters({"browser","url","username","password"})
    @BeforeMethod
	public void preCondition() {
		/*
		 * //if(browser.equalsIgnoreCase("chrome")) {
		 * //WebDriverManager.chromedriver().setup(); //driver = new ChromeDriver();
		 * //}else if(browser.equalsIgnoreCase("edge")){
		 * //WebDriverManager.edgedriver().setup(); //driver = new EdgeDriver(); //}
		 */		
		 WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//driver.findElement(By.id("username")).sendKeys(username);
	//driver.findElement(By.id("password")).sendKeys(password);
	//driver.findElement(By.className("decorativeSubmit")).click();
	//driver.findElement(By.linkText("CRM/SFA")).click();
	//driver.findElement(By.linkText("Leads")).click();
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
