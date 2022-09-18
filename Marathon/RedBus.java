package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notifications");
	    // Launch Firefox / Chrome
	    ChromeDriver driver = new ChromeDriver(option);
		//Load https://www.redbus.in/
		 driver.get("https://www.redbus.in/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     //Type "Chennai" in the FROM text box
     driver.findElement(By.xpath("//input[@class='db']")).sendKeys("Chennai");
     driver.findElement(By.xpath("//li[@data-id='123']")).click();
     //Type "Bangalore" in the TO text box
     driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys("Bangalore");
     driver.findElement(By.xpath("//li[@data-id='122']")).click();
     driver.findElement(By.xpath("//label[@class='db text-trans-uc']")).click();
     //Select tomorrow's date in the Date field
     driver.findElement(By.xpath("//td[@class='wd day']")).click();
     Thread.sleep(2000);
     //Click Search Buses
     driver.findElement(By.id("search_btn")).click();
     // Print the number of buses shown as results (ex:104 Buses found)
     String buses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
     System.out.println("Number of buses shown as results:  "+buses);
     driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
     //Choose SLEEPER in the left menu 
     WebElement web = driver.findElement(By.xpath("//label[@for='bt_SLEEPER']"));
     driver.executeScript("arguments[0].scrollIntoView();", web);
     web.click();
     //Print the name of the second resulting bus 
     String vKTravels = driver.findElement(By.xpath("(//div[contains(@class,'travels lh-24')])[2]")).getText();
     System.out.println("Name of the second bus:  "+vKTravels);
     //Click the VIEW SEATS of that bus
     driver.findElement(By.xpath("(//div[contains(@class,'button view-seats')])[2]")).click();
     Thread.sleep(2000);
     //Take screenshot and close browser
     File source = driver.getScreenshotAs(OutputType.FILE);
     File dest=new File("./Image/shot1.png");
     FileUtils.copyFile(source, dest);  
    // driver.close();
     
   
    								 
	}

}
