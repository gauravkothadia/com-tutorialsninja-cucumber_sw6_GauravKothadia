Feature: Laptops and Notebooks
  As a user
  I want to check functionality of laptop and notebook page

  Background:
    Given I am on Home page

  @sanity @smoke @regression
  Scenario: User should arrange product in price high to low order successfully
    When I mouse hover on "Laptops & Notebooks" Tab and click
    And I call selectMenu method and pass the menu "Show AllLaptops & Notebooks"
    And I select Sort By position to "Price (High > Low)"
    Then Verify the Product will arrange in Descending order.

  @sanity @regression
  Scenario: User should place order successfully
    When I mouse hover and click on currency dropdown
    And I mouse hover and click on  £ Pound Sterling
    When I mouse hover on "Laptops & Notebooks" Tab and click
    And I call selectMenu method and pass the menu "Show AllLaptops & Notebooks"
    And I select Sort By position to "Price (High > Low)"
    And I select product "HP LP3065"
    And I should see product text "HP LP3065"
    And I click on add to cart button
    And I should see the message "Success: You have added HP LP3065 to your shopping cart!"
    And I click on shopping cart link into success message
    Then I should see the "Shopping Cart" text
    And I should see the product name "HP LP3065"
    And I change quantity "2" for product
    And I click on update quantity
    And I should see the message "Success: You have modified your shopping cart!"
    And I should see the total "£149.45"
    And I click on checkout button
    And I should navigate to checkout page
    And I should see "New Customer" text
    And I click on guest checkout button
    And I click on continue button of guest checkout page
    And I filled all mandatory field of checkout page
    And I click on continue after fill all detail on checkout page
    And I add comments to text area about product order "product info comment"
    And I click on continue of checkout
    And I click checkbox of terms and condition
    Then I should be able to confirm the order by clicking on confirm order button