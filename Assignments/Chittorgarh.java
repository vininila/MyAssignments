package Assignments;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 // Launch the URL https://www.chittorgarh.com/
		 driver.get("https://www.chittorgarh.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    //Click on stock market
    driver.findElement(By.id("navbtn_stockmarket")).click();
    //Click on NSE bulk Deals
    driver.findElement(By.xpath("//a[@href='/newportal/stock-nse-bulk-deals.asp']")).click();
     
    //Get all the Security names
    List<WebElement> colSize = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr/td[3]"));
    List<String> list= new ArrayList<String>();
    System.out.println(colSize.size());
    for (WebElement each : colSize) {
		String text=each.getText();
		list.add(text);
	}
		
//System.out.print("Original list:  "+list);
Set<String> set=new TreeSet<String>(list);
System.out.print("Dupliactes Removed List:  "+set);
	}

}
