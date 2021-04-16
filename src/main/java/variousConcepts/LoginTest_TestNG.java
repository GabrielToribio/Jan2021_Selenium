package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest_TestNG {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/admin");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

//	@Test
	public void loginTest() throws InterruptedException {
		// Element Library

		Assert.assertEquals(driver.getTitle(), "Login - TechFios Test Application - Billing", "Wrong page");

		WebElement USERNAME_FIELD = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_FIELD = driver.findElement(By.xpath("//input[@id='password']"));

		USERNAME_FIELD.sendKeys("techfiosdemo@gmail.com");
		PASSWORD_FIELD.sendKeys("abc123");

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		Assert.assertEquals(driver.getTitle(), "Dashboard- TechFios Test Application - Billing", "Wrong page");
	}

	@Test
	public void addCustomerTest() throws InterruptedException {

		// Element Library
		By USER_NAME_FIELD = By.name("email");
		By PASSWORD_FIELD = By.name("password");
		By SIGNIN_BUTTON = By.xpath("/html/body/div[2]/form[1]/button");
		By DASHBOARD_BUTTON = By.xpath("//span[contains(text(), 'Dashboard')]");
		By ACCOUNTS_BUTTON = By.xpath("//*[@id=\"social-sidebar-menu\"]/li[5]/a");
		By CUSTOMERS_BUTTON = By.xpath("//*[@id=\"ACCOUNTS\"]/li[3]/a");
		By ADD_CUSTOMER_LOCATOR = By.xpath("//button[@type='submit']");
		By FIRST_NAME_FIELD = By.xpath("//input[@name='fname']");
		By LAST_NAME_FIELD = By.xpath("//input[@name='lname']");
		By CUSTOMER_PASSWORD_FIELD = By.xpath("//input[@name='email']");
		By EMAIL_FIELD = By.xpath("//input[@name='email']");
		By PHONE_FIELD = By.xpath("//input[@name='mobile']");
		By ADDRESS_FIELD1 = By.xpath("//input[@name='address1']");
		By ADDRESS_FIELD2 = By.xpath("//input[@name='address2']");
		By COUNTRIES = By.xpath("//span[@class='select2-chosen']");
		By COUNTRIES_FIELD = By.xpath("//input[@class='select2-input']");
		By SUBMIT_BUTTON = By.xpath("//button[@class='btn btn-primary btn-block btn-lg']");
		By CHECKBOX = By.xpath("//input[@class='checkbox']");

		//Login Data
		String loginId = "admin@phptravels.com";
		String password = "demoadmin";
		
		//Test Data
		String fname = "Test";
		String lname = "January 2021";
		String number = "789";
		String emailAddress = "testJan@gmail.com";
		String pass = "password";
		String address = "somewhere road";
		String address2 = "Apt 4D";
		
		//Login
//		Assert.assertEquals(driver.getTitle(), "Administator Login", "Wrong page");
		driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();
//		driver.findElement(By.xpath("//button[@data-target='#quickbook']")).click();
		
		
		//Validate Dashboard Page
		waitForElement(driver, 3, ACCOUNTS_BUTTON);
//		Assert.assertEquals(driver.getTitle(), "Dashboard", "Wrong page");
		
		//Add Customer
		driver.findElement(ACCOUNTS_BUTTON).click();
		driver.findElement(CUSTOMERS_BUTTON).click();
		
		Thread.sleep(2000);
		driver.findElement(ADD_CUSTOMER_LOCATOR).click();
		
		waitForElement(driver, 3, FIRST_NAME_FIELD);
		driver.findElement(FIRST_NAME_FIELD).sendKeys(fname);
		/*
		 * driver.findElement(LAST_NAME_FIELD).sendKeys(lname);
		 * driver.findElement(EMAIL_FIELD).sendKeys(emailAddress);
		 * driver.findElement(PASSWORD_FIELD).sendKeys(pass);
		 * driver.findElement(ADDRESS_FIELD1).sendKeys(address);
		 * driver.findElement(ADDRESS_FIELD2).sendKeys(address2);
		 * driver.findElement(CHECKBOX).click();
		 */
		
		driver.findElement(COUNTRIES).click();
		driver.findElement(COUNTRIES_FIELD).sendKeys("United States");
		
		
//		driver.findElement(SUBMIT_BUTTON).click();
		
	}

//	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	public void waitForElement(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
}
