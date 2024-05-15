package de.codingsolo.selenium.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestfallChrome {

	public static void main(String[] args) {
		System.out.println("Test Beginnt");
		
		System.setProperty("webdriver.chrome.driver", 
				"/Users/furo/Downloads/SeleniumProjekt1 2/drivers");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://codingsolo.de");
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
	}

}
