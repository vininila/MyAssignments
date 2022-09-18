package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 // Launch the URL https://html.com/tags/table/
		 driver.get("https://html.com/tags/table/");
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   
   //Get the count of number of rows
   List<WebElement> rowSize = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
   System.out.println("Row size is:  "+rowSize.size());
   
   //Get the count of number of columns
   List<WebElement> colSize = driver.findElements(By.xpath("//table[@class='attributes-list']//tr/th"));
   System.out.println("Column size is:  "+colSize.size());
	}

}
