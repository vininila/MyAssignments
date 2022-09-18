package testcase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLead extends CommonClass{
@Test(dataProvider="testData")//to use the data from testData()
	public void creatingLead(String cname, String fname, String lname) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		driver.findElement(By.name("submitButton")).click();
		
}
@DataProvider//(name="fetchData")
public String[][] testData() {
	String[][] data=new String[2][3];
	//runs as first testcase
	data[0][0]="TCS";
	data[0][1]="Vennila";
	data[0][2]="S";
	//runs as second testcase
	data[1][0]="CTS";
	data[1][1]="Siva";
	data[1][2]="S";
	return data;
}
}






