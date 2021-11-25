Feature: Homepage details

 @regression
  Scenario: Verify default product names
    Given I am on the homepage
    Then The product names should be the following
      | Faded Short Sleeve T-shirts |
      | Blouse                      |
      | Printed Dress               |
      | Printed Dress               |
      | Printed Summer Dress        |
      | Printed Summer Dress        |
      | Printed Chiffon        |
    And The title should be "My Store"


    Scenario: Datatable example 1
      Given I am on the homepage
      When I pass this table information
        | firstName   | lastName | birthDate  | id |
        | Annie M. G. | Schmidt  | 1911-03-20 | 23 |
        | Roald       | Dahl     | 1916-09-13 | 12 |
        | Astrid      | Lindgren | 1907-11-14 | 11 |


      Then It should be correct



  Scenario: Datatable example  Maps
    Given I am on the homepage
    When I pass this table information as a Map
      | KMSY | Louis Armstrong New Orleans International Airport |
      | KSFO | San Francisco International Airport               	|
      | KSEA | Seattle–Tacoma International Airport              	|
      | KJFK | John F. Kennedy International Airport             	|



    Then It should be correct



  Scenario: Datatable example Map of String and List
    Given I am on the homepage
    When I pass this table information as Map<String,List<String>>
      | KMSY | 29.993333 |  -90.258056 |
      | KSFO | 37.618889 | -122.375000 |
      | KSEA | 47.448889 | -122.309444 |
      | KJFK | 40.639722 |  -73.778889 |


    Then It should be correct



  Scenario: Datatable example Map of String and Map
    Given I am on the homepage
    When I pass this table information as Map<String,Map<String,String>>
      |      | lat       | lon       |
      | KMSY | 29.993333 | -90.258056  |
      | KSFO | 37.618889 | -122.375000 |
      | KSEA | 47.448889 | -122.309444 |
      | KJFK | 40.639722 | -73.778889  |


    Then It should be correct

  @regression
  Scenario: Verify product details
    Given I am on the homepage
    When I click on a "Blouse"
    Then The details of the product should be
      | Name   | Model No | Condition | Description                                               | Price  | Quantity |
      | Blouse | demo_2   | New       | Short sleeved blouse with feminine draped sleeve detail. | $27.00 | 1        |











