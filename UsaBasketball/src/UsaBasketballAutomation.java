import java.awt.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activity.ActivityRequiredException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import webonise.automation.core.WeboAutomation;



    public class UsaBasketballAutomation extends WeboAutomation{
    	
    	
	UsaBasketballAutomation()
	{
		super();
		initalizeReport(this.getClass().getName());
	

	}
	
	@Test(dataProvider = "xml", enabled = true)
	public void usabsignup(Integer iteration,Boolean expectedResult) throws InterruptedException {
	updateTCData(iteration);
	//To launch browser with usab url
	actions.launchBrowser(getValue("url"));
	Thread.sleep(7000);
	//To generate random email address
	int randomnumber = (int) (100 + Math.random()*((10000 - 100) + 1));	
	String emailaddress = "atul"+randomnumber+"@gmail.com";
	//To click on 'Register Coach' Proceed link
	actions.click(getObjID("proceedbutton"));
	Thread.sleep(6000);
	//To verify the Register your account page
	Assert.assertTrue(verify.verifyHeading(getValue("accountinfo"), actions.getText(getObjID("accountinfo"))));
	//To enter firstname
	actions.sendKeys(getObjID("firstname"), getValue("firstname"));
	//To enter lastname
	actions.sendKeys(getObjID("lastname"), getValue("lastname"));
	//To enter username
	actions.sendKeys(getObjID("useremail"), emailaddress);
	//To enter password
	actions.sendKeys(getObjID("userpassword"), getValue("userpassword"));
	//To click on register your account button
	actions.click(getObjID("nextbutton"));
	Thread.sleep(6000);
	
	//To verify the Personal Information page
	Assert.assertTrue(verify.verifyHeading(getValue("personalinfo"), actions.getText(getObjID("personalinfo"))));
	//To select gender
	actions.click(getObjID("gender"));
	//To click on date of birth field
	actions.click(getObjID("dob"));
	//To select date of birth
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date date = new Date();
	String datetime = dateFormat.format(date);
	System.out.println(datetime);
	String currentdate = datetime.substring(3, 5);
	System.out.println(currentdate);
	//To select year
	actions.select(getObjID("selectyear"), getValue("selectyear"));
	//To select month
	actions.select(getObjID("selectmonth"), getValue("selectmonth"));
	//To select date 
	actions.selectDate(getObjID("selectdate"));
	actions.Wait();
	//To enter address
	actions.click(getObjID("address"));
	actions.sendKeys(getObjID("address"), getValue("address"));
	//To enter zip code
	actions.sendKeys(getObjID("zipcode"), getValue("zipcode"));
	//To enter mobile number
	actions.sendKeys(getObjID("mobilenumber"), getValue("mobilenumber"));
	//To enter phone number
	actions.sendKeys(getObjID("phonenumber"), getValue("phonenumber"));
	//To click next button
	actions.click(getObjID("nextbutton"));
	actions.Wait();
	
	//To verify Coaching Information page
	Assert.assertTrue(verify.verifyHeading(getValue("coachinginfo"), actions.getText(getObjID("coachinginfo"))));
	//To select Organization
	actions.click(getObjID("organization"));
	driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[2]/form/div[1]/div/ul/li/input")).sendKeys("test1");
	driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[2]/form/div[1]/div/ul/li/input")).sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	//To select Gold Coach license type
	actions.click(getObjID("goldcoachlicense"));
	actions.Wait();
	//To click next button
	actions.click(getObjID("nextbutton"));
	
	//To verify Payment page
	Assert.assertTrue(verify.verifyHeading(getValue("payment"), actions.getText(getObjID("payment"))));
	//To click on Credit Card option
	actions.click(getObjID("creditcard"));
	//To enter Credit Card email address
	actions.sendKeys(getObjID("creditemail"), emailaddress);
	//To enter card number
	actions.sendKeys(getObjID("cardnumber"), getValue("cardnumber"));
	//To enter card verification
	actions.sendKeys(getObjID("cardverification"), getValue("cardverification"));
	//To select card expiry month
	actions.select(getObjID("cardexpirymonth"), getValue("cardexpirymonth"));
	//To select card expiry year
	actions.select(getObjID("cardexpiryyear"), getValue("cardexpiryyear"));
	//To click on submit button
	actions.click(getObjID("nextbutton"));
	Thread.sleep(7000);
	
	
	/*//To click on US Banks option in payment section
	actions.click(getObjID("usbanks"));
	//To enter Account Holder Name
	actions.sendKeys(getObjID("accountholdername"), getValue("accountholdername"));
	//To select account type
	actions.select(getObjID("accounttype"), getValue("accounttype"));
	//To enter account number
	actions.sendKeys(getObjID("accountnumber"), getValue("accountnumber"));
	//To enter routing number
	actions.sendKeys(getObjID("routingnumber"), getValue("routingnumber"));
	//To click on submit button
	//actions.click(getObjID("nextbutton"));
*/	

	//To verify coach dashboard page
	Assert.assertTrue(verify.verifyHeading(getValue("coachdashboard"), actions.getText(getObjID("coachdashboard"))));
	
	
	Thread.sleep(5000);
	driver.quit();
    }
}
