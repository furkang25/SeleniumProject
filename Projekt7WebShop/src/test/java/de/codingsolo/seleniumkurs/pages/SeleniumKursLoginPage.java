package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursLoginPage {
	
	// WebDriver-Instanz
	private WebDriver driver;

	// Eingabefeld für den Benutzernamen
	@FindBy(css = "input.form-control[type='text']")
	private WebElement inputBenutzername;
	
	// Eingabefeld für das Passwort
	@FindBy(css = "input.form-control[type='password']")
	private WebElement inputPasswort;
	
	// Button für die Anmeldung
	@FindBy(css = "input.btn-primary")
	private WebElement btnAnmeldung;
	
	// Statusmeldung nach der Anmeldung
	@FindBy(css = "div.portalMessage:nth-child(1)")
	private WebElement statusMeldung;
	
	// Konstruktor, um die WebDriver-Instanz zuzuweisen und die WebElemente zu initialisieren
	public SeleniumKursLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methode zum Eingeben der Zugangsdaten
	public void zugangsdatenEingeben(String benutzername, String passwort) {
		inputBenutzername.sendKeys(benutzername);
		inputPasswort.sendKeys(passwort);
	}
	
	// Methode zum Anklicken des Anmelde-Buttons
	public void loginButtonAnklicken() {
		btnAnmeldung.click();
	}
	
	// Methode zum Auslesen der Statusmeldung nach der Anmeldung
	public String statusMeldungAuslesen() {
		return statusMeldung.getText();
	}
}
