Feature: Password field validation on Registration page

    Rule: Password should be validated by certain rules

      Scenario Outline: Password field left empty

        Given I open Tesco website

        And I accept cookies
        And I click on 'Registration' button

        When I enter "<email>" and "<password>"
        And I click on 'Next' button
        Then I see validation error for password

        Examples:
          | email         | password |
          | 123@gmail.com |          |


      Scenario Outline: Password field with less then 8 letters and numbers

        Given I open Tesco website

        And I accept cookies
        And I click on 'Registration' button

        When I enter "<email>" and "<password>"
        And I click on 'Next' button
        Then I see validation error for password

        Examples:
          | email         | password |
          | 123@gmail.com | abc1234  |


      Scenario Outline: Password field with all rules fulfilled

        Given I open Tesco website

        And I accept cookies
        And I click on 'Registration' button

        When I enter "<email>" and "<password>"
        And I click on 'Next' button
        Then I don't see validation error for password

        Examples:
          | email         | password |
          | 123@gmail.com | abc12345 |
