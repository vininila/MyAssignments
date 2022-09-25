package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.ProjectSpecificMethod;
import Pages.LoginPage;

public class CreateLead extends ProjectSpecificMethod{
	@BeforeTest
	public void setFileName() {
		fileName="credential";
	}
   @Test(dataProvider="testData")
   public void creatingLead(String uname, String pwd) {
		
		LoginPage lp=new LoginPage(driver);//creating obj ref to call LoginPage methods
		lp.enterUsername(uname).enterPassword(pwd).clickLogin().clickCrmsfa().clickLeads();
		//new LoginPage().enterUsername().enterPassword().clickLogin().clickCrmsfa();
	}
}
