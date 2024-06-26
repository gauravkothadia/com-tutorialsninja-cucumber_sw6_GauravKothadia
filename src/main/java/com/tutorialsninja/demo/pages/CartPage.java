package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Utility {

    private static final Logger log = LogManager.getLogger(CartPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartHeading;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[@class='text-left'][2]")
    WebElement modelName;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]")
    WebElement totalPrice;

    @CacheLookup
    @FindBy(xpath = "//input[@class='form-control']")
    WebElement qtyTextBox;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement updateQtyButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successCartUpdateMsg;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOutButton;

    public String getShoppingCartHeading() {
        log.info("Get " + shoppingCartHeading.toString());
        return getTextFromElement(shoppingCartHeading);
    }

    public String getProductName() {
        log.info("Get " + productName.toString());
        return getTextFromElement(productName);
    }

    public String getModelName() {
        log.info("Get " + modelName.toString());
        return getTextFromElement(modelName);
    }

    public String getTotalPrice() {
        log.info("Get " + totalPrice.toString());
        //WebElement toRightOf = driver.findElement(RelativeLocator.with(By.xpath("//td[@class='text-right']")).toRightOf(By.xpath("//strong[normalize-space()='Total:']")));

        return "";
        //getTextFromElement(toRightOf);
    }

    public void sendQty(String qty) {
        log.info("click " + qtyTextBox.toString());
        qtyTextBox.clear();
        sendTextToElement(qtyTextBox, qty);
    }

    public void clickOnUpdateQty() {
        clickOnElement(updateQtyButton);
        log.info("click " + qtyTextBox.toString());
    }

    public String getSuccessCartUpdateMsg() {
        log.info("get " + successCartUpdateMsg.toString());
        return getTextFromElement(successCartUpdateMsg);
    }

    public void clickOnCheckOut() {
        log.info("click on " + checkOutButton.toString());
        clickOnElement(checkOutButton);
    }
}
