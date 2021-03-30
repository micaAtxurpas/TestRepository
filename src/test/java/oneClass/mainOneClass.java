package oneClass;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
// This is a comment
public class mainOneClass {
// new Mai Comment
	public static void main(String[] args) {
		// FSO INSTAFORM
		// Step 1 - Check Serviceability

		System.setProperty("webdriver.gecko.driver",
				"/Users/micadeguzman/Documents/_Automation/Selenium/browserDrivers/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("https://edo-dev-data-engineering.globe.com.ph/sat/fso-customer/?ref=RlNPOm10ZXN0MQ%3D%3D");
		// driver.get("https://edo-dev-data-engineering.globe.com.ph/sat/fso-customer");

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		String title = driver.getTitle();
		System.out.println(title.length());
		System.out.println(title);

		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		// wait to find visible element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement streetName = driver.findElement(By.xpath("//*[@id='streetName']"));
		streetName.sendKeys("Test Street Name");

		WebElement houseNo = driver.findElement(By.xpath("//*[@id='houseNum']"));
		houseNo.sendKeys("Test House Number");

		WebElement province = driver.findElement(By.xpath("//*[@id='province']"));
		Select sProvince = new Select(province);
		sProvince.selectByIndex(50);

		WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
		Select sCity = new Select(city);
		sCity.selectByIndex(2);

		WebElement barangay = driver.findElement(By.xpath("//*[@id='barangay']"));
		Select sBarangay = new Select(barangay);
		sBarangay.selectByIndex(1);

		// click x button of footer terms & conditions
		// driver.findElement(By.xpath("/html/body/app-root/app-home/div[2]/div/footer/div/span")).click();

		// click check location button
		// driver.findElement(By.xpath("/html/body/app-root/app-home/div[2]/div/div[2]/app-check-servicibility/div/div/div/div[2]/div[2]/form/div[6]/button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/app-root/app-home/div[2]/div/div[2]/app-check-servicibility/div/div/div/div[2]/div[2]/form/div[6]/button")))
				.click();
		

		// click Confirm Location button
		// driver.findElement(By.xpath("/html/body/app-root/app-home/div[2]/app-map-view/div/div/div/button")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/app-root/app-home/div[2]/app-map-view/div/div/div/button")))
				.click();

		// STEP 2 - SELECT A PLAN
		// select a Plan
		driver.findElement(By.xpath(
				"/html/body/app-root/app-home/div[2]/div/div[2]/app-select-plan/div/div[5]/div[1]/app-plan-selection/div/img"))
				.click();
		driver.findElement(By.xpath("/html/body/app-root/app-home/div[2]/div/div[4]/div[3]/button")).click();

		// click I Agree button
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("/html/body/app-root/app-home/ngb-modal-window/div/div/div/div[2]/div[2]/div[3]/button")))
				.click();

		// STEP 3 - FILL UP FORM
		try {
			WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
			firstName.sendKeys("MAI");

			WebElement middleName = driver.findElement(By.xpath("//*[@id='middleName']"));
			middleName.sendKeys("M NAME");

			WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
			lastName.sendKeys("DG");

			WebElement MofirstName = driver.findElement(By.xpath("//*[@id='mothersFirstName']"));
			MofirstName.sendKeys("MOTHER FIRST");

			WebElement MomiddleName = driver.findElement(By.xpath("//*[@id='mothersMaidenMiddleName']"));
			MomiddleName.sendKeys("MOTHER MIDDLE");

			WebElement MolastName = driver.findElement(By.xpath("//*[@id='mothersMaidenLastName']"));
			MolastName.sendKeys("MOTHER LAST");
		} catch (Exception e) {
			System.out.println("Error Occured");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// Date picker
		WebElement BDate = driver.findElement(By.xpath(
				"/html/body/app-root/app-home/div[2]/div/div[2]/app-customer-info/div/form/div[3]/div[1]/div/span/button"));
		BDate.click();

		WebElement BMonth = driver.findElement(By.xpath(
				"/html/body/app-root/app-home/div[2]/div/div[2]/app-customer-info/div/form/div[3]/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]"));
		Select sMonth = new Select(BMonth);
		sMonth.selectByIndex(4);

		WebElement BYear = driver.findElement(By.xpath(
				"/html/body/app-root/app-home/div[2]/div/div[2]/app-customer-info/div/form/div[3]/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[2]"));
		Select sYear = new Select(BYear);
		sYear.selectByIndex(28);

		WebElement BDay = driver.findElement(By.xpath(
				"/html/body/app-root/app-home/div[2]/div/div[2]/app-customer-info/div/form/div[3]/div[1]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div[4]/div[4]/div"));
		BDay.click();
		// Select sDay = new Select (BDay);
		// sDay.selectByIndex(28);

		WebElement gender = driver.findElement(By.xpath("//*[@id='gender']"));
		Select sGender = new Select(gender);
		sGender.selectByIndex(1);

		WebElement citizen = driver.findElement(By.xpath("//*[@id='citizenship']"));
		Select sCitizen = new Select(citizen);
		sCitizen.selectByIndex(28);

		WebElement emailadd = driver.findElement(By.xpath("//*[@id='emailAddress']"));
		emailadd.sendKeys("maideguzman@yopmail.com");

		WebElement mobileNum = driver.findElement(By.xpath("//*[@id='mobileNumber']"));
		mobileNum.sendKeys("09175863465");

		WebElement altmobileNum = driver.findElement(By.xpath("//*[@id=\'altContactNumber\']"));
		altmobileNum.sendKeys("09123456789");

		// click next button
		driver.findElement(By.xpath("/html/body/app-root/app-home/div[2]/div/div[4]/div[3]/button")).click();

		// STEP 4 - UPLOAD DOCUMENT
		driver.findElement(By.id("validIdFront")).sendKeys("/Users/micadeguzman/Documents/Screenshots/_UploadIDs.png");
		driver.findElement(By.id("validIdBack")).sendKeys("/Users/micadeguzman/Documents/Screenshots/_UploadIDs.png");

		// click next button
		driver.findElement(By.xpath("/html/body/app-root/app-home/div[2]/div/div[4]/div[3]/button")).click();

		// STEP 5 - COMPLETE APPLICATION
		// click I agree checkboxes
		driver.findElement(By.xpath("//*[@id='tcChk']")).click();
		driver.findElement(By.xpath("//*[@id='dpLink']")).click();

		// click submit button
		driver.findElement(By.xpath("/html/body/app-root/app-home/div[2]/div/div[4]/div[3]/button")).click();
	}

}
