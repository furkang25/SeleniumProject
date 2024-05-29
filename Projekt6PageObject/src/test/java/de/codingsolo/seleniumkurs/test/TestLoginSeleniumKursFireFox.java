package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;

public class TestLoginSeleniumKursFireFox {

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

    // Testmethode für den Login
    @Test
    public void testLogin() {
        System.out.println("Starte Test Login mit Fehlschlag");
        
        // Arrange: Vorbereitung des Testumfelds
        
        // Erstelle eine Instanz der Login-Seite
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        
        // Gib die Zugangsdaten ein
        loginPage.zugangsdatenEingeben("selenium101", "codingsolo");

        // Act: Führe die Aktion (Login-Button klicken) aus
        loginPage.loginButtonAnklicken();

        // Assert: Überprüfe, ob die Erfolgsmeldung den Text "Willkommen" enthält
        String erfolgsMeldung = loginPage.statusMeldungAuslesen();
        assertTrue(erfolgsMeldung.contains("Willkommen"));
    }
}
