package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.leafground.com/frame.xhtml");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   //to handle the frame using index 
     driver.switchTo().frame(0);
    WebElement web= driver.findElement(By.id("Click"));
    web.click();
    System.out.println(web.getText());
    driver.switchTo().defaultContent();//to give the control back from frame to webpage driver
    
    //to handle nested 	frames
    driver.switchTo().frame(2);
    driver.switchTo().frame("frame2");
    WebElement web1= driver.findElement(By.id("Click"));
    web1.click();
    System.out.println(web1.getText());
    
   
	}

}
