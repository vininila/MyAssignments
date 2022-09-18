package Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 //Load the uRL https://www.amazon.in/
		 driver.get("https://www.amazon.in/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         //search as oneplus 9 pro 
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
         driver.findElement(By.xpath("//div[text()='oneplus 9 pro']")).click();
         //Get the price of the first product
         String price= driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
         System.out.println("price of the first product is:  "+price);
         //Print the number of customer ratings for the first displayed product
         String rating= driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
         System.out.println("Print the number of customer ratings for the first displayed product: "+rating);
         //Mouse Hover on the stars
         WebElement element = driver.findElement(By.xpath("//i[contains(@class,'a-icon a-icon-star-small')]"));
         Actions act=new Actions(driver);
         act.moveToElement(element).perform();
         //Get the percentage of ratings for the 5 star.
         String starsRepresent = driver.findElement(By.xpath("(//a[@title='5 stars represent 63% of rating'])[3]")).getText();
         System.out.println("percentage of ratings for the 5 star:  "+starsRepresent);
         //Click the first text link of the first image
         driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
         Set<String> windowHandles = driver.getWindowHandles();
         List<String> list=new ArrayList<String>(windowHandles);
         driver.switchTo().window(list.get(1));
         //Take a screen shot of the product displayed
         File source = driver.getScreenshotAs(OutputType.FILE);
         File dest=new File("./Image/amazon.png");
         FileUtils.copyFile(source, dest); 
         //Click 'Add to Cart' button
         driver.findElement(By.id("add-to-cart-button")).click();
         //Get the cart subtotal and verify if it is correct.
         String subTotalPrize = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
         System.out.println("cart subtotal: "+subTotalPrize);
         if(price.equals(subTotalPrize))
        	 System.out.println("Price is correct");
         else
        	 System.out.println("Price is incorrect");

	}

}
