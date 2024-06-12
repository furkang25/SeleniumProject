package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Definiert eine Klasse für die Selenium Kurs Test Applikationen Seite
public class SeleniumKursTestApplikationenPage {

    WebDriver driver;

    // Definiert das WebElement für den Menü-Button
    @FindBy(id = "portaltab-burger-menu")
    private WebElement btnMenu;

    // Definiert das WebElement für den Link zu Testform 1
    @FindBy(linkText = "Selenium Test Form1")
    private WebElement linkTestForm1;

    // Definiert das WebElement für den Link zum Drag and Drop Beispiel
    @FindBy(linkText = "Drag and Drop Beispiel")
    private WebElement linkDragDrop;

    // Definiert das WebElement für den Link zum IFrame Test
    @FindBy(linkText = "IFrame Beispiel")
    private WebElement linkIframeTest;

    // Definiert das WebElement für den Link zu Web Element Beispielen
    @FindBy(linkText = "Web Elemente")
    private WebElement linkWebElemente;

    // Definiert das WebElement für den Link zur Katzensuche Testseite (AJAX)
    @FindBy(linkText = "Katzensuche Testseite (AJAX)")
    private WebElement linkKatzenSuche;

    // Definiert das WebElement für den Link zur Webshop Testseite
    @FindBy(linkText = "Webshop Testseite")
    private WebElement linkWebshop;

    // Konstruktor der Klasse, der den WebDriver initialisiert und die WebElemente mit PageFactory verbindet
    public SeleniumKursTestApplikationenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methode zum Ausklappen des Menüs durch Klick auf den Menü-Button
    public void menuAusklappen() {
        btnMenu.click();
    }

    // Methode zum Anklicken des Links zu Testform 1
    public void testForm1anklicken() {
        linkTestForm1.click();
    }

    // Methode zum Anklicken des Links zum Drag and Drop Beispiel
    public void dragAndDropTestAnklicken() {
        linkDragDrop.click();
    }

    // Methode zum Anklicken des Links zum IFrame Test
    public void iframeTestAnklicken() {
        linkIframeTest.click();
    }

    // Methode zum Anklicken des Links zu Web Element Beispielen
    public void webElementeBeispielAnklicken() {
        linkWebElemente.click();
    }

    // Methode zum Anklicken des Links zur Katzensuche Testseite (AJAX)
    public void katzenSucheBeispielAnklicken() {
        linkKatzenSuche.click();
    }

    // Methode zum Anklicken des Links zur Webshop Testseite
    public void webShopAnklicken() {
        linkWebshop.click();
    }
}
