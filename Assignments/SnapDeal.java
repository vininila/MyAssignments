package Assignments;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 // Launch https://www.snapdeal.com/
		 driver.get("https://www.snapdeal.com/");
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   //Go to Mens Fashion
   driver.findElement(By.xpath("//span[@class='catText']")).click();
   //Go to Sports Shoes
   driver.findElement(By.xpath("//span[@class='linkTest']")).click();
   //Get the count of the sports shoes
   String items = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
   System.out.println("Count of sport shoes:  "+items);
   //Click Training shoes
   driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
   //Before sorting
   	List<WebElement> price=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
 	List<String> prices = new ArrayList<String>();
 	for (WebElement e : price)
 	{
 		 prices.add(e.getText());
 	}
 	System.out.println("Before sorted:" +prices);
 	Thread.sleep(200);
   //Sort by Low to High
    driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
    driver.findElement(By.xpath("//li[@class='search-li']")).click();
   //after sorting
    Thread.sleep(2000);
    List<WebElement> price1=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	List<String> prices1 = new ArrayList<String>();
	Thread.sleep(5000);
	for (WebElement e : price1)
	{
		String s=e.getText();
	    prices1.add(s);
	}
	System.out.println("After sorted " +prices1);
	//Check if the items displayed are sorted correctly
	if(prices.equals(prices1))
	{
		System.out.println("Items are not sorted");
	}
	else
	{
		System.out.println("Items are sorted");
	}
	//Select the price range (900-1200
	WebElement slider1=driver.findElement(By.xpath("//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
    Actions act=new Actions(driver);
	act.dragAndDropBy(slider1, 50, 0).perform();
    Thread.sleep(2000);
    WebElement slider2=driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
    act.dragAndDropBy(slider2,-130,0).perform();
   //Mouse Hover on first resulting Training shoes
    WebElement element = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
    act.moveToElement(element).perform();
    Thread.sleep(2000);
    //12. click QuickView button
    driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
    //13. Print the cost and the discount percentage
    String  cost= driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
    String percent= driver.findElement(By.xpath("(//div[contains(@class,'product-price pdp-e-i-PAY-l')]//span)[2]")).getText();
    System.out.println("Cost is:  "+cost+ "  Discount percentage is:  "+percent);
    //14. Take the snapshot of the shoes.
    File source = driver.getScreenshotAs(OutputType.FILE);
    File dest=new File("./Image/snapdeal.png");
    FileUtils.copyFile(source, dest);
	}

}
