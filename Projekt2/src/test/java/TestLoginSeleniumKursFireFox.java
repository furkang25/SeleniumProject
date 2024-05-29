import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLoginSeleniumKursFireFox {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		// Setze den Pfad zum Edge WebDriver
        System.setProperty("webdriver.edge.driver", "/Users/furo/Documents/GitHub/SeleniumProject/Projekt1/drivers/msedgedriver");

        // Initialisiere den EdgeDriver
		driver = new EdgeDriver();
		Thread.sleep(5000);
		driver.get("https://seleniumkurs.codingsolo.de");
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
		
		driver.findElement(By.cssSelector("input.form-control[type='text']")).sendKeys("selenium101");
		driver.findElement(By.cssSelector("input.form-control[type='password']")).sendKeys("codingsolo");

		//Act
		
		driver.findElement(By.cssSelector("input.btn-primary")).click();

		//Assert
		
		String erfolgsMeldung = driver.findElement(By.cssSelector("div.portalMessage:nth-child(1)")).getText();
		assertTrue(erfolgsMeldung.contains("Willkommen"));
	}

}
