package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://in.bookmyshow.com/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.findElement(By.xpath("//input[@class='sc-jvEmr elijMA']")).sendKeys("Hyderabad");
      driver.findElement(By.xpath("//strong[text()='Hyderabad']")).click();
      System.out.println("URL loaded  :"+driver.getCurrentUrl());
      driver.findElement(By.xpath("//span[@class='sc-jKVCRD jyFDAS']")).click();
      driver.findElement(By.xpath("//input[@class='sc-jvEmr elijMA']")).sendKeys("Cobra");
      driver.findElement(By.xpath("//strong[text()='Cobra']")).click();
      driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
      driver.findElement(By.xpath("//div[@class='sc-vhz3gb-3 dRokFO']")).click();
      String theatre = driver.findElement(By.xpath("//div[@class='__title']//a")).getText();
      System.out.println("Name of the theatre displayed first:  "+theatre);
      driver.findElement(By.xpath("//img[@class='venue-info-icon lazy']")).click();
      WebElement web=driver.findElement(By.xpath("//div[text()='            Parking Facility        ']"));
      boolean isVisible=web.isDisplayed();
      System.out.println("Parking is available  :"+isVisible);
      driver.findElement(By.xpath("//div[@class='cross-container']")).click();
      driver.findElement(By.xpath("//div[@class='__details']")).click();
      driver.findElement(By.id("btnPopupAccept")).click();
      driver.findElement(By.id("pop_1")).click();
      driver.findElement(By.id("proceed-Qty")).click();
      driver.findElement(By.xpath("(//a[@class='_available'])[3]")).click();
      driver.findElement(By.xpath("//button[@class='No thanks']")).click();
      //elementnotInteractableException
      WebElement web1=driver.findElement(By.xpath("//a[@id='btmcntbook']"));
      driver.executeScript("arguments[0].click();", web1);
      
      Thread.sleep(5000);
      String rs = driver.findElement(By.xpath("//span[@id='subTT']")).getText();
      System.out.println("SubTotal is:  "+ rs);
      
      File source = driver.getScreenshotAs(OutputType.FILE);
      File dest=new File("./Image/bookmyshow.png");
      FileUtils.copyFile(source, dest); 
	}

}

//Testcase 3 (BookMyShow)
//01) Launch Edge / Chrome
//02) Load https://in.bookmyshow.com/
//03) Type the city as "Hyderabad" in Select City
//04) Confirm the URL has got loaded with Hyderabad 
///05) Search for your favorite movie 
//06) Click Book Tickets
//07) Print the name of the theater displayed first
//08) Click on the info of the theater
//09) Confirm if there is a parking facility in the theater
//10) Close the theater popup
//11) Click on the first green (available) timing
//12) Click Accept
//13) Choose 1 Seat and Click Select Seats
//14) Choose any available ticket and Click Pay
//15) Print the sub total
//16) Take screenshot and close browser
