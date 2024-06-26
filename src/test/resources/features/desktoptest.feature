Feature: Desktop page functionality
  As a user I want to check desktop page and add product into cart

  Background:
    Given I am on Home page

  @smoke @sanity @regression
  Scenario: verify product arranged in alphabetical order
    When I mouse hover on "Desktops" Tab and click
    And I call selectMenu method and pass the menu "Show AllDesktops"
    And I select Sort By position to "Name (Z - A)"
    Then Verify the Product will arrange in Descending order.

  @sanity @regression @current
  Scenario Outline:User should be able to add product to cart successfully
    When I mouse hover and click on currency dropdown
    And I mouse hover and click on  £ Pound Sterling
    And I mouse hover on "Desktops" Tab and click
    And I call selectMenu method and pass the menu "Show AllDesktops"
    And I select Sort By position to "Name (Z - A)"
    And I select product "<product>"
    And I should see product text "<product>"
    And I select qty "1"
    And I click on add to cart button
    And I should see the message "Success: You have added <product> to your shopping cart!"
    And I click on shopping cart link into success message
    Then I should see the "Shopping Cart" text
    And I should see the product name "<product>"
    And I should see the model "<model>"
    And I should see the total "<price>"
    Examples:
      | product      | model      | price   |
      | HTC Touch HD | Product 1  | £74.73  |
      | iPhone       | product 11 | £75.46  |
      | iPod Classic | product 20 | £74.73  |
      | MacBook      | Product 16 | £368.73 |
      | MacBook Air  | Product 17 | £736.23 |
      | Sony VAIO    | Product 19 | £736.23 |