package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustServiceAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
//Launch the browser
		driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Enter the username as " ramkumar.ramaiah@testleaf.com "
        driver.findElement(By.xpath("//input[contains(@class,'input r4')]")).sendKeys("ramkumar.ramaiah@testleaf.com");
        //Enter the password as " Password#123 "
        driver.findElement(By.xpath("(//input[contains(@class,'input r4')])[2]")).sendKeys("Password#123");
        //click on the login button
        driver.findElement(By.xpath("//input[contains(@class,'button r4')]")).click();
        //click on the learn more option in the Mobile publisher
        driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
        //Switch to the next window using Windowhandles
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> list=new ArrayList<String>(windowHandles);
        driver.switchTo().window(list.get(1));
        //click on the confirm button in the redirecting page
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
        //Get the title
        System.out.println("Title of the page:  "+driver.getTitle());
        //Get back to the parent window
        driver.switchTo().window(list.get(0));
        //close the browser
        driver.quit();
        

        
       

	}

}
