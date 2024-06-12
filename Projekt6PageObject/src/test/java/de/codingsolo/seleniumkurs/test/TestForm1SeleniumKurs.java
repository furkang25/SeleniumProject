package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestForm1Page;
import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;

public class TestForm1SeleniumKurs {

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

        // Initialisiere die Login-Seite und gebe die Zugangsdaten ein
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsdatenEingeben("selenium101", "codingsolo");
        loginPage.loginButtonAnklicken();

        // Initialisiere die Home-Seite und klappe das Menü aus
        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();

        // Klicke auf den Link zur Selenium Test Applikation
        homePage.linkSeleniumTestAppLinkAnklicken();

        // Initialisiere die Test Applikationen-Seite und klicke auf Test Form 1
        SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
        testAppPage.testForm1anklicken();

        // Initialisiere die Test Form 1-Seite
        SeleniumKursTestForm1Page testForm1Page = new SeleniumKursTestForm1Page(driver);
        testForm1Page.betreffEingeben("Automatischer Test");
        testForm1Page.nameEingeben("Dieter");

        testForm1Page.firmaInBox1Auswaehlen(new int [] {2,4,6});
        testForm1Page.firmenUebernehmen();
        
        SeleniumKursTestForm1Page testForm2Page = new SeleniumKursTestForm1Page(driver);

        testForm2Page.firmaInBox1Auswaehlen(new int [] {2});
        testForm1Page.ausgewaehlteFirmenVerschieben();

        testForm1Page.formularSpeichern();

        // Überprüfe, ob die Erfolgsmeldung und das erste Listenelement korrekt sind
        String erfolgsMeldung = testForm1Page.statusMeldungAuslesen();
        assertTrue(erfolgsMeldung.contains("Java Grundlagen Kurs"));

        String erstesElement = testForm1Page.erstesListenElementAuslesen();
        assertEquals(erstesElement, "Magazzini Alimentari Riuniti");
    }

}
