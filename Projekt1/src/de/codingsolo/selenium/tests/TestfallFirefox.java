package de.codingsolo.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestfallFirefox {

	public static void main(String[] args) {
		System.out.println("Test Beginnt");
		
		System.setProperty("webdriver.gecko.driver", 
				"./drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://codingsolo.de");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
