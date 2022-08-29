package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandlerAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.irctc.co.in/");
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
   driver.findElement(By.xpath("//a[@href='https://www.air.irctc.co.in']")).click();
   Set<String> windowHandles = driver.getWindowHandles();
   List<String> list=new ArrayList<String>(windowHandles);
   driver.switchTo().window(list.get(1));
   System.out.println(driver.getTitle());
   driver.close();
   driver.quit();
   
	}

}
