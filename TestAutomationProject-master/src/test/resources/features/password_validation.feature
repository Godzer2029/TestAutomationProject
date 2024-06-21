@SmokeTest

Feature: Password field validation on Registration page

    Rule: Password should be validated by certain rules

      Background:
        Given I open Tesco website
        And I accept cookies
        And I click on 'Register' button

      Scenario Outline: Password field left empty

        Given I enter '<email>' and '<password>'
        When I click on 'Next' button
        Then I see validation error for password

        Examples:
          | email         | password |
          | 123@gmail.com |          |


      Scenario Outline: Password field with less then 8 letters and numbers

        Given I enter "<email>" and "<password>"
        When I click on 'Next' button
        Then I see validation error for password

        Examples:
          | email         | password |
          | 123@gmail.com | abc1234  |


      Scenario Outline: Password field with all rules fulfilled

        Given I enter "<email>" and "<password>"
        When I click on 'Next' button
        Then I don't see validation error for password

        Examples:
          | email         | password |
          | 123@gmail.com | abc12345 |
