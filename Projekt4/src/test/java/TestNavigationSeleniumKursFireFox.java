// Importiere die notwendigen Klassen für die Unit-Tests und Selenium
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestNavigationSeleniumKursFireFox {
    
    // Deklariere eine Instanzvariable für den WebDriver
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

    // Der eigentliche Testfall für den Login und die Navigation
    @Test
    public void testLogin() {
        // Ausgabe zur Konsole, um den Start des Testfalls zu markieren
        System.out.println("Starte Test Login mit Fehlschlag");
        
        // Arrange: Fülle das Login-Formular aus
        // Finde das Textfeld für den Benutzernamen und gib "selenium101" ein
        driver.findElement(By.cssSelector("input.form-control[type='text']")).sendKeys("selenium101");
        // Finde das Textfeld für das Passwort und gib "codingsolo" ein
        driver.findElement(By.cssSelector("input.form-control[type='password']")).sendKeys("codingsolo");
        // Finde den Button mit der Klasse "btn-primary" und klicke darauf
        driver.findElement(By.cssSelector("input.btn-primary")).click();
        
        // Act: Navigiere durch die Seite
        // Öffne das Burger-Menü
        driver.findElement(By.id("portaltab-burger-menu")).click();
        // Klicke auf den Link "Selenium Testapplikationen"
        driver.findElement(By.linkText("Selenium Testapplikationen")).click();
        // Klicke auf den Link "Selenium Test Form1"
        driver.findElement(By.linkText("Selenium Test Form1")).click();
        
        // Starte das Formular
        // Finde das Textfeld für "Betreff" und gib "Automatischer Test" ein
        driver.findElement(By.id("form-widgets-betreff")).sendKeys("Automatischer Test");
        // Finde das Textfeld für "Name" und gib "Dieter" ein
        driver.findElement(By.id("form-widgets-name")).sendKeys("Dieter");
        
        // Arbeite mit Dropdown-Menüs
        // Wähle einen Kurs aus dem ersten Dropdown-Menü
        Select selectAuswahl1 = new Select(driver.findElement(By.id("form-widgets-auswahl1")));
        selectAuswahl1.selectByVisibleText("Java Grundlagen Kurs mit Dieter");
        
        // Wähle mehrere Elemente aus dem zweiten Dropdown-Menü aus
        Select selectAuswahl2 = new Select(driver.findElement(By.id("form-widgets-auswahl2-from")));
        selectAuswahl2.selectByIndex(2);
        selectAuswahl2.selectByIndex(4);
        selectAuswahl2.selectByIndex(6);
        
        // Bewege die ausgewählten Elemente zum Ziel-Dropdown
        driver.findElement(By.name("from2toButton")).click();
        
        // Wähle ein Element aus dem Ziel-Dropdown
        Select selecAuswahl3 = new Select(driver.findElement(By.id("form-widgets-auswahl2-to")));
        selecAuswahl3.selectByIndex(2);
        
        // Bewege das ausgewählte Element nach oben
        driver.findElement(By.name("upButton")).click();
        
        // Speichere das Formular
        driver.findElement(By.name("form.buttons.speichern")).click();

        // Assert: Überprüfe, ob die Erfolgsmeldung angezeigt wird
        String erfolgsMeldung = driver.findElement(By.id("message")).getText();
        assertTrue(erfolgsMeldung.contains("Java Grundlagen Kurs"));
        
        // Überprüfe, ob das erste Element der Liste korrekt ist
        String erstesElement = driver.findElement(By.xpath("//ul[@id='companies']/li[1]")).getText();
        assertEquals(erstesElement, "Magazzini Alimentari Riuniti");
    }
}
