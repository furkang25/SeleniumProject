package de.codingsolo.selenium.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestfallIE {

	public static void main(String[] args) {
		System.out.println("Test Beginnt");
		
		System.setProperty("webdriver.ie.driver", 
				"./drivers/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		
		driver.get("https://codingsolo.de");
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
	}

}
