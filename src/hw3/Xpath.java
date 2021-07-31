package hw3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Xpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//X-path rule 1 //tagName[@attribute='value']
		driver.findElement(By.xpath("//a[@class='login']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@class='login']")).isEnabled() +"--Signin button found");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("jsmith5678@yahoo.com");
		System.out.println(driver.findElement(By.xpath("//input[@id='email_create']")).isEnabled()+"--Email create is Enabled");

//X-path rule 2 //tagName[@attribute='value'][@attribute='value']
		driver.findElement(By.xpath("//button[@id='SubmitCreate'][@name='SubmitCreate']")).click();
		System.out.println(driver.findElement(By.xpath("//button[@id='SubmitCreate'][@name='SubmitCreate']")).isEnabled() +"--Create an account button is Enabled");

//X-path rule 3//tagName[contains(@attribute,'value')]
		driver.findElement(By.xpath("//label[contains(@for,'id_gender1')]")).click();
		System.out.println(driver.findElement(By.xpath("//label[contains(@for,'id_gender1')]")).isEnabled()+"--Mr.is Enabled");

//X-path rule 4//tagName[starts-with(@attribute,'value')]
		driver.findElement(By.xpath("//input[starts-with(@id,'customer_firstname')]")).sendKeys("John");
		System.out.println(driver.findElement(By.xpath("//input[starts-with(@id,'customer_firstname')]")).isDisplayed()+"--First name is Displayed");

//X-path rule 5//tagName[starts-with(@attribute,'value')and(@attribute='value')]
		driver.findElement(By.xpath("//input[starts-with(@id,'customer_lastname')and(@name='customer_lastname')]")).sendKeys("Smith");
		System.out.println(driver.findElement(By.xpath("//input[starts-with(@id,'customer_lastname')and(@name='customer_lastname')]")).isDisplayed()+"--Last name is displayed");

//X-path rule 6 //tagName[starts-with(@attribute,'value') or (@attribute='value')]
		driver.findElement(By.xpath("//input[starts-with(@name,'email') or (@id='email')]")).sendKeys("jsmith5678@yahoo.com");
		System.out.println(driver.findElement(By.xpath("//input[starts-with(@name,'email') or (@id='email')]")).isEnabled()+"--Email is Enabled");

//X-path rule 7//*[@attribute='value']
		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("abc5678");
		System.out.println(driver.findElement(By.xpath("//*[@id='passwd']")).isDisplayed()+"----Password is displayed");

//X-path rule 8//*[@attribute='value' or @attribute='value']
		WebElement drpDays = driver.findElement(By.xpath("//*[@id='days' or @name='days']"));
		drpDays.click();
		Select Day = new Select(drpDays);
		Day.selectByIndex(5);
		System.out.println(driver.findElement(By.xpath("//*[@id='days' or @name='days']")).isEnabled()+"--Day is Enabled");

//X-path rule 9//*[@attribute='value' and @attribute='value']
		WebElement drpMonth = driver.findElement(By.xpath("//*[@id='months' and @name='months']"));
		drpMonth.click();
		Select Month = new Select(drpMonth);
		Month.selectByIndex(1);
		System.out.println(driver.findElement(By.xpath("//*[@id='months' or @name='months']")).isEnabled()+"--Month is Enabled");

//X-path rule 9//*[@attribute='value' and @attribute='value']
		WebElement drpYear = driver.findElement(By.xpath("//*[@id='years' and @name='years']"));
		drpYear.click();
		Select Year = new Select(drpYear);
		Year.selectByIndex(1);
		System.out.println(driver.findElement(By.xpath("//*[@id='years' or @name='years']")).isEnabled()+"--Year is Enabled");

//X-path rule 1 //tagName[@attribute='value']
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='newsletter']")).isSelected()+"--Newsletter is Selected");

//X-path rule 10//*[@attribute='value' and @attribute='value' or @attribute='value']
		driver.findElement(By.xpath("//*[@type='checkbox' and @name='optin' or @id='optin']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@type='checkbox' and @name='optin' or @id='optin']")).isSelected()+"--Optin is Selected");

//X-path rule 3//tagName[contains(@attribute,'value')]
		driver.findElement(By.xpath("//input[contains(@id,'company')]")).sendKeys("abctech");
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'company')]")).isDisplayed()+"--Company is Displayed");

//X-path rule 4//tagName[starts-with(@attribute,'value')]
		driver.findElement(By.xpath("//input[starts-with(@name,'address1')]")).sendKeys("45 water st");
		System.out.println(driver.findElement(By.xpath("//input[starts-with(@name,'address1')]")).isDisplayed()+"--Address is Displayed");

//X-path rule 5//tagName[starts-with(@attribute,'value')and(@attribute='value')]
		driver.findElement(By.xpath("//input[starts-with(@name,'city')and(@id='city')]")).sendKeys("New York");
		System.out.println(driver.findElement(By.xpath("//input[starts-with(@name,'city')and(@id='city')]")).isEnabled()+"--City is Enabled");

//X-path rule 6 //tagName[starts-with(@attribute,'value') or (@attribute='value')]
		driver.findElement(By.xpath("//select[starts-with(@name,'id_state') or (@id='id_state')]")).sendKeys("New York");
		System.out.println(driver.findElement(By.xpath("//select[starts-with(@name,'id_state') or (@id='id_state')]")).isEnabled()+"--State is Enabled");

//X-path rule 7//*[@attribute='value']
		driver.findElement(By.xpath("//*[@name='postcode']")).sendKeys("10001");
		System.out.println(driver.findElement(By.xpath("//*[@name='postcode']")).isDisplayed()+"--Postcode is Displayed");

//X-path rule 8//*[@attribute='value' or @attribute='value']
		WebElement drpCountry = driver.findElement(By.xpath("//*[@name='id_country' or @id='id_country']"));
		drpCountry.click();
		Select Country = new Select(drpCountry);
		Country.selectByVisibleText("United States");
		System.out.println(driver.findElement(By.xpath("//*[@name='id_country' or @id='id_country']")).isEnabled()+"--Country is Enabled");

//X-path rule 1 //tagName[@attribute='value']
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9171175678");
		System.out.println(driver.findElement(By.xpath("//input[@name='phone']")).isDisplayed()+"--Phone is Displayed");

//X-path rule 2 //tagName[@attribute='value'][@attribute='value']
		driver.findElement(By.xpath("//input[@name='phone_mobile'][@id='phone_mobile']")).sendKeys("6455587896");
		System.out.println(driver.findElement(By.xpath("//input[@name='phone_mobile'][@id='phone_mobile']")).isEnabled()+"--Mobile Phone is Enabled");
	
driver.close();

		
		
		
		

		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
