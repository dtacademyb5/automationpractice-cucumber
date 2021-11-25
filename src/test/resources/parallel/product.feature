@parallel
Feature: Product related scenarios


  Scenario: Product details
    Given I am on the homepage
    When I click on a Blouse
    Then I should land on Blouse page and see its details

  @regression
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




  Scenario Outline: Verify plus button with multiple data
    Given I am on the homepage
    When I click on a "Blouse"
    And I click on plus button <EnteredCount> times
    Then The value must become <ExpectedCount>

    Examples:
      | EnteredCount | ExpectedCount |
      | 5            | 6             |
      | 10           | 11            |
#      | 50           | 51            |
#      | 100          | 101           |
#      | 500          | 501           |
      | -1           | 1             |
      | -100         | 1             |





  @regression
  Scenario: Verify all product details
    Given I am on the homepage
    When I click on a "Blouse"
    Then The product details should be
      | Product | Model  | Price | Quantity | Condition |
      | Blouse  | demo_2 | 27.00 | 1        | New       |



  Scenario Outline: Verify all product details for different products
    Given I am on the homepage
    When I click on a "<product>"
    Then The product details should be
      | Product   | Model   | Price   | Quantity   | Condition   |
      | <product> | <model> | <price> | <quantity> | <condition> |


    Examples:
      | product                     | model  | price | quantity | condition |
      | Blouse                      | demo_2 | 27.00 | 1        | New       |
      | Faded Short Sleeve T-shirts | demo_1 | 16.51 | 1        | New       |
      | Printed Dress               | demo_3 | 26.00 | 1        | New       |
      | Printed Summer Dress        | demo_5 | 28.98 | 1        | New       |



