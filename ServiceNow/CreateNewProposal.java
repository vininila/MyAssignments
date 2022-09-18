package ServiceNow;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewProposal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		 //Launch ServiceNow application
		driver.get("https://dev116151.service-now.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Login with valid credentials username as admin and password as India@123
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("India@123");
        driver.findElement(By.id("sysverb_login")).click();
        Thread.sleep(5000);
	//3. Click All and Enter Proposal in filter navigator and press enter 
	Shadow shadow =new Shadow(driver);
	shadow.setImplicitWait(30);
	shadow.findElementByXPath("//div[@id='all']").click();
	Thread.sleep(1000);
	shadow.findElementByXPath("//input[@id='filter']").sendKeys("Proposal",Keys.ENTER);
	//shadow.findElementByXPath("//div[@id='all']").click();
	Thread.sleep(3000);
	shadow.findElementByXPath("//input[@id='filter']").sendKeys(Keys.ENTER);
	//4. Click- new  and  fill mandatory fields and click 'Submit' Button.
	WebElement frame1 = shadow.findElementByXPath("//iframe[@title='Main Content']");
    driver.switchTo().frame(frame1);
    driver.findElement(By.id("sysverb_new")).click();
	String text1 = driver.findElement(By.xpath("//input[@class='form-control ']")).getAttribute("attribute_value");
	System.out.println("Incident Number  "+text1);
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("New proposal ticket");
	driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	//5. Verify the successful creation of new Proposal"
   //driver.switchTo().defaultContent();
WebElement element = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
Select dropDown=new Select(element);
dropDown.selectByVisibleText("Number");
driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(text1,Keys.ENTER);
String element2 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
if(text1.equals(element2))
	System.out.println("Incident number matches");
else
	System.out.println("Incident number not matched");




}
}
