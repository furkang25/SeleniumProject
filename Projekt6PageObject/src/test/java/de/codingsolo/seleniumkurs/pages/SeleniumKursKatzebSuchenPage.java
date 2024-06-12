package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumKursKatzebSuchenPage {

    WebDriver driver;

    @FindBy(css ="p.lead")
    private WebElement textParagraph;

    @FindBy(id ="-ssxkBCAy")
    private WebElement imgKatze1;

    @FindBy(id ="gnQoH9Yqb")
    private WebElement imgKatze2;

    @FindBy(linkText ="Next")
    private WebElement linkNext;

    @FindBy(linkText ="Previous")
    private WebElement linkPrevious;

    @FindBy(id ="anzahlSelect")
    private WebElement selectAnzahl;

    public SeleniumKursKatzebSuchenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String beschreibungAuslesen() {
        return textParagraph.getText();
    }

    public String srcLinkImgkatze1Auslesen() {
        return imgKatze1.getAttribute("src");
    }

    public String srcLinkImgkatze2Auslesen() {
        return imgKatze2.getAttribute("src");
    }

    public void nextPage() {
        linkNext.click();
    }

    public void previousPage() {
        linkPrevious.click();
    }

    public void anzahlBildereingeben(String anzahlWert) {
        Select anzahl = new Select(selectAnzahl);
        anzahl.selectByVisibleText(anzahlWert);
    }
}
