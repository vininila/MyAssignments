package ExplicitWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForClickability {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.leafground.com/waits.xhtml");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    
    //Wait for Clickability
    driver.findElement(By.xpath("//span[text()='Click First Button']")).click();
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    WebElement element = driver.findElement(By.xpath("//span[text()='Click Second']"));
    wait.until(ExpectedConditions.elementToBeClickable(element));
    //Wait for Text Change (1 - 10 Sec)
    driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
    WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
    wait1.until(ExpectedConditions.textToBe(By.xpath("//span[text()='Did you notice?']"), "Did you notice?"));
	System.out.println(driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText());
	}

}