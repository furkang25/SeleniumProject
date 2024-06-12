package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Definiert eine Klasse für die Kasse-Seite im Webshop des Selenium Kurses
public class SeleniumKursWebShopKasse {

    private WebDriver driver;
    private WebDriverWait wait;

    // Definiert das WebElement für das Eingabefeld des Promo-Codes
    @FindBy(className = "promoCode")
    private WebElement inputPromoCode;

    // Definiert das WebElement für den Button zum Aktivieren des Promo-Codes
    @FindBy(className = "promoBtn")
    private WebElement btnPromoCodeAktivieren;

    // Definiert das WebElement für die Anzeige der Promo-Code-Information
    @FindBy(className = "promoInfo")
    private WebElement textPromoInfo;

    // Definiert das WebElement für die Anzeige des Preises
    @FindBy(className = "discountAmt")
    private WebElement textPreis;

    // Definiert das WebElement für den Bestellen-Button
    @FindBy(css = "div > button:last-child")
    private WebElement btnBestellen;

    // Konstruktor der Klasse, der den WebDriver initialisiert und die WebElemente mit PageFactory verbindet
    public SeleniumKursWebShopKasse(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5); // Wartezeit von 5 Sekunden wird gesetzt
        PageFactory.initElements(driver, this);
    }

    // Methode zum Eingeben eines Promo-Codes
    public void promoCodeEingeben(String code) {
        inputPromoCode.sendKeys(code);
    }

    // Methode zum Anklicken des Buttons zum Aktivieren des Promo-Codes
    public void promoCodeAktivierenAnklicken() {
        btnPromoCodeAktivieren.click();
    }

    // Methode zum Auslesen der Promo-Code-Information nach dem Aktivieren
    public String promoInfoAuslesen() {
        wait.until(ExpectedConditions.elementToBeClickable(textPromoInfo)); // Warten bis das Element klickbar ist
        return textPromoInfo.getText();
    }

    // Methode zum Auslesen des Preises
    public String preisAuslesen() {
        return textPreis.getText();
    }

    // Methode zum Anklicken des Bestellen-Buttons
    public void bestellungAnklicken() {
        btnBestellen.click();
    }
}
