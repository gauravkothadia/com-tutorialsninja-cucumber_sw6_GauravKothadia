package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    private static final Logger login = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement currencyLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu']//button[normalize-space()='£Pound Sterling']")
    WebElement poundLink;

    public void clickOnCurrency() {
        mouseHoverToElementAndClick(currencyLink);
        //clickOnElement(By.xpath("(//button[@class='currency-select btn btn-link btn-block'])[2]"));
        login.info("Click on " + currencyLink.toString());
    }

    public void selectPoundCurrency() {
        //clickOnElement(currencyLink);
        mouseHoverToElementAndClick(poundLink);
        login.info("Click on " + poundLink.toString());
    }

    public void selectMyAccountOptions(String option){
        clickOnElement(By.xpath("//a[normalize-space()='" + option + "']"));
        login.info("Selecting my account options as "+option);
    }
}
