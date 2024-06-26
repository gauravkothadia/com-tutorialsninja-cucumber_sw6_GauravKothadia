package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends Utility {

    private static final Logger log = LogManager.getLogger(MyAccountsPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement regAccHeading;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement loginHeading;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement fNameField;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lNameField;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement mobileField;


    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeCheckbox;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement regConfirmMsg;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement contAfterRegButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement logoutConfirmMsg;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement afterLoginHeading;

    public String getLoginHeading() {
        log.info("Get " + loginHeading.toString());
        return getTextFromElement(loginHeading);
    }

    public String getRegAccHeading() {
        log.info("Get " + regAccHeading.toString());
        return getTextFromElement(regAccHeading);
    }

    static String randomStorer;

    public void fillRegistrationData(String fName, String lName, String email, String mobile
            , String pwd, String cpwd) {
        randomStorer = getRandomString(4);
        sendTextToElement(fNameField, fName);
        log.info("Entering first name as " + fName);
        sendTextToElement(lNameField, lName);
        log.info("Entering last name as " + lName);
        sendTextToElement(emailField, randomStorer + email);
        log.info("Entering the email address as " + randomStorer + email);
        sendTextToElement(mobileField, mobile);
        log.info("Entering the mobile number as " + mobile);
        sendTextToElement(passwordField, pwd);
        log.info("Entering the password as " + pwd);
        sendTextToElement(confirmPasswordField, cpwd);
        log.info("Entering the password in confirm password as " + cpwd);
        clickOnElement(agreeCheckbox);
        log.info("Selecting the checkbox");
        clickOnElement(continueButton);
        log.info("Clicking on the continue button");
    }

    public void setFirstName(String fName) {
        sendTextToElement(fNameField, fName);
        log.info("Entering first name as " + fName);
    }

    public void setLastName(String lName) {
        sendTextToElement(lNameField, lName);
        log.info("Entering last name as " + lName);
    }

    public void setEmailField(String email) {
        randomStorer = getRandomString(4);
        sendTextToElement(emailField, randomStorer + email);
        log.info("Entering the email address as " + randomStorer + email);
    }

    public void setMobileField(String mobile) {
        sendTextToElement(mobileField, mobile);
        log.info("Entering the mobile number as " + mobile);
    }

    public void setPasswordField(String pwd) {
        sendTextToElement(passwordField, pwd);
        log.info("Entering the password as " + pwd);
    }

    public void setConfirmPasswordField(String cpwd) {
        sendTextToElement(confirmPasswordField, cpwd);
        log.info("Entering the password in confirm password as " + cpwd);
    }

    public void clickOnAgreeCheckbox() {
        clickOnElement(agreeCheckbox);
        log.info("Selecting the checkbox");
    }

    public void clickContinueButton() {
        clickOnElement(continueButton);
        log.info("Clicking on the continue button");
    }

    public void fillLoginData(String email, String pwd) {
        sendTextToElement(emailField, randomStorer + email);
        log.info("Entering the email as " + randomStorer + email);
        sendTextToElement(passwordField, pwd);
        log.info("Entering the password as " + pwd);
        clickOnElement(loginButton);
        log.info("Clicking on login button");
    }

    public String getRegConfirmText() {
        log.info("Get " + regConfirmMsg.toString());
        return getTextFromElement(regConfirmMsg);
    }

    public void clickOnContAfterRegButton() {
        clickOnElement(contAfterRegButton);
        log.info("Get " + contAfterRegButton.toString());
    }

    public String getLogoutConfirmMsg() {
        log.info("Get " + logoutConfirmMsg.toString());
        return getTextFromElement(logoutConfirmMsg);
    }

    public String getAfterLoginHeading() {
        log.info("Get " + afterLoginHeading.toString());
        return getTextFromElement(afterLoginHeading);
    }
}
