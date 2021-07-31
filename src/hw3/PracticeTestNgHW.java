package hw3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTestNgHW {
	WebDriver driver;
	WebDriverWait Ex;

@BeforeTest(groups="smoke0")

public void setup()  {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	Ex=new WebDriverWait(driver, 6);}

 @Test (priority=0, groups = {"smoke1"})
public void openurl() {
	 driver.get("http://automationpractice.com/index.php");
	}

 @Test (priority=1, dependsOnMethods = {"openurl"}, groups = {"smoke2","functional1"})
public void signin() {
	//X-path rule1 //tagName[@attribute='value']
	driver.findElement(By.xpath("//a[@class='login']")).click();
String ExpectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account";
String ActualURL=driver.getCurrentUrl();
Assert.assertEquals(ExpectedURL,ActualURL );
System.out.println("Assert Passed");
}

@Test (priority=2,invocationCount = 3, groups = {"regression","functional2"})
public void enteremail() {
	//CSS rule 2 tagName#id-value
	driver.findElement(By.cssSelector("input#email_create")).sendKeys("jsmith5678@yahoo.com");
	String ExpectedForm="create-account_form";
	String ActualForm=driver.findElement(By.id("create-account_form")).getAttribute("id");
	Assert.assertEquals( ExpectedForm,ActualForm );
	System.out.println("Form was found");

}


@Test (priority=3,groups ={"functional3"})
public void clicksubmit() {
	//X-path Rule 2//tagName[@attribute='value'][@attribute='value']
	WebElement SubmitCreate=driver.findElement(By.xpath("//button[@id='SubmitCreate'][@name='SubmitCreate']"));
	SubmitCreate.click();
	Assert.assertEquals(true, SubmitCreate.isEnabled());
	System.out.println("Submit Create Assert Passed");
}

@Test (priority=4,groups = {"functional4"})
public void personalinfo() {
	String ExpectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	Ex.until(ExpectedConditions.urlToBe(ExpectedURL));
	String ExpectedForm="account-creation_form";
	String ActualForm=driver.findElement(By.id("account-creation_form")).getAttribute("id");
	Assert.assertEquals(ExpectedForm,ActualForm );
	System.out.println("Form was found");
}

@Test (priority=5,groups = {"functional5"})
public void selectradio() {
	//CSS rule 1 tagName[attribute='value']
	WebElement genderFemale=driver.findElement(By.cssSelector("input[id='id_gender2']"));
	genderFemale.click();
	Assert.assertEquals(true, genderFemale.isSelected());
	System.out.println("gender Female Assert Passed");
}

@Test (priority=6,groups = {"functional6"},dependsOnMethods = {"personalinfo"})
public void enterFirstName() {
	//X-path rule 3//tagName[contains(@attribute,'value')]
WebElement firstName=driver.findElement(By.xpath("//input[contains(@id,'customer_firstname')]"));
firstName.sendKeys("Jenn");
String Expected="customer_firstname";
String Actual=driver.findElement(By.id("customer_firstname")).getAttribute("id");
Assert.assertEquals(Expected,Actual);
System.out.println("first Name Assert Passed");
}

@Test (priority=7)
public void enterLastName() {
	//X-path rule 5//tagName[starts-with(@attribute,'value')and(@attribute='value')]
WebElement lastName=driver.findElement(By.xpath("//input[starts-with(@id,'customer_lastname')and(@name='customer_lastname')]"));
lastName.sendKeys("Smith");
String Expected="customer_lastname";
String Actual=driver.findElement(By.id("customer_lastname")).getAttribute("id");
Assert.assertEquals(Expected,Actual);
System.out.println("last Name Assert Passed");
}

@Test (priority=8)
public void enterPassword() {
	//CSS rule 5 #id-value
WebElement password=driver.findElement(By.cssSelector("#passwd"));
password.sendKeys("abc5678");
String Expected="passwd";
String Actual=driver.findElement(By.id("passwd")).getAttribute("id");
Assert.assertEquals(Expected,Actual);
System.out.println("password Assert Passed");
}

@Test (priority=9)
public void selectdays() {
	WebElement drpdays=driver.findElement(By.id("days"));
	//Ex.until(ExpectedConditions.elementToBeClickable(drpdays));
	drpdays.click();
	Select Days=new Select (drpdays);
	Days.selectByValue("1");
	String Option=Days.getFirstSelectedOption().getText();
	Assert.assertEquals("1",Option );
	}	
@Test (priority=10)
public void selectmonths() {
	WebElement drpmonths=driver.findElement(By.id("months"));
	drpmonths.click();
	Select Months=new Select (drpmonths);
	Months.selectByVisibleText("May ");
	String Option=Months.getFirstSelectedOption().getText();
	Assert.assertEquals("May ",Option );
	}	
@Test (priority=11)
public void selectyears() {
	WebElement drpyears=driver.findElement(By.id("years"));
	drpyears.click();
	Select Years=new Select (drpyears);
	Years.selectByVisibleText("2021");
	String Option=Years.getFirstSelectedOption().getText();
	Assert.assertEquals("2021 ",Option );
}

@Test (priority=12)
public void checkNewsletter() {
	//X-path rule 4//tagName[starts-with(@attribute,'value')]
	WebElement newsletter=driver.findElement(By.xpath("//input[starts-with(@id,'newsletter')]"));
	newsletter.click();
	Assert.assertEquals(true,newsletter.isSelected());
	System.out.println("newsletter Assert Passed");
}

@Test (priority=13)
 public void checkReceiveoffers() {
	//x-path rule 7//*[@attribute='value']
WebElement Receiveoffers=driver.findElement(By.xpath("//*[@id='optin']"));
Receiveoffers.click();
Assert.assertEquals(true,Receiveoffers.isSelected());
System.out.println("Receiveoffers Assert Passed");
}

@Test (priority=14)
public void enterCompany() {
//x-path rule 8	//*[@attribute='value' or @attribute='value']
	WebElement Company=driver.findElement(By.xpath("//*[@id='company' or @name='company']"));
	Company.sendKeys("AbcTech");
	String Expected="company";
	String Actual=driver.findElement(By.id("company")).getAttribute("id");
	Assert.assertEquals(Expected,Actual);
	System.out.println("Company Assert Passed");
}

@Test (priority=15)
public void enterAddress() {
//X-path rule 9	//*[@attribute='value' and @attribute='value']
	WebElement Address=driver.findElement(By.xpath("//*[@id='address1' and @name='address1']"));
	Address.sendKeys("45 Church St");
	String Expected="address1";
	String Actual=driver.findElement(By.id("address1")).getAttribute("id");
	Assert.assertEquals(Expected,Actual);
	System.out.println("Address1 Assert Passed");
}

@Test (priority=16)
public void enterCity() {
//X-path rule 1	//tagName[@attribute='value']
	WebElement City=driver.findElement(By.xpath("//input[@id='city']"));
	City.sendKeys("New York");
	String Expected="city";
	String Actual=driver.findElement(By.id("city")).getAttribute("id");
	Assert.assertEquals(Expected,Actual);
	System.out.println("City Assert Passed");
}
@Test(priority=17)
public void selectState() {
	WebElement drpState = driver.findElement(By.id("id_state"));
	drpState.click();
	Select states = new Select(drpState);
	states.selectByVisibleText("New York");
	String option = states.getFirstSelectedOption().getText();
	Assert.assertEquals("New York", option);
}

@Test (priority=18)
public void enterZipcode() {
//X-path rule 2//tagName[@attribute='value'][@attribute='value']
	WebElement Zipcode=driver.findElement(By.xpath("//input[@name='postcode'][@id='postcode']"));
	Zipcode.sendKeys("10005");
	String Expected="postcode";
	String Actual=driver.findElement(By.id("postcode")).getAttribute("id");
	Assert.assertEquals(Expected,Actual);
	System.out.println("Zipcode Assert Passed");
}
@Test (priority=19)
public void selectCountry() {
	WebElement drpCountry = driver.findElement(By.id("id_country"));
	drpCountry.click();
	Select countrys = new Select(drpCountry);
	countrys.selectByVisibleText("United States");
	String option = countrys.getFirstSelectedOption().getText();
	Assert.assertEquals("United States", option);
}
@Test (priority=20)
public void enteradditionalInfo() {
	WebElement additionalInfo=driver.findElement(By.id("other"));
	additionalInfo.sendKeys("None");
	String Expected="other";
	String Actual=driver.findElement(By.id("other")).getAttribute("id");
	Assert.assertEquals(Expected,Actual);
	System.out.println("additionalInfo Assert Passed");
}
@Test (priority=21)
public void entermobilephone() {
	WebElement mobilephone=driver.findElement(By.id("phone_mobile"));
	Assert.assertEquals(true, mobilephone.isDisplayed());
	System.out.println("--isDisplayed Assertion Passed");
	mobilephone.sendKeys("5145586952");
	Assert.assertEquals(true, mobilephone.isEnabled());
	System.out.println("--isEnabled Assertion Passed");
	Assert.assertEquals(false, mobilephone.isSelected());
	System.out.println("--isSelected Assertion Passed");
	String ExpectedValue="5145586952";
	String Actualvalue=driver.findElement(By.id("phone_mobile")).getAttribute("value");
	Assert.assertEquals( Actualvalue,ExpectedValue );
	System.out.println(Actualvalue+"--Assertion passed");
	int mobilenumber=driver.findElements(By.id("phone_mobile")).size();
		if(mobilenumber==0)
		{	
		System.out.println("--Mobilenumber is verified");
		}
		else if (mobilenumber==1) {
			System.out.println("Mobile Number Duplicate found" );
		}
		
		
		else
		{
			System.out.println("--Mobilenumber is not verified");
		}
}	

@Test (priority=21)
public void enteraddressAlias() {
	//CSS rule 1 tagName[attribute='value']
	WebElement addressAlias=driver.findElement(By.cssSelector("input[id='alias']"));
	addressAlias.sendKeys("55 Water St");
	String expected = "alias";
	String actual = driver.findElement(By.id("alias")).getAttribute("id");
	Assert.assertEquals(actual, expected);
	System.out.println("Assertion alias is passed");
}

@AfterTest
public void closetab() {
driver.close();

}
}











