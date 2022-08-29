package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day2Assignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.leafground.com/window.xhtml");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
         Set<String> windowHandles = driver.getWindowHandles();
         List<String> list=new ArrayList<String>(windowHandles);
         System.out.println("Size of available windows "+windowHandles.size());
         driver.switchTo().window(list.get(2));
         String title = driver.getTitle();
         System.out.println("Title of the Window:  "+ title);
         driver.switchTo().window(list.get(1));
         driver.close();
         driver.switchTo().window(list.get(0));
         driver.close();
	}

}
