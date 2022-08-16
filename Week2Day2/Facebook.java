package Week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.xpath("//a[contains(@data-testid,'open-registration')]")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vennila");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sivakumar");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("august@678");
        WebElement Date=driver.findElement(By.name("birthday_day"));
        Select dat=new Select(Date);
        dat.selectByVisibleText("29");
        WebElement Month=driver.findElement(By.name("birthday_month"));
        Select mon=new Select(Month);
        mon.selectByVisibleText("Jun");
        WebElement Year=driver.findElement(By.name("birthday_year"));
        Select yea=new Select(Year);
        yea.selectByVisibleText("1992");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        String title=driver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        driver.close();
	}

}
