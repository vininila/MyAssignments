package Week2Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         driver.findElement(By.id("username")).sendKeys("demosalesmanager");
         driver.findElement(By.id("password")).sendKeys("crmsfa");
         driver.findElement(By.className("decorativeSubmit")).click();
         driver.findElement(By.linkText("CRM/SFA")).click();
         driver.findElement(By.linkText("Leads")).click();
         String title=driver.getTitle();
         System.out.println(title);
         Thread.sleep(4000);
         driver.close();
	}

}
