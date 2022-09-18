package Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlLibrary {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 // Launch the URL https://html.com/tags/table/
		 driver.get("https://html.com/tags/table/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  List<WebElement> list = driver.findElements(By.xpath("//div[@class='render']/table//tr/td"));
  List<String> list1=new ArrayList<String>();
 for (WebElement webElement : list) {
	 String text=webElement.getText();
	 list1.add(text);
	
}
 System.out.println(list1);
	}

}
