Feature: Sign Up Features


  @temp
  Scenario Outline: Verify valid email addresses for sign up

    Given I am on the homepage
    When I click on Sign in
    And I enter the valid email address "<Email>"
    Then I should be able to land on registration page

    Examples:
      | Email                       |
      | smebius0@360.cn             |
      | jhendrichs1@accuweather.com |
      | sflatt2@unesco.org          |
      | deliesco3@utexas.edu        |
      | kwithringten4@google.es     |
