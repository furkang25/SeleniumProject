import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestDragDropSeleniumKursFireFox {
	
    // WebDriver-Instanz
    WebDriver driver;

    // Diese Methode wird vor jedem Test ausgeführt
    @Before
    public void setUp() throws Exception {
        // Ausgabe zur Konsole, um den Start der Initialisierung zu markieren
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

    // Diese Methode wird nach jedem Test ausgeführt
    @After
    public void tearDown() throws Exception {
        // Ausgabe zur Konsole, um das Ende des Tests zu markieren
        System.out.println("Test abgeschlossen");
        
        // Schließt den Browser
        // driver.close();
    }

    // Testmethode für Login und Drag-and-Drop-Funktionalität
    @Test
    public void testLogin() {
        System.out.println("Starte Test Login mit Fehlschlag");

        // Vorbereitung: Bereite die Testumgebung vor (Schritte für den Login-Prozess)
        
        // Benutzername eingeben
        driver.findElement(By.cssSelector("input.form-control[type='text']")).sendKeys("selenium101");
        
        // Passwort eingeben
        driver.findElement(By.cssSelector("input.form-control[type='password']")).sendKeys("codingsolo");
        
        // Login-Button klicken
        driver.findElement(By.cssSelector("input.btn-primary")).click();
        
        // Navigation zum Formular für das Drag-and-Drop-Beispiel
        driver.findElement(By.id("portaltab-burger-menu")).click();
        driver.findElement(By.linkText("Selenium Testapplikationen")).click();
        driver.findElement(By.linkText("Drag and Drop Beispiel")).click();

        // Beginne mit den Drag-and-Drop-Operationen
        
        // Finde die ziehbaren Elemente anhand ihrer IDs
        WebElement drgLogoNormal = driver.findElement(By.id("white-logo"));
        WebElement drgLogoBlue = driver.findElement(By.id("blue-logo"));
        WebElement drgLogoRed = driver.findElement(By.id("red-logo"));
        WebElement drgLogoGreen = driver.findElement(By.id("green-logo"));
        
        // Finde das Ziel-Element anhand seiner ID
        WebElement drpBox = driver.findElement(By.id("droppable"));
        
        // Initialisiere die Actions-Klasse für komplexe Benutzerinteraktionen
        Actions action = new Actions(driver);
        
        // Handlung: Führe die Drag-and-Drop-Operationen aus

        // Ziehe das weiße Logo in die Drop-Box
        action.dragAndDrop(drgLogoNormal, drpBox).build().perform();
        
        // Ziehe das blaue Logo in die Drop-Box
        action.dragAndDrop(drgLogoBlue, drpBox).build().perform();
        
        // Ziehe das rote Logo und lasse es um 250 Pixel nach rechts fallen
        action.dragAndDropBy(drgLogoRed, 250, 0).build().perform();
        
        // Klicke und halte das grüne Logo, bewege es um 250 Pixel nach rechts und lasse es los
        action.clickAndHold(drgLogoGreen).perform();
        action.moveByOffset(250, 0).perform();
        action.release(drgLogoGreen).perform();
        
        // Alternativ kann die gleiche Operation in einer einzigen Aktionskette ausgeführt werden
        // action.clickAndHold(drgLogoGreen).moveByOffset(250, 0).release(drgLogoGreen).perform();
        
        // Überprüfung: Stelle sicher, dass die Erfolgsmeldung den Text "green-logo" enthält
        String erfolgsMeldung = driver.findElement(By.cssSelector("#droppable > p")).getText();
        assertTrue(erfolgsMeldung.contains("green-logo"));
    }
}
