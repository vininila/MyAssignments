package Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 // Launch the URL https://www.nykaa.com/
		 driver.get("https://www.nykaa.com/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         WebElement element = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
         //Mouseover on Brands and Search L'Oreal Paris
         
         Actions act=new Actions(driver);
         act.moveToElement(element).perform();
         driver.findElement(By.xpath("//input[@placeholder='search brands']")).sendKeys("L'Oreal Paris");
         Thread.sleep(3000);
         driver.findElement    (By.xpath("//div[@class='css-ov2o3v']//a")).click();
         //Check the title contains L'Oreal Paris(Hint-GetTitle)
         String title = driver.getTitle();
         String title1="L'Oreal Paris";
         System.out.println("Title of the page:  "+title);
         if(title.contains(title1))
        	 System.out.println("TRUE");
         else
        	 System.out.println("FALSE");
         
         //Click sort By and select customer top rated
         driver.findElement(By.className("sort-name")).click();
         driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
         //Click Category and click Hair->Click haircare->Shampoo
         driver.findElement(By.xpath("//div[@class='filter-open css-1kwl9pj']")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("(//span[@class='filter-name '])[2]")).click();
         driver.findElement(By.xpath("//div[@class=' css-b5p5ep']")).click();
         driver.findElement(By.xpath("//span[@class='count']")).click();
         //Click->Concern->Color Protection
         driver.findElement(By.xpath("//span[text()='Concern']")).click();
         driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
         //check whether the Filter is applied with Shampoo
         
         String lOrealParisColour = driver.findElement(By.className("css-xrzmfa")).getText();
         System.out.println("Shampoo displayed:  "+lOrealParisColour);
         //Click on L'Oreal Paris Colour Protect Shampoo
         driver.findElement(By.xpath("//div[@class='css-43m2vm']//img[1]")).click();
         //GO to the new window and select size as 175ml
         Set<String> windowHandles = driver.getWindowHandles();
         List<String> list=new ArrayList<String>(windowHandles);
         driver.switchTo().window(list.get(1));
         
         driver.findElement(By.xpath("//span[@class='active css-ieawrs']")).click();
         //Print the MRP of the product
         String  prize= driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
         System.out.println("MRP of the product:  "+prize);
         //Click on ADD to BAG
         driver.findElement(By.xpath("//button[@class=' css-12z4fj0']")).click();
         //Go to Shopping Bag
         driver.findElement(By.className("cart-count")).click();
         //Print the Grand Total amount
         Thread.sleep(6000);
         driver.switchTo().frame(0);//entering into frame
         String  total= driver.findElement(By.xpath("//div[@class='name medium-strong']/following-sibling::div"))
 	    .getText();
         System.out.println("Total amount is:  "+total);
         //Click Proceed
         driver.findElement(By.xpath("//button[contains(@class,'btn full')]")).click();
         // Click on Continue as Guest
         //driver.switchTo().defaultContent();
         driver.findElement(By.xpath("(//button[contains(@class,'btn full')])[2]")).click();
         //Check if this grand total is the same in step 14
         String grandTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div")).getText();
         System.out.println("Grand Total amount is:  "+grandTotal);
                 if(total.contentEquals(grandTotal))
        	 System.out.println("grand total is the same");
         //Close all windows
         driver.quit();
         
	}

}
