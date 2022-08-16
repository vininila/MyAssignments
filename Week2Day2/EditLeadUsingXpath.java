package Week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadUsingXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
      driver.findElement(By.xpath(" //input[@id='password']")).sendKeys("crmsfa");
      driver.findElement(By.xpath(" //input[@class='decorativeSubmit']")).click();
      driver.findElement(By.xpath(" //a[contains(text(),'CRM/SFA')]")).click();
      driver.findElement(By.xpath(" //a[contains(text(),'Leads')]")).click();
      driver.findElement(By.xpath(" //a[(text()='Find Leads')]")).click();
      driver.findElement(By.xpath(" (//input[@name='firstName'])[3]")).sendKeys("Vennila");
      driver.findElement(By.xpath("  //button[text()='Find Leads']")).click();
      driver.findElement(By.xpath("  //a[text()='18659']")).click();
      System.out.println(driver.getTitle());
      driver.findElement(By.xpath("  //a[text()='Edit']")).click();
      driver.findElement(By.xpath("  (//input[@name='companyName'])[2]")).click();
      driver.findElement(By.xpath("  (//input[@name='submitButton'])[1]")).click();
      Thread.sleep(3000);
      driver.close();
	}

}
