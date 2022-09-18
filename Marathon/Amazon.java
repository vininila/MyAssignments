package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.in/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).sendKeys("Bags for boys");
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div[text()='bags for boys']")).click();
       String ofOver = driver.findElement(By.xpath("//span[text()='1-48 of over 30,000 results for']")).getText();
       System.out.println("Total number of results:  "+ofOver);
       
       driver.findElement(By.xpath("(//span[text()='American Tourister'])[2]")).click();
       driver.findElement(By.xpath("//span[text()='Generic']")).click();
       
       String web = driver.findElement(By.xpath("//span[text()='1-48 of over 4,000 results for']")).getText();
       System.out.println("Resulting page  "+web);
       if(ofOver!=web) {
    	   System.out.println("Value got reduced");
       }
       else
    	   System.out.println("Value not reduced");

       driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
       driver.findElement(By.linkText("Newest Arrivals")).click();
       
       String name = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')])[2]")).getText();
       String  price= driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
       System.out.println("Name is  :"+name +"   Price is  :"+price);
       System.out.println("---------------------");
       System.out.println("There is No Deals of the day for this product");
       driver.findElement(By.xpath("//img[@class='s-image']")).click();
       //windows handling
       
       Set<String> windowHandles = driver.getWindowHandles();
       List<String> list=new ArrayList<String>(windowHandles);
       driver.switchTo().window(list.get(1));
       
       String  price1= driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
       if(price.equals(price1))
    	   System.out.println("There is No discount for this Product");
       else
    	   System.out.println("There is a discount for this product");
              
       //screenshot
       
       File source = driver.getScreenshotAs(OutputType.FILE);
       File dest=new File("./Image/shot2.png");
       FileUtils.copyFile(source, dest); 
    
	}
	

}
