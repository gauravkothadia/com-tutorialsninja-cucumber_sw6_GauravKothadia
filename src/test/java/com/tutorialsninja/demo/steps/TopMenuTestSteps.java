package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.TopMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TopMenuTestSteps {
    @When("I mouse hover on {string} Tab and click")
    public void iMouseHoverOnTabAndClick(String topMenuLink) {
        new TopMenuPage().topMenu(topMenuLink);
    }

    @And("I call selectMenu method and pass the menu {string}")
    public void iCallSelectMenuMethodAndPassTheMenu(String showAllLink) {
        new TopMenuPage().selectMenu(showAllLink);
    }

    @Then("I should be able to verify the text {string}")
    public void iShouldBeAbleToVerifyTheText(String pageHeading) {
        Assert.assertEquals(new TopMenuPage().getPageHeadingText(),pageHeading);
    }

    @Given("I am on Home page")
    public void iAmOnHomePage() {

    }
}
