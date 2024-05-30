package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumKursTestForm1Page {

    // WebDriver-Instanzvariable deklarieren
    private WebDriver driver;

    // WebElement für die Überschrift des Testformulars
    @FindBy(tagName = "h1")
    private WebElement testFormHeadline;

    // WebElement für das Betreff-Eingabefeld
    @FindBy(id = "form-widgets-betreff")
    private WebElement inputBetreff;

    // WebElement für das Name-Eingabefeld
    @FindBy(id = "form-widgets-name")
    private WebElement inputName;

    // WebElement für das Kurs-Auswahlfeld
    @FindBy(id = "form-widgets-auswahl1")
    private WebElement selectKurs;

    // WebElement für das Firmen-Auswahlfeld in Box 1
    @FindBy(id = "form-widgets-auswahl2-from")
    private WebElement selectFirmaBox1;

    // WebElement für den Button, um Firmen von Box 1 nach Box 2 zu übertragen
    @FindBy(id = "form2toButton")
    private WebElement btnAuswahlFirmaBox1;

    // WebElement für das Firmen-Auswahlfeld in Box 2
    @FindBy(id = "form-widgets-auswahl2-to")
    private WebElement selectFirmaBox2;

    // WebElement für den Button, um Firmen in Box 2 nach oben zu verschieben
    @FindBy(name = "upButton")
    private WebElement btnAuswahlObenBox2;

    // WebElement für den Button, um das Formular zu speichern
    @FindBy(name = "form.buttons.speichern")
    private WebElement btnSpeicherDokument;

    // WebElement für die Statusmeldung nach dem Speichern des Formulars
    @FindBy(id = "message")
    private WebElement statusMeldung;

    // WebElement für das erste Element in der Firmenliste
    @FindBy(xpath = "//ul[@id='companies']/li[1]")
    private WebElement textErstesElementListeFirma;
    
    // Konstruktor zur Initialisierung der Seite und der WebElemente
    public SeleniumKursTestForm1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methode zum Eingeben des Betreffs
    public void betreffEingeben(String betreff) {
        inputBetreff.sendKeys(betreff);
    }

    // Methode zum Eingeben des Namens
    public void nameEingeben(String name) {
        inputName.sendKeys(name);
    }

    // Methode zur Auswahl eines Kurses
    public void kursAuswaehlen(String kursName) {
        Select selectKursDropdown = new Select(this.selectKurs);
        selectKursDropdown.selectByVisibleText(kursName);
    }

    // Methode zur Auswahl von Firmen in Box 1
    public void firmaInBox1Auswaehlen(int[] auswahl) {
        Select selectFirmaDropdown = new Select(this.selectFirmaBox1);
        for (int i : auswahl) {
            selectFirmaDropdown.selectByIndex(i);
        }
    }

    // Methode zum Übernehmen der ausgewählten Firmen in Box 1 nach Box 2
    public void firmenUebernehmen() {
        btnAuswahlFirmaBox1.click();
    }

    // Methode zur Auswahl von Firmen in Box 2
    public void firmaInBox2Auswaehlen(int[] auswahl) {
        Select selectFirmaDropdown = new Select(this.selectFirmaBox2);
        for (int i : auswahl) {
            selectFirmaDropdown.selectByIndex(i);
        }
    }

    // Methode zum Verschieben der ausgewählten Firmen in Box 2 nach oben
    public void ausgewaehlteFirmenVerschieben() {
        btnAuswahlObenBox2.click();
    }

    // Methode zum Speichern des Formulars
    public void formularSpeichern() {
        btnSpeicherDokument.click();
    }

    // Methode zum Auslesen der Statusmeldung
    public String statusMeldungAuslesen() {
        return statusMeldung.getText();
    }

    // Methode zum Auslesen des Textes des ersten Elements in der Firmenliste
    public String erstesListenElementAuslesen() {
        return textErstesElementListeFirma.getText();
    }
}
