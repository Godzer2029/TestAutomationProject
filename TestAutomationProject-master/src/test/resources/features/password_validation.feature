Feature: Password field validation on Registration page

  Rule: Password should be validated by certain rules

    Background:
      Given I open Tesco website
      And I click on 'Register' button

    Scenario Outline: Password field validation
      Given I enter "<email>" and "<password>"
      When I click on 'Next' button
      Then I should see "<validationResult>" for password

      Examples:
        | email         | password  | validationResult |
        | 123@gmail.com |           | required         |
        | 123@gmail.com | abc1234   | invalid          |
        | 123@gmail.com | abc12345  | valid            |