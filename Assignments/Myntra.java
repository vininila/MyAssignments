package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 //Load the uRL https://www.myntra.com/
		driver.get("https://www.myntra.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Mouse hover on MeN 
        WebElement element = driver.findElement(By.xpath("//a[text()='Men']"));
        Actions act=new Actions(driver);
        act.moveToElement(element);
        Thread.sleep(3000);
        //Click Jackets
        //driver.findElement(By.xpath("//a[text()='Jackets']")).click();
        
        
        
	}

}
