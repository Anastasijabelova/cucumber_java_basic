@regression
Feature: Task2

  @debugs
  Scenario Outline: Add a new person
    Given I am on a People with jobs page
    When i click on add a Person button
    And I enter the "<name2>"
    And I enter the job "<job2>"
    Then I click on Add button
    Then Person appears in the main list with "<name2>"

    Examples:
      | name2       | job2   |
      | Anastasija  | Tester |


  Scenario: Edit a person
    Given I am on a People with jobs page
    When i click on add a Person button
    And I enter the "Anastasija"
    And I enter the job "Tester"
    Then I click on Add button
    When I click on a person pencil sign to Edit
    And I edit the name of the person to "Dmitrijs"
    And I click on edit button
    Then Person edited name appears in the main list with "Dmitrijs"

  Scenario: Reset a list after adding a person
    Given I am on a People with jobs page
    When i click on add a Person button
    And I enter the "Anastasija"
    And I enter the job "Tester"
    Then I click on Add button
    And I click on Reset list button
    Then Person "Anastasija" is not present in the list

  Scenario: Remove a person
    Given I am on a People with jobs page
    When i click on add a Person button
    And I enter the "Anastasija"
    And I enter the job "Tester"
    Then I click on Add button
    And I click on Remove button
    Then Person "Anastasija" is not present in the list

  Scenario: Reset a list after editing a person
    Given I am on a People with jobs page
    When i click on add a Person button
    And I enter the "Anastasija"
    And I enter the job "Tester"
    Then I click on Add button
    When I click on a person pencil sign to Edit
    And I edit the name of the person to "Dmitrijs"
    And I click on edit button
    Then Person edited name appears in the main list with "Dmitrijs"
    And I click on Reset list button
    Then Person "Dmitrijs" not present in the list

  Scenario: Reset a list after removing a person
    Given I am on a People with jobs page
    When i click on add a Person button
    And I enter the "Anastasija"
    And I enter the job "Tester"
    And I click on Add button
    And I click on Remove button
    And I click on Reset list button
    Then Only original names are displayed

  Scenario: check that clear button on adding a user works correctly
    Given I am on a People with jobs page
    When i click on add a Person button
    And I enter the "Anastasija"
    Then I click on Clear button
    Then All fields are empty
