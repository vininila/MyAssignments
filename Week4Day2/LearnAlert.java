package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.leafground.com/alert.xhtml");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    
    //click the web element
    driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
   
    //transfer the control from web element to Alert
    Alert alert=driver.switchTo().alert();
    
    System.out.println("Getting Alert Message before clicking OK:"+ alert.getText());
    alert.accept();// accepting the alert
    String text=driver.findElement(By.id("simple_result")).getText();
    System.out.println(text);
     
    //sweet alert(Simple dialog) is inspectable and should not be handled with Alert class
    driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
    driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
    
    //sweet alert(Confirmation)
    driver.findElement(By.xpath("//span[text()='Delete']")).click();
    driver.findElement(By.xpath("//span[text()='No']")).click();
    
    //handling Prompt alert by entering the text and getting entered text
    driver.findElement(By.xpath("(//button[@name='j_idt88:j_idt104']//span)[2]")).click();
    alert.sendKeys("Vennila");
    alert.accept();
    String userEnteredName = driver.findElement(By.id("confirm_result")).getText();
    System.out.println(userEnteredName);
	}

}
