Feature: Product related scenarios


  Scenario: Product details
    Given I am on the homepage
    When I click on a Blouse
    Then I should land on Blouse page and see its details


  Scenario: Product details with parametrization
    Given I am on the homepage
    When I click on a "Blouse"
    Then I should land on "Blouse" page and see its details



  Scenario: Product details with parametrization
    Given I am on the homepage
    When I click on a "Printed Dress"
    Then I should land on "Printed Dress" page and see its details


    Scenario: Parametrization example
      Given I have 5 "apples"
      When I add 2.5 on top
      Then I should have 7.5 "apples"


  Scenario: Parametrization example 2
    Given I have 10 "dollars"
    When I add 22.4 on top
    Then I should have 32.4 "dollars"


  Scenario: Docstring example
    Given I am on the homepage
    When I send the following text
    #the doctrings must be on the separate line
    """
    {
   "name" : "groupname",
   "type" : "GROUP",
   "description" : "Group Description",
   "active" : true
    }
    """







