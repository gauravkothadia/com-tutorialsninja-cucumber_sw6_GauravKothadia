package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.CartPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DesktopTestSteps {
    @And("I select Sort By position to {string}")
    public void iSelectSortByPositionTo(String sortingSelection) {
        new DesktopPage().selectFromSortByDropdown(sortingSelection);
    }

    @Then("Verify the Product will arrange in Descending order.")
    public void verifyTheProductWillArrangeInDescendingOrder() {
        Assert.assertEquals(new DesktopPage().getListOfProductsAfterFilter(), new DesktopPage().getListOfProducts());
    }

    @And("I mouse hover and click on  £ Pound Sterling")
    public void iMouseHoverAndClickOn£PoundSterling() {
        new HomePage().selectPoundCurrency();
    }

    @When("I mouse hover and click on currency dropdown")
    public void iMouseHoverAndClickOnCurrencyDropdown() {
        new HomePage().clickOnCurrency();
    }

    @And("I select product {string}")
    public void iSelectProduct(String productName) {
        new DesktopPage().clickOnProduct(productName);
    }

    @And("I should see product text {string}")
    public void iShouldSeeProductText(String productText) {
        Assert.assertEquals(new DesktopPage().getProductNameHeading(), productText);
    }

    @And("I select qty {string}")
    public void iSelectQty(String qty) {
        new DesktopPage().enterQuantity(qty);
    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        new DesktopPage().clickOnAddToCartButton();
    }

    @And("I click on shopping cart link into success message")
    public void iClickOnShoppingCartLinkIntoSuccessMessage() {
        new DesktopPage().clickOnCartLinkInMsgButton();
    }

    @And("I should see the product name {string}")
    public void iShouldSeeTheProductName(String productName) {
        Assert.assertEquals(new CartPage().getProductName(),productName);
    }

    @And("I should see the model {string}")
    public void iShouldSeeTheModel(String modelName) {
        Assert.assertEquals(new CartPage().getModelName(), modelName);
    }

    @And("I should see the total {string}")
    public void iShouldSeeTheTotal(String total) {
        Assert.assertEquals(new CartPage().getTotalPrice(),total);
    }

    @Then("I should see the {string} text")
    public void iShouldSeeTheText(String shoppingCartText) {
        Assert.assertEquals(new CartPage().getShoppingCartHeading(), shoppingCartText);
    }

    @And("I should see the message {string}")
    public void iShouldSeeTheMessage(String successMessage) {
        Assert.assertTrue(new DesktopPage().getSuccessAlertMsg().contains(successMessage));
    }
}
