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

public class CreateCaller {

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
      //3. Click-All and Enter Callers in filter navigator and press enter 
      		Shadow shadow= new Shadow(driver);
      		shadow.setImplicitWait(10);
      		shadow.findElementByXPath("//div[@id='all']").click();
      		WebElement caller=shadow.findElementByXPath("//input[@id='filter']");
      		caller.sendKeys("callers",Keys.ENTER);
      		shadow.findElementByXPath("//div[@id='all']").click();
      		caller.sendKeys(Keys.ENTER);
      		
      		//4. Click- new  and  fill mandatory fields and click 'Submit' Button
      		driver.switchTo().defaultContent();
      		WebElement eleframe=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
              driver.switchTo().frame(eleframe);
              driver.findElement(By.xpath("//button[@class='selected_action action_context btn btn-primary']")).click();
      	    driver.findElement(By.id("sys_user.first_name")).sendKeys("Lalitha");
      	    driver.findElement(By.id("sys_user.last_name")).sendKeys("M");
      	    driver.findElement(By.xpath("//span[@class='icon icon-lightbulb']")).click();
      	    Set<String>windowHandles=driver.getWindowHandles();
      		List<String>swi=new ArrayList<String>(windowHandles);
      		driver.switchTo().window(swi.get(1));
      		driver.findElement(By.linkText("Director")).click();
      		driver.switchTo().window(swi.get(0));
      		WebElement eleframe1=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
              driver.switchTo().frame(eleframe1);
      	    //driver.findElement(By.id("sys_user.title")).sendKeys("Director");
              driver.findElement(By.id("sys_user.email")).sendKeys("mvlalitha89@gmail.com");
      		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("9874561234");
      		driver.findElement(By.xpath("//button[@class='form_action_button  action_context btn btn-default']")).click();
      		
      		//5. Search and verify the newly created Caller"
      		driver.switchTo().defaultContent();
      		WebElement eleframe2=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
              driver.switchTo().frame(eleframe2);
      	    driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Vennila",Keys.ENTER);
      	    String text=driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[2]")).getText();
      	    System.out.println("Caller created newly : " +text);
      	    if(text.contains("Vennila"))
      	    {
      	    	System.out.println("Caller " +text+ " is created newly");
      	    }
      	    else
      	    {
      	    	System.out.println("Caller " +text+ "is not created newly");
      	    }
              Thread.sleep(2000);
              driver.close();

	}

}
