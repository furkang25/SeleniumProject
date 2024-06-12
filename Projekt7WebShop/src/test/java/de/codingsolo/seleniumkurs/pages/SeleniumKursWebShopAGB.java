package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// Definiert eine Klasse für die Webshop AGB Seite im Selenium Kurs
public class SeleniumKursWebShopAGB {

    private WebDriver driver;
    private WebDriverWait wait;

    // Definiert das WebElement für das Dropdown-Menü zur Länderauswahl
    @FindBy(css = "div > select")
    private WebElement selectLand;

    // Definiert das WebElement für das Kontrollkästchen zum Akzeptieren der AGB
    @FindBy(className = "chkAgree")
    private WebElement checkAGBAkzeptiert;

    // Definiert das WebElement für den Weiter-Button
    @FindBy(css = "div > button")
    private WebElement btnWeiter;

    // Konstruktor der Klasse, der den WebDriver initialisiert und die WebElemente mit PageFactory verbindet
    public SeleniumKursWebShopAGB(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5); // Wartezeit von 5 Sekunden wird gesetzt
        PageFactory.initElements(driver, this);
    }

    // Methode zur Auswahl eines Landes aus dem Dropdown-Menü
    public void landAuswaehlen(String land) {
        Select landAuswahl = new Select(selectLand);
        landAuswahl.selectByValue(land); // Wählt das Land basierend auf dem übergebenen Wert
    }

    // Methode zum Anklicken des Kontrollkästchens zum Akzeptieren der AGB
    public void aGBAkzeptiert() {
        checkAGBAkzeptiert.click();
    }

    // Methode zum Anklicken des Weiter-Buttons
    public void weiterAnklicken() {
        btnWeiter.click();
    }
}
