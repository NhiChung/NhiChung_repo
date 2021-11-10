package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import com.NhiChung.Selenium.core.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *This is a google translate page class representation
 */
public class GoogleTranslatePage extends BaseGooglePage{
    private WebElement googleTranslateField = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"tw-source-text-ta\"]"));
    private WebElement googleTranslateResult = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"kAz1tf\"]"));

    /**
     * method get translate result
     *
     * @param text string variable representing the text we will input into the translate field
     * @return String
     */
    public String getTranslateResult(String text) {
        googleTranslateField.sendKeys(text);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyLogger.LOGGER.info(String.format("Set %s to the Translate field", text));
        return googleTranslateResult.getText();
    }

}