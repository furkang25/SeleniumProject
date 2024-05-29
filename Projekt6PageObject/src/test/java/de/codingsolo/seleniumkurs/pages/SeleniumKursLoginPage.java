package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursLoginPage {

    // WebDriver-Instanz
    private WebDriver driver;

    // Eingabefeld Benutzername
    private By inputBenutzername = By.cssSelector("input.form-control[type='text']");
    // Eingabefeld Passwort
    private By inputPasswort = By.cssSelector("input.form-control[type='password']");
    // Button für die Anmeldung
    private By btnAnmeldung = By.cssSelector("input.btn-primary");
    // Statusmeldung
    private By statusMeldung = By.cssSelector("div.portalMessage:nth-child(1)");

    // Konstruktor für die Initialisierung der Seite
    public SeleniumKursLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methode zum Eingeben der Zugangsdaten
    public void zugangsdatenEingeben(String benutzername, String passwort) {
        this.driver.findElement(inputBenutzername).sendKeys(benutzername);
        this.driver.findElement(inputPasswort).sendKeys(passwort);
    }

    // Methode zum Klicken des Login-Buttons
    public void loginButtonAnklicken() {
        this.driver.findElement(btnAnmeldung).click();
    }

    // Methode zum Auslesen der Statusmeldung
    public String statusMeldungAuslesen() {
        return this.driver.findElement(statusMeldung).getText();
    }
}
