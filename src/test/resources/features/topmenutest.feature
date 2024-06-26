Feature: Top Menu Test Function

  Background:
    Given I am on Home page

  @sanity @smoke @regression
  Scenario: verify User Should Navigate To Desktops Page Successfully
    When I mouse hover on "Desktops" Tab and click
    And I call selectMenu method and pass the menu "Show AllDesktops"
    Then I should be able to verify the text "Desktops"

  @sanity @regression
  Scenario: verify User Should Navigate To LaptopsAndNotebooks Page Successfully
    When I mouse hover on "Laptops & Notebooks" Tab and click
    And I call selectMenu method and pass the menu "Show AllLaptops & Notebooks"
    Then I should be able to verify the text "Laptops & Notebooks"

  @regression
  Scenario: verify User Should Navigate To Components Page Successfully
    When I mouse hover on "Components" Tab and click
    And I call selectMenu method and pass the menu "Show AllComponents"
    Then I should be able to verify the text "Components"
