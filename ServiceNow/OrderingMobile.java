package ServiceNow;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile extends CommonClasss{
@Test
	public void orderMobile() throws InterruptedException {
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		 //Launch ServiceNow application
		driver.get("https://dev116151.service-now.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Login with valid credentials username as admin and password as India@123
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("India@123");
        driver.findElement(By.id("sysverb_login")).click();*/
	
        //Click-All  Enter Service catalog in filter navigator and press enter 
        Thread.sleep(5000);
        Shadow dom =new Shadow(driver);
        //dom.findElementByXPath("//div[@id='all']").click();
        dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']").click();
        dom.findElementByXPath("//input[@id='filter']").sendKeys("Service catalog",Keys.ENTER);
        //Click on  mobiles
        driver.findElement(By.xpath("//h2[text()[normalize-space()='Mobiles']]")).click();
        //Select Apple iphone6s
        driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
        //Update color field to rose gold and storage field to 128GB
        WebElement color = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
        Select clr=new Select(color);
        clr.selectByValue("Rose Gold");
        WebElement storage = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]"));
        Select sto=new Select(storage);
        sto.selectByValue("128GB");
        //Select  Order now option
        driver.findElement(By.id("oi_order_now_button")).click();
        //Verify order is placed and copy the request number"
        String text = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
        if(text.contains("request has been submitted")) {
        	System.out.println("Order is placed");
        System.out.println(driver.findElement(By.xpath("//b[text()='REQ0010029']")).getText());
     
	}
        else 
        	System.out.println("Order not placed");
	}
}
