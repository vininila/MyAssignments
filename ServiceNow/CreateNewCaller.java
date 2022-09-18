package ServiceNow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
		 //Launch ServiceNow application-"https://dev116151.service-now.com/"
		driver.get("https://dev116151.service-now.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //2. Login with valid credential
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("India@123");
        driver.findElement(By.id("sysverb_login")).click();
        Thread.sleep(5000);
        //3.Click-All and Enter Callers in filter navigator and press enter 
        Shadow dom =new Shadow(driver);
        dom.setImplicitWait(30);
        dom.findElementByXPath("//div[@id='all']").click();
        dom.findElementByXPath("//input[@id='filter']").sendKeys("Callers",Keys.ENTER);
        dom.findElementByXPath("//div[@id='all']").click();
        dom.findElementByXPath("//input[@id='filter']").sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        //4. Create new Caller by filling all the fields and click 'Submit'.
        WebElement frame1 = dom.findElementByXPath("//iframe[@title='Main Content']");
        driver.switchTo().frame(frame1);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
        driver.findElement(By.id("sys_user.first_name")).sendKeys("Vennila");
        driver.findElement(By.id("sys_user.last_name")).sendKeys("SivaKumar");
        driver.findElement(By.xpath("//span[@class='icon icon-lightbulb']")).click();
	    Set<String>windowHandles=driver.getWindowHandles();
		List<String>swi=new ArrayList<String>(windowHandles);
		driver.switchTo().window(swi.get(1));
		driver.findElement(By.linkText("Director")).click();
		driver.switchTo().window(swi.get(0));
        driver.findElement(By.id("sys_user.title")).sendKeys("IT");
        driver.findElement(By.id("sys_user.email")).sendKeys("vennila29692@gmail.com");
        driver.findElement(By.id("sys_user.phone")).sendKeys("9876543210");
        driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("567978655");
        driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
        //5. Search and verify the newly created Caller"
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Vennila",Keys.ENTER);
      String string = driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
      if(string.contains("Vennila"))
    	    	  System.out.println("New caller created successfuly  "+ string);
      else
    	  System.out.println("New caller not created");
    	  
	}}

        
