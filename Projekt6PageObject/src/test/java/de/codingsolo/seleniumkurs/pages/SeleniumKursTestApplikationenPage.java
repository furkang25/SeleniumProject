package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursTestApplikationenPage {
    
    // Deklaration einer WebDriver-Instanzvariable
    private WebDriver driver;

    // WebElement für den Menü-Button identifiziert durch seine ID
    @FindBy(id = "portaltab-burger-menu")
    private WebElement btnMenu;

    // WebElement für den Link zu "Selenium Test Form1" identifiziert durch seinen Linktext
    @FindBy(linkText = "Selenium Test Form1")
    private WebElement linkTestForm1;

    // Konstruktor zur Initialisierung der Seite und der WebElemente
    public SeleniumKursTestApplikationenPage(WebDriver driver) {
        // Weist die übergebene WebDriver-Instanz der Instanzvariable zu
        this.driver = driver;
        // Initialisiert die WebElemente dieser Seite mit Hilfe von PageFactory
        PageFactory.initElements(driver, this);
    }

    // Methode zum Klicken auf den Menü-Button
    public void menuAusklappen() {
        btnMenu.click();
    }

    // Methode zum Klicken auf den Link zu "Selenium Test Form1"
    public void testForm1anklicken() {
        linkTestForm1.click();
    }
}
