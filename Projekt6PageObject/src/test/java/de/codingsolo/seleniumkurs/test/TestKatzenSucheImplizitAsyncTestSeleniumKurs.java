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
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;

public class TestKatzenSucheImplizitAsyncTestSeleniumKurs {

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

        // Setze eine implizite Wartezeit von 2 Sekunden
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Maximiere das Browserfenster
        driver.manage().window().maximize();

        // Öffne die Webseite für den Selenium-Kurs
        driver.get("https://seleniumkurs.codingsolo.de");
    }

    // Diese Methode wird nach jedem Test ausgeführt
    @After
    public void tearDown() throws Exception {
        // Ausgabe zur Konsole, um das Ende des Tests zu markieren
        System.out.println("Test abgeschlossen");
        
        // Schließt den Browser (auskommentiert für Debugging-Zwecke)
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
        homePage.seleniumTestAppLinkAnkilcken();

        // Initialisiere die Seite der Testapplikationen und klicke auf das Beispiel zur Katzensuche
        SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
        testAppPage.katzenSucheBeispielAnklicken();

        // Initialisiere die Katzensuche-Seite und lese die Beschreibung aus
        SeleniumKursKatzebSuchenPage katzenPage = new SeleniumKursKatzebSuchenPage(driver);
        String beschreibung = katzenPage.beschreibungAuslesen();
        String srcLinkKatzenBild1 = katzenPage.srcLinkImgKatze1Auslesen();

        // Navigiere zur nächsten Seite und gebe die Anzahl der Bilder ein
        katzenPage.nextPage();
        katzenPage.anzahlBildereingeben("6");
        String srcLinkKatzenBild2 = katzenPage.srcLinkImgKatze2Auslesen();

        // Überprüfe, ob die Links der Bilder die erwarteten Zeichenfolgen enthalten
        assertTrue(srcLinkKatzenBild1.contains("-ssxkBCAy"));
        assertTrue(srcLinkKatzenBild2.contains("gnQoH9Yqb"));
    }
}
