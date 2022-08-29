package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://jqueryui.com/sortable/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.switchTo().frame(0);
    WebElement ele4=driver.findElement(By.xpath("//li[text()='Item 4']"));
    WebElement ele6=driver.findElement(By.xpath("//li[text()='Item 6']"));
    //driver.switchTo().defaultContent();
    Actions act=new Actions(driver);
    Thread.sleep(3000);
    act.dragAndDrop(ele6, ele4).perform();
    System.out.println("END");
	}

}
