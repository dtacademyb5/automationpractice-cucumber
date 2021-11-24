#@temp   tags can be also put on top of feature file, which runs the entire feature file
Feature: As a user I should be perform a product search


  Background:
    Given I am on the homepage


  @db
  Scenario: Product search on the homepage

    When I enter a product name on to the search and hit enter
    Then The results page should contain the search term

@smoke
  Scenario: Product search on the homepage with no value

    When I leave the search term empty and click search
    Then The results page should have the warning message

  @smoke @search
  Scenario: Product search on the homepage with invalid input

    When I pass invalid search term to the search bar and click

    Then The results page should not have any results with the warning message



    Scenario Outline: Verify searchBox with multiple valid inputs

      Given I am on the homepage
      When I search for "<Product>"
      Then The results page should also show "<Product>"

      Examples:
                    | Product |
                    | Blouse  |
                    | Dress  |
                    | Printed  |
                    | Summer  |
                    | Chiffon  |



