package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;

public class TestLoginFehlschlagSeleniumKursFireFox {

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

    // Testmethode für den fehlschlagenden Login
    @Test
    public void testLogin() {
        System.out.println("Starte Test Login mit Fehlschlag");
        
        // Vorbereitung: Erstellen der Login-Seite
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        
        // Eingeben der ungültigen Zugangsdaten
        loginPage.zugangsdatenEingeben("Benutzer", "test");
        
        // Aktion: Klicken des Login-Buttons
        loginPage.loginButtonAnklicken();
        
        // Überprüfung: Sicherstellen, dass die Fehlermeldung den Text "Anmeldung fehlgeschlagen" enthält
        String fehlerMeldung = loginPage.statusMeldungAuslesen();
        assertTrue(fehlerMeldung.contains("Anmeldung fehlgeschlagen"));
    }
}
