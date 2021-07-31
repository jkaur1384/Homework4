package hw3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//CSS rule 1 tagName[attribute='value']
		driver.findElement(By.cssSelector("a[class='login']")).click();
		System.out.println(driver.findElement(By.cssSelector("a[class='login']")).isDisplayed() +"--Signin button found");

//CSS rule 2 tagName#id-value
		driver.findElement(By.cssSelector("input#email_create")).sendKeys("jsmith5678@yahoo.com");
		System.out.println(driver.findElement(By.cssSelector("input#email_create")).isEnabled() +"--Email address is Enabled");

//CSS rule 3  tagname.class-value	
		driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium.exclusive")).click();
		System.out.println(driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium.exclusive")).isEnabled() +"--Create an account button is Enabled");

//CSS rule 5 #id-value
		driver.findElement(By.cssSelector("#id_gender1")).click();
		System.out.println(driver.findElement(By.cssSelector("#id_gender1")).isSelected() +"--Mr. is Selected");

//CSS rule 6 tagName[attribute*='sub_string_slashunder']
		driver.findElement(By.cssSelector("input[id*='_firstname']")).sendKeys("John");
		System.out.println(driver.findElement(By.cssSelector("input[id*='_firstname']")).isDisplayed() +"--First name is Displayed");

//CSS rule 7 tagName[attribute^='start of String']	
		driver.findElement(By.cssSelector("input[id^='customer_lastname']")).sendKeys("Smith");
		System.out.println(driver.findElement(By.cssSelector("input[id^='customer_lastname']")).isDisplayed()+"--Last name is Displayed");

//CSS rule 8 tagName[attribute1='value'][attribute2='value']
		driver.findElement(By.cssSelector("input[name='passwd'][id='passwd']")).sendKeys("abc5679");
		System.out.println(driver.findElement(By.cssSelector("input[name='passwd'][id='passwd']")).isDisplayed()+"--Password is Displayed");

//CSS rule 4 .class-value.class-value..... *if multiple value of class with spaces
		//driver.findElement(By.cssSelector(".form-control")).sendKeys("10");
		//System.out.println(driver.findElement(By.cssSelector(".form-control")).Size()+"--count");
		
//CSS rule - 9 tag[attribute$=suffix of the string]
		driver.findElement(By.cssSelector("input[id$=newsletter]")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id$=newsletter]")).isSelected()+"--Sign up for newsletter is selected");
		
//CSS rule 1 tagName[attribute='value']
		driver.findElement(By.cssSelector("input[id='optin']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id='optin']")).isEnabled()+"--Receive speical offers is Enabled");

//CSS rule 2 tagName#id-value
		driver.findElement(By.cssSelector("input#company")).sendKeys("AbcTech");
		System.out.println(driver.findElement(By.cssSelector("input#company")).isDisplayed()+"--Company name is Displayed");

//CSS rule 5 #id-value
		driver.findElement(By.cssSelector("#address1")).sendKeys("45 church st");
		System.out.println(driver.findElement(By.cssSelector("#address1")).isEnabled()+"--Address is Enabled");
		
//CSS rule 6 tagName[attribute*='sub_string_slashunder']
		driver.findElement(By.cssSelector("input[id*='city']")).sendKeys("New York");
		System.out.println(driver.findElement(By.cssSelector("input[id*='city']")).isDisplayed()+"--City name is Displayed");
		
//CSS rule 7 tagName[attribute^='start of String']	
		driver.findElement(By.cssSelector("select[id^='id_state']")).sendKeys("New York");
		System.out.println(driver.findElement(By.cssSelector("select[id^='id_state']")).isEnabled()+"--State is Enabled");
	
//CSS rule 8 tagName[attribute1='value'][attribute2='value']
		driver.findElement(By.cssSelector("input[name='postcode'][id='postcode']")).sendKeys("10001");
		System.out.println(driver.findElement(By.cssSelector("input[name='postcode'][id='postcode']")).isDisplayed()+"--Zipcode is Displayed");

//CSS rule - 9 tag[attribute$=suffix of the string]
		driver.findElement(By.cssSelector("select[id$=id_country]")).sendKeys("United States");
		System.out.println(driver.findElement(By.cssSelector("select[id$=id_country]")).isEnabled()+"--Country is Enabled");
		
//CSS rule 1 tagName[attribute='value']
		driver.findElement(By.cssSelector("input[id='phone']")).sendKeys("7894568856");
		System.out.println(driver.findElement(By.cssSelector("input[id='phone']")).isDisplayed()+"--Home Phone is Displayed");
		
//CSS rule 2 tagName#id-value
		driver.findElement(By.cssSelector("input#phone_mobile")).sendKeys("6467895665");
		System.out.println(driver.findElement(By.cssSelector("input#phone_mobile")).isEnabled()+"--Mobile Phone is Enabled");
	
	driver.close();
	
		

	
	}

}
