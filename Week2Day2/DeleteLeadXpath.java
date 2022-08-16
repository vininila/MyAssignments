package Week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadXpath {

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
     driver.findElement(By.xpath(" //span[text()='Phone']")).click();
     //driver.findElement(By.xpath(" //input[@name='phoneCountryCode']")).sendKeys("91");
     //driver.findElement(By.xpath(" //input[@name='phoneAreaCode']")).sendKeys("00");
     driver.findElement(By.xpath(" //input[@name='phoneNumber']")).sendKeys("8675168028");
     driver.findElement(By.xpath(" //button[(text()='Find Leads')]")).click();
     driver.findElement(By.xpath(" //a[text()='22271']")).click();
     driver.findElement(By.xpath(" //a[text()='Delete']")).click();
     driver.findElement(By.xpath(" //a[text()='Find Leads']")).click();
     driver.findElement(By.xpath(" //input[@name='id']")).sendKeys("22271");
     driver.findElement(By.xpath(" //button[(text()='Find Leads')]")).click();
     WebElement text=driver.findElement(By.xpath("//div[text()='No records to display']"));
     System.out.println(text.getText());
     Thread.sleep(3000);
     driver.close();
	}

}
