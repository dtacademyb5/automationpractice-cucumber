Feature: As a user I should be perform a product search



  Scenario: Product search on the homepage

    Given I am on the homepage
    When I enter a product name on to the search and hit enter
    Then The results page should contain the search term