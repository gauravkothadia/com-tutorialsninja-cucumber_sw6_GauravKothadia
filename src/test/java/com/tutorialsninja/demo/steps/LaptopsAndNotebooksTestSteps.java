package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.CartPage;
import com.tutorialsninja.demo.pages.CheckoutPage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LaptopsAndNotebooksTestSteps {
    @And("I change quantity {string} for product")
    public void iChangeQuantityForProduct(String changeQty) {
        new CartPage().sendQty(changeQty);
    }

    @And("I click on update quantity")
    public void iClickOnUpdateQuantity() {
        new CartPage().clickOnUpdateQty();
    }

    @And("I click on checkout button")
    public void iClickOnCheckoutButton() {
        new CartPage().clickOnCheckOut();
    }

    @And("I should navigate to checkout page")
    public void iShouldNavigateToCheckoutPage() {
        Assert.assertTrue(new CheckoutPage().verifyNavigationToCheckOutPage().contains("checkout"));
    }

    @And("I should see {string} text")
    public void iShouldSeeText(String newCustomerText) {
        Assert.assertEquals(new CheckoutPage().getNewCustHeading(),newCustomerText);
    }

    @And("I click on guest checkout button")
    public void iClickOnGuestCheckoutButton() {
        new CheckoutPage().clickOnGuestRadio();
    }

    @And("I click on continue button of guest checkout page")
    public void iClickOnContinueButtonOfGuestCheckoutPage() {
        new CheckoutPage().clickOnCheckoutOptContButton();
    }

    @And("I filled all mandatory field of checkout page")
    public void iFilledAllMandatoryFieldOfCheckoutPage() {
        new CheckoutPage().fillBillingFormDetails("Prime", "Testing", "p123@gmail.com", "07833662976"
                , "44, Region street", "London", "B44JUH", "United Kingdom", "Kent");
    }

    @And("I click on continue after fill all detail on checkout page")
    public void iClickOnContinueAfterFillAllDetailOnCheckoutPage() {
        new CheckoutPage().clickOnDelMethodContButton();
    }

    @And("I add comments to text area about product order {string}")
    public void iAddCommentsToTextAreaAboutProductOrder(String comments) {
        new CheckoutPage().setCommentArea(comments);
    }

    @And("I click checkbox of terms and condition")
    public void iClickCheckboxOfTermsAndCondition() {
        new CheckoutPage().clickOnAgreeTermsCheckbox();
    }

    @And("I click on continue of checkout")
    public void iClickOnContinueOfCheckout() {
        new CheckoutPage().clickOnPaymentMethodCont();
    }

    @Then("I should be able to confirm the order by clicking on confirm order button")
    public void iShouldBeAbleToConfirmTheOrderByClickingOnConfirmOrderButton() {
        new CheckoutPage().clickOnConfirmOrderButton();
    }
}
