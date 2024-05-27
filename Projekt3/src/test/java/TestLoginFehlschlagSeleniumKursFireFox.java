import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLoginFehlschlagSeleniumKursFireFox {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {

		System.out.println("Initialisiere Webdriver");
		// Setze den Pfad zum Edge WebDriver
        System.setProperty("webdriver.edge.driver", "/Users/furo/Documents/GitHub/SeleniumProject/Projekt1/drivers/msedgedriver");

        // Initialisiere den EdgeDriver
        driver = new EdgeDriver();

		driver.get("https://seleniumkurs.codingsolo.de");
		Thread.sleep(5000);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen");
		//driver.close();
	}

	@Test
	public void testLogin() {
		System.out.println("Starte Test Login mit Fehlschlag");
		
		//Arrange
		
		driver.findElement(By.id("__ac_name")).sendKeys("Benutzer");
		driver.findElement(By.name("__ac_password")).sendKeys("test");
		
		//Act
		
		driver.findElement(By.xpath("//input[@value='Anmelden']")).click();
		
		//Assert
		
		String fehlerMeldung = driver.findElement(By.cssSelector("div.portalMessage:nth-child(1)")).getText();
		assertTrue(fehlerMeldung.contains("Anmeldung fehlgeschlagen"));
	}

}
