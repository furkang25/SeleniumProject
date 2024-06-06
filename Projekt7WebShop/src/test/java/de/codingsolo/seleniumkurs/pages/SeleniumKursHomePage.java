package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursHomePage {
	
	// WebDriver-Instanz
	WebDriver driver;
	
	// Statusmeldung
	@FindBy(css = "div.portalMessage:nth-child(1)")
	private WebElement statusMeldung;
	
	// Menü-Button
	@FindBy(id = "portaltab-burger-menu")
	private WebElement btnMenu;
	
	// Link im Seitenmenü zur Selenium Testapplikationen-Seite
	@FindBy(linkText = "Selenium Testapplikationen")
	private WebElement linkSideMenuSeleniumTestApp;

	// Konstruktor, um die WebDriver-Instanz zuzuweisen und die WebElemente zu initialisieren
	public SeleniumKursHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methode zum Auslesen der Statusmeldung
	public String statusMeldungAuslesen() {
		return statusMeldung.getText();
	}
	
	// Methode zum Ausklappen des Menüs
	public void menuAusklappen() {
		btnMenu.click();
	}
	
	// Methode zum Anklicken des Links zur Selenium Testapplikationen-Seite im Seitenmenü
	public void seleniumTestAppLinkAnklicken() {
		linkSideMenuSeleniumTestApp.click();
	}
}
