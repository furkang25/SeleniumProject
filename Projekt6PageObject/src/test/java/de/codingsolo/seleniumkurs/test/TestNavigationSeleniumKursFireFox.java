// Importiere die notwendigen Klassen für die Unit-Tests und Selenium
package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursKatzebSuchenPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;

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
        driver.close();
    }

    // Der eigentliche Testfall für den Login und die Navigation
    @Test
    public void testLogin() {
        // Ausgabe zur Konsole, um den Start des Testfalls zu markieren
        System.out.println("Starte Test Login mit Fehlschlag");
        
        // Initialisiere die Login-Seite und gebe die Zugangsdaten ein
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsdatenEingeben("selenium101", "codingsolo");
        loginPage.loginButtonAnklicken();

        // Initialisiere die Home-Seite und klappe das Menü aus
        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();

        // Klicke auf den Link zur Selenium Test Applikation
        homePage.seleniumTestAppLinkAnkilcken();

        // Initialisiere die Test Applikationen-Seite und klicke auf Test Form 1
        SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
        testAppPage.testForm1anklicken();

        // Initialisiere die Test Form 1-Seite
        SeleniumKursTestForm1Page testForm1Page = new SeleniumKursTestForm1Page(driver);

        // Lese die Erfolgsmeldung aus und vergleiche sie mit der erwarteten Meldung
        String erfolgsMeldung = testForm1Page.erstesListenElementAuslesen();
        assertEquals(erfolgsMeldung, "Selenium Test Form1");
    }
}
