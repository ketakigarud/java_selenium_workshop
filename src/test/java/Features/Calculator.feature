# new feature
# Tags: optional

@Web
Feature: Basic Calculator operations

  @Regreesion
  Scenario Outline: Verify basic calculations
    Given I am on Calculator page
    When I enter '<number1>' in calculator
    And I Press '<op>'
    And I enter '<number2>' in calculator
    And I Press '='
    Then I see the result is '<Expected_result>'
    Examples:
      | number1 | op | number2 | Expected_result |
      | 15      | +  | 14      | 29              |
     # | 5         | *   | 4       | 20              |

  @Smoke1 @Regression
  Scenario: Verify subtraction of two numbers
    Given I am on Calculator page
    When I enter '15' in calculator
    And  I Press '-'
    And I enter '4' in calculator
    And I Press '='
    Then I see the result is '11'