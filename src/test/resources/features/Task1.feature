@regression
  Feature: Task1

  @debugs
  Scenario Outline: outline for correct number
    Given I am on a Page Enter a number page
    When i enter a number: "<number>"
    And I click submit button
    Then I see the square with "<message>" in popup box

  @working
    Examples:
      | number  | message                   |
      | 57      | Square root of 57 is 7.55 |

    @debugs
    Scenario Outline: error:  outline for error cases
      Given I am on a Page Enter a number page
      When i enter a number: "<number>"
      And I click submit button
      Then I see a message: "<message>"

      @not_working
      Examples:
        | number  | message                   |
        | 20      | Number is too small       |
        | 105     | Number is too big         |
        | ddd     | Please enter a number     |

