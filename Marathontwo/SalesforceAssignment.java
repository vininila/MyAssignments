package Marathontwo;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceAssignment extends CommonClass {
	@BeforeTest//this will be executed before data provider
	public void setFileName() {
		fileName="salesforcesample";
	}
    @Test(dataProvider="testData")//to use the data from testData()
	public void salesForce(String question, String details) throws InterruptedException {
		
        //05) Type Content on the Search box
        driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Content");
        //06) Click Content Link
        driver.findElement(By.xpath("//mark[text()='Content']")).click();
        //07) Click on Chatter Tab
        WebElement click = driver.findElement(By.xpath("//span[text()='Chatter']"));
        driver.executeScript("arguments[0].click();", click);
        //08) Verify Chatter title on the page
        Thread.sleep(1000);
        System.out.println("Title is " +driver.getTitle());
        //09) Click Question tab
        driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
        //10) Type Question with data (coming from excel)
        driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(question);
        //11) Type Details with data (coming from excel)
        driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(details);
        //12) Click Ask
        driver.findElement(By.xpath("//button[text()='Ask']")).click();
        String aaa = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
       
        //13) Confirm the question appears
       
		System.out.println(aaa);
	        if(aaa.contains(question)) 
	        {
        	System.out.println("Confirms questions is added");
        	}
            else {
        	System.out.println("Question not added");
	}}

}
