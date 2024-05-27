// Importiere die notwendigen Klassen für die Unit-Tests und Selenium
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestLoginSeleniumKursFireFox {
    
    // Deklariere eine Instanzvariable für den WebDriver
    WebDriver driver;

    // Die Methode wird vor jedem Test ausgeführt
    @Before
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");
        // Setze den Pfad zum Edge WebDriver
        System.setProperty("webdriver.edge.driver", "/Users/furo/Documents/GitHub/SeleniumProject/Projekt1/drivers/msedgedriver");

        // Initialisiere den EdgeDriver
        driver = new EdgeDriver();

        // Öffne die Webseite für den Selenium-Kurs
        driver.get("https://seleniumkurs.codingsolo.de");
        // Warte 5 Sekunden, um sicherzustellen, dass die Seite vollständig geladen ist
        Thread.sleep(5000);
    }

    // Die Methode wird nach jedem Test ausgeführt
    @After
    public void tearDown() throws Exception {
        System.out.println("Test abgeschlossen");
        // Schließt den Browser (der Code ist derzeit auskommentiert)
        // driver.close();
    }

    // Der eigentliche Testfall
    @Test
    public void testLogin() {
        System.out.println("Starte Test Login mit Fehlschlag");
        
        // Arrange: Fülle das Login-Formular aus
        driver.findElement(By.cssSelector("input.form-control[type='text']")).sendKeys("selenium101");
        driver.findElement(By.cssSelector("input.form-control[type='password']")).sendKeys("codingsolo");

        // Act: Klicke auf den Login-Button
        driver.findElement(By.cssSelector("input.btn-primary")).click();

        // Assert: Überprüfe, ob die Login-Nachricht den Text "Willkommen" enthält
        String erfolgsMeldung = driver.findElement(By.cssSelector("div.portalMessage:nth-child(1)")).getText();
        assertTrue(erfolgsMeldung.contains("Willkommen"));
    }
}
