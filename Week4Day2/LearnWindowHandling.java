package Week4Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandling {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.leafground.com/window.xhtml");//parent window
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    String parent = driver.getWindowHandle();
    System.out.println(parent);
    driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
    Set<String> windowHandles = driver.getWindowHandles();
    System.out.println(windowHandles.size());
    
    for (String string : windowHandles) {
		System.out.println(string);
	}
    List<String> list=new ArrayList<String>(windowHandles);
    //switch to child window
    driver.switchTo().window(list.get(1));
    String title = driver.getTitle();
    System.out.println(title);//title of child window
    
    //SNAPSHOT
    File source = driver.getScreenshotAs(OutputType.FILE);
    //creating runtime path/file to store the screenshot
    File dest=new File("C:\\Users\\Public\\Pictures\shot.jpg");
    FileUtils.copyFile(source, dest);  
    
    
   
	}

}
