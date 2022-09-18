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

public class MandatoryFields {

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
      //3. Enter Knowledge  in filter navigator and press enter
      		Shadow shadow= new Shadow(driver);
      		shadow.setImplicitWait(10);
      		shadow.findElementByXPath("//div[@id='all']").click();
      		WebElement know=shadow.findElementByXPath("//input[@id='filter']");
      		know.sendKeys("knowledge",Keys.ENTER);
      		shadow.findElementByXPath("//div[@id='all']").click();
      		know.sendKeys(Keys.ENTER);
      		
      	//4. Create new Article 
      		driver.switchTo().defaultContent();
      		WebElement eleframe=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
              driver.switchTo().frame(eleframe);
      		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
      		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
      		Set<String>windowHandles=driver.getWindowHandles();
      		List<String>swi=new ArrayList<String>(windowHandles);
      		driver.switchTo().window(swi.get(1));
      		driver.findElement(By.linkText("IT")).click();
      		driver.switchTo().window(swi.get(0));
      		WebElement eleframe1=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
              driver.switchTo().frame(eleframe1);
      		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();
      		driver.findElement(By.xpath("(//div[@class='list-item arrow']/following-sibling::div)[3]")).click();
      		driver.findElement(By.xpath("//span[text()='Java']")).click();
      		driver.findElement(By.id("ok_button")).click();
      		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("Intersting Selenium");
      		driver.findElement(By.id("sysverb_insert_bottom")).click();
      		String title=driver.getTitle();
      		System.out.println(title);
      		
      		Thread.sleep(2000);

	}

}
