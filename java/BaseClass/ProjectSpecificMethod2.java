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


import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelFile;

public class ProjectSpecificMethod2 {
	public RemoteWebDriver driver;//globalize the driver and making it as static to share the memory
    public String fileName;//globalize the variable
	@Parameters({"browser","url"})
    @BeforeMethod
	public void preCondition(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	driver.manage().window().maximize();
	driver.get(url);
	
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
