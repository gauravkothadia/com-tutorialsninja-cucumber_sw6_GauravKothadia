package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Utility {

    private static final Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustHeading;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestRadio;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement checkoutOptContButton;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement fNameField;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lNameField;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement mobileField;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address1Field;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityField;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postcodeField;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryField;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement stateField;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement billingDetailsContButton;

    @CacheLookup
    @FindBy(id = "button-shipping-method")
    WebElement delMethodContButton;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeTermsCheckbox;

    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement paymentMethodContButton;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement commentArea;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-confirm']")
    WebElement confirmOrderButton;

    public String getNewCustHeading() {
        log.info("Get " + newCustHeading.toString());
        return getTextFromElement(newCustHeading);
    }

    public void clickOnGuestRadio() {
        clickOnElement(guestRadio);
        log.info("click on " + guestRadio.toString());
    }

    public void clickOnCheckoutOptContButton() {
        clickOnElement(checkoutOptContButton);
        log.info("click on " + checkoutOptContButton.toString());
    }

    public void fillBillingFormDetails(String fName, String lName, String email, String mobile
            , String add1, String city, String postCode, String country, String state) {
        sendTextToElement(fNameField, fName);
        log.info("Entering First name as "+fName);
        sendTextToElement(lNameField, lName);
        log.info("Entering last name as "+lName);
        sendTextToElement(emailField, email);
        log.info("Entering email address as "+email);
        sendTextToElement(mobileField, mobile);
        log.info("Entering the mobile number as "+mobile);
        sendTextToElement(address1Field, add1);
        log.info("Entering the address as "+add1);
        sendTextToElement(cityField, city);
        log.info("Entering the city as "+city);
        sendTextToElement(postcodeField, postCode);
        log.info("Entering the post code as "+postCode);
        selectByVisibleTextFromDropDown(countryField, country);
        log.info("Selecting country as "+country);
        selectByVisibleTextFromDropDown(stateField, state);
        log.info("Selecting state as "+state);
        clickOnElement(billingDetailsContButton);
        log.info("Clicking on the billing details continue button");
    }

    public void clickOnDelMethodContButton() {
        clickOnElement(delMethodContButton);
        log.info("click on " + delMethodContButton.toString());
    }

    public void clickOnAgreeTermsCheckbox() {
        clickOnElement(agreeTermsCheckbox);
        log.info("click on " + agreeTermsCheckbox.toString());
    }

    public void clickOnPaymentMethodCont() {
        clickOnElement(paymentMethodContButton);
        log.info("click on " + paymentMethodContButton.toString());
    }

    public String verifyNavigationToCheckOutPage(){
        log.info("Getting current URL to check successful navigation to Checkout page");
        return gettingCurrentURL();
    }

    public void setCommentArea(String str){
        sendTextToElement(commentArea,str);
        log.info("typing in comments area: "+str);
    }

    public void clickOnConfirmOrderButton(){
        clickOnElement(confirmOrderButton);
    }
}
