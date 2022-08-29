package Week4Day2;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrameAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.switchTo().frame("iframeResult");
    driver.findElement(By.xpath("//button[text()='Try it']")).click();
    
    Alert alert = driver.switchTo().alert();
    alert.accept();
    String text=driver.findElement(By.id("demo")).getText();
    System.out.println(text);
    

    
	}

}
