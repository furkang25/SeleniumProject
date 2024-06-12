package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

// Definiert eine Klasse für die Produktseite im Webshop des Selenium Kurses
public class SeleniumKursWebShopProdukte {

    private WebDriver driver;
    private WebDriverWait wait;

    // Definiert das WebElement für das Eingabefeld zur Produktsuche
    @FindBy(xpath = "//input[contains(@placeholder, 'Hier')]")
    private WebElement inputProduktSuche;

    // Definiert das WebElement für die Anzeige des Preises im Warenkorb
    @FindBy(xpath = "//tbody/tr[last()]//strong")
    private WebElement textPreis;

    // Definiert das WebElement für das Warenkorb-Icon
    @FindBy(css = ".cart-icon")
    private WebElement btnWarenKorb;

    // Definiert das WebElement für den Button zur Kasse
    @FindBy(css = "div.cart-preview > div.action-block > button")
    private WebElement btnZurKasse;

    // Konstruktor der Klasse, der den WebDriver initialisiert und die WebElemente mit PageFactory verbindet
    public SeleniumKursWebShopProdukte(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5); // Wartezeit von 5 Sekunden wird gesetzt
        PageFactory.initElements(driver, this);
    }

    // Methode zum Ausführen einer Produktsuche
    public void produktSucheAusfuehren(String name) {
        inputProduktSuche.sendKeys(name);
    }

    // Methode zum Auswählen der Anzahl eines Produkts
    public void produktAnzahlAuswaehlen(String name, int anzahl) {
        WebElement btnPlus = driver.findElement(By.xpath(String.format("//*[text() = '%s']/..//*[@class='increment']", name)));

        for (int i = 1; i < anzahl; i++) {
            btnPlus.click(); // Klickt so oft auf den Plus-Button, bis die gewünschte Anzahl erreicht ist
        }
    }

    // Methode zum Hinzufügen eines Produkts in den Warenkorb
    public void produktInWarenKorbLegen(String name) {
        driver.findElement(By.xpath(String.format("//*[text() = '%s']/..//button", name))).click();
    }

    // Methode zum Auslesen des Preises im Warenkorb
    public String preisAuslesen() {
        return textPreis.getText();
    }

    // Methode zum Anklicken des Warenkorb-Icons
    public void warenKorbAnklicken() {
        btnWarenKorb.click();
    }

    // Methode zum Anklicken des Buttons zur Kasse
    public void zurKasseAnklicken() {
        btnZurKasse.click();
    }
}
