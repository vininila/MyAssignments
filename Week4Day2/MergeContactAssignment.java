package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/login");
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   driver.findElement(By.id("username")).sendKeys("demosalesmanager");
   driver.findElement(By.id("password")).sendKeys("crmsfa");
   driver.findElement(By.className("decorativeSubmit")).click();
   driver.findElement(By.linkText("CRM/SFA")).click();
   driver.findElement(By.linkText("Contacts")).click();
   driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();
   driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
   //windows handling
   Set<String> windowHandles = driver.getWindowHandles();
   List<String> list=new ArrayList<String>(windowHandles);
   System.out.println("Size is: "+windowHandles.size());
   driver.switchTo().window(list.get(1));
   System.out.println(driver.switchTo().window(list.get(1)).getTitle());//title of 1 index window
   
   driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
   driver.switchTo().window(list.get(0));
   driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
   
   Set<String> windowHandles1 = driver.getWindowHandles();
   List<String> list1=new ArrayList<String>(windowHandles1);
   driver.switchTo().window(list1.get(1));
   driver.findElement(By.xpath("//a[text()='DemoLBCust']")).click();
   driver.switchTo().window(list1.get(0));
   driver.findElement(By.xpath("//a[text()='Merge']")).click();
   Alert alert=driver.switchTo().alert();
   alert.accept();
   System.out.println("Title of the resulting page  "+driver.getTitle());
   driver.quit();
	}

}
