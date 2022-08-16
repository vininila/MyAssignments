package Week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnXpath {

	public static void main(String[] args) {
		
	   WebDriverManager.chromedriver().setup();
	   ChromeDriver driver=new ChromeDriver();
	   driver.get("http://leaftaps.com/opentaps/control/main");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.findElement(By.name("//input[@id='username']")).sendKeys("demosalesmanager");
       driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
       driver.findElement(By.xpath("//input[@type='submit']")).click();
       driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
       driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TCS");
       driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_firstName')]")).sendKeys("Vennila");
       driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_lastName')]")).sendKeys("Sivakumar");
       driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
       String title=driver.getTitle();
       System.out.println(title);
       //Thread.sleep(3000);
             //driver.close();

	}

}
