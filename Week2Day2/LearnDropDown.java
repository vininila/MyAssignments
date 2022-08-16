package Week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDropDown {

	public static void main(String[] args) throws InterruptedException {
						WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/main");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	        driver.findElement(By.id("password")).sendKeys("crmsfa");
	        driver.findElement(By.className("decorativeSubmit")).click();
	        driver.findElement(By.linkText("CRM/SFA")).click();
	        driver.findElement(By.linkText("Leads")).click();
	        driver.findElement(By.linkText("Create Lead")).click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
	        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vennila");
	        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sivakumar");
	        // Using dropdown elements
	        WebElement Industry=driver.findElement(By.id("createLeadForm_industryEnumId"));
	        Select ind=new Select(Industry);
	        ind.selectByIndex(3);
	        
	        WebElement Currency=driver.findElement(By.id("createLeadForm_currencyUomId"));
	        Select curr=new Select(Currency);
	        curr.selectByValue("INR");
	        
	        WebElement Ownership=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
	        Select own=new Select(Ownership);
	        own.selectByVisibleText("S-Corporation");
	        
	        driver.findElement(By.name("submitButton")).click();
	        String title=driver.getTitle();
	        System.out.println(title);
	        Thread.sleep(4000);
	        driver.close();
	}

	

}
