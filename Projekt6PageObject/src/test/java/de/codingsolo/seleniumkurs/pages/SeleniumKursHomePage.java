package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursHomePage {
    
    // Deklaration einer WebDriver-Instanzvariable
    private WebDriver driver;

    // WebElement für die Statusmeldung
    @FindBy(css = "div.portalMessage:nth-child(1)")
    private WebElement statusMeldung;

    // WebElement für den Menü-Button
    @FindBy(css = "button.menuButton")
    private WebElement btnMenun;

    // WebElement für den Seitenmenü-Link zur Selenium Test App
    @FindBy(css = "a.sideMenuSeleniumTestApp")
    private WebElement linkSideMenuSeleniumTestApp;

    // Konstruktor zur Initialisierung der Seite und der WebElemente
    public SeleniumKursHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methode zum Auslesen des Texts der Statusmeldung
    public String statusMeldungAuslesen() {
        return statusMeldung.getText();
    }

    // Methode zum Ausklappen des Menüs durch Klicken auf den Menü-Button
    public void menuAusklappen() {
        btnMenun.click();
    }

    // Methode zum Klicken auf den Link zur Selenium Test App im Seitenmenü
    public void linkSeleniumTestAppLinkAnklicken() {
        linkSideMenuSeleniumTestApp.click();
    }
}
