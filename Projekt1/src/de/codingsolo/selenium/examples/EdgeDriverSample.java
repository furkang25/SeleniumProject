package de.codingsolo.selenium.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverSample {
    public static void main(String[] args) throws Exception {
        // Setze den Pfad zum Edge WebDriver
        System.setProperty("webdriver.edge.driver", "/Users/furo/Documents/GitHub/SeleniumProject/Projekt1/drivers/msedgedriver");

        // Initialisiere den EdgeDriver
        EdgeDriver driver = new EdgeDriver();

        try {
            driver.navigate().to("https://bing.com");

            WebElement element = driver.findElement(By.id("sb_form_q"));
            element.sendKeys("WebDriver");
            element.submit();

            Thread.sleep(5000);
        } finally {
            driver.quit();
        }
    }
}

