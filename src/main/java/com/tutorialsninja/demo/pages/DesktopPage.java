package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropdown;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantityTextBox;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successAlertMsg;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement cartLinkInMsg;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProductsAfterFilter;

    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement productNameHeading;

    public void selectFromSortByDropdown(String value) {
        selectByVisibleTextFromDropDown(sortByDropdown, value);
        log.info("Selecting the filter as "+value);
    }

    public List<String> getListOfProducts() {
        List<WebElement> beforeFilterProductNames = listOfProducts;
        //Create arraylist
        List<String> beforeFilterProductNamesList = new ArrayList<>();
        //Store elements text to array list
        for (WebElement p : beforeFilterProductNames) {
            beforeFilterProductNamesList.add(p.getText().toUpperCase());
        }
        //Sort arraylist to ascending oreder
        Collections.sort(beforeFilterProductNamesList);
        //Reverse the list
        Collections.reverse(beforeFilterProductNamesList);
        log.info("Getting list of products before filter");
        return beforeFilterProductNamesList;
    }

    public List<String> getListOfProductsAfterFilter() {
        //Store elements after filtering
        List<WebElement> afterFilterProductNames = listOfProductsAfterFilter;
        //Create anothor list to store text of elements after clicking on filter Z to A
        List<String> afterFilterProductNamesList = new ArrayList<>();
        for (WebElement s : afterFilterProductNames) {
            afterFilterProductNamesList.add(s.getText().toUpperCase());
        }
        log.info("Getting list of products after applying filter");
        return afterFilterProductNamesList;
    }

    public void clickOnProduct(String product) {
        List<WebElement> products = listOfProducts;
        List<String> productList = new ArrayList<>();
        for (WebElement e : products) {
            if (getTextFromElement(e).equalsIgnoreCase(product)) {
                clickOnElement(e);
                break;
            }
        }
        log.info("Click on " + product);
    }

    public void enterQuantity(String qty) {
        quantityTextBox.clear();
        sendTextToElement(quantityTextBox, qty);
        log.info("update quantity to " + qty);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        log.info("Click on " + addToCartButton.toString());
    }

    public String getSuccessAlertMsg() {
        log.info("Get " + successAlertMsg.toString());
        return getTextFromElement(successAlertMsg);
    }

    public void clickOnCartLinkInMsgButton() {
        clickOnElement(cartLinkInMsg);
        log.info("Click on " + cartLinkInMsg.toString());
    }

    public String getProductNameHeading(){
        String heading = getTextFromElement(productNameHeading);
        log.info("Getting the product name heading as "+heading);
        return heading;
    }
}
