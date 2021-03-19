package common;

import org.openqa.selenium.firefox.FirefoxDriver;

public class launchBrowser {

	public void launchFirefox() {
		//setting up firefox using firefox driver by setting its property
		System.setProperty("webdriver.gecko.driver", "/Users/micadeguzman/Documents/_Automation/Selenium/browserDrivers/geckodriver");
		//opening browser
		FirefoxDriver driver = new FirefoxDriver();
		//opening window tab in maximize mode
		driver.manage().window().maximize();
		//opening application
		driver.get("https://shopee.ph/");

	}

}
