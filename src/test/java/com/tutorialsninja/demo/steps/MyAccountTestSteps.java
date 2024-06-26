package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class MyAccountTestSteps {

    @And("I call the method selectMyAccountOptions method and pass the parameter {string}")
    public void iCallTheMethodSelectMyAccountOptionsMethodAndPassTheParameter(String tabName) {
        new HomePage().selectMyAccountOptions(tabName);
    }

    @And("I enter First Name {string}")
    public void iEnterFirstName(String firstName) {
        new MyAccountsPage().setFirstName(firstName);
    }

    @And("I enter Last Name {string}")
    public void iEnterLastName(String lastName) {
        new MyAccountsPage().setLastName(lastName);
    }

    @And("I enter Email {string}")
    public void iEnterEmail(String email) {
        new MyAccountsPage().setEmailField(email);
    }

    @And("I enter Telephone {string}")
    public void iEnterTelephone(String telephoneNumber) {
        new MyAccountsPage().setMobileField(telephoneNumber);
    }

    @And("I enter Password {string}")
    public void iEnterPassword(String password) {
        new MyAccountsPage().setPasswordField(password);
    }

    @And("I enter Confirm Password {string}")
    public void iEnterConfirmPassword(String confirmPassword) {
        new MyAccountsPage().setConfirmPasswordField(confirmPassword);
    }

    @And("I click on Privacy Policy check box")
    public void iClickOnPrivacyPolicyCheckBox() {
        new MyAccountsPage().clickOnAgreeCheckbox();
    }

    @And("I click on Continue button for registration")
    public void iClickOnContinueButtonForRegistration() {
        new MyAccountsPage().clickContinueButton();
    }

    @When("I click on {string} link")
    public void iClickOnLink(String menuLink) {
        new HomePage().selectMyAccountOptions(menuLink);
    }

    @Then("I should see text {string}")
    public void iShouldSeeText(String text) {
        if (text.equalsIgnoreCase("Register Account")) {
            Assert.assertEquals(new MyAccountsPage().getRegAccHeading(), text);
        } else if (text.equalsIgnoreCase("Returning Customer")) {
            Assert.assertEquals(new MyAccountsPage().getLoginHeading(), text);
        }
    }

    @Then("I should be see the message {string}")
    public void iShouldBeSeeTheMessage(String text) {
        Assert.assertEquals(new MyAccountsPage().getRegConfirmText(), text);
    }

    @And("I should see the text after logout as {string}")
    public void iShouldSeeTheTextAfterLogoutAs(String logoutSuccessText) {
        Assert.assertEquals(new MyAccountsPage().getLogoutConfirmMsg(), logoutSuccessText);
    }

    @And("I click on Continue button after registration")
    public void iClickOnContinueButtonAfterRegistration() {
        new MyAccountsPage().clickOnContAfterRegButton();
    }

    @And("I click on Continue button after logout")
    public void iClickOnContinueButtonAfterLogout() {
    }

    @And("I enter Email {string}, password {string} on login page and click on login button")
    public void iEnterEmailPasswordOnLoginPageAndClickOnLoginButton(String email, String pwd) {
        new MyAccountsPage().fillLoginData(email,pwd);
    }
}
