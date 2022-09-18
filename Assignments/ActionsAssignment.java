package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		 //Load the uRL https://jqueryui.com/draggable/
		driver.get("https://jqueryui.com/draggable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);
        //https://jqueryui.com/draggable
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'ui-widget-content ui-draggable')]"));
        Actions act=new Actions(driver);
        act.dragAndDropBy(element,200, 50).perform();
        //https://jqueryui.com/droppable
        Thread.sleep(2000);
        driver.get("https://jqueryui.com/droppable");
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[contains(@class,'ui-widget-content ui-draggable')]"));
        WebElement drop = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
        act.dragAndDrop(drag, drop).perform();
        //https://jqueryui.com/resizable
        Thread.sleep(2000);
        driver.get("https://jqueryui.com/resizable");
        driver.switchTo().frame(0);
        WebElement resize = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-handle ui-resizable-se')]"));
        act.clickAndHold(resize).moveByOffset(0, 10).perform();
        //https://jqueryui.com/selectable
        Thread.sleep(2000);
        driver.get("https://jqueryui.com/selectable");
        driver.switchTo().frame(0);
        WebElement item1 = driver.findElement(By.xpath("//li[@class='ui-widget-content ui-selectee']"));
        WebElement item6 = driver.findElement(By.xpath("//ol[@id='selectable']/li[6]"));
        act.clickAndHold(item1).scrollToElement(item6).release().perform();
        //..
        //clickdragAndDrop(item1, item6).perform();
        
	}

}
