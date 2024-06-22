@SmokeTest

Feature: Groceries navigation dropdown

    Rule: Navigation tabs should lead to the proper categories

      Scenario: Navigation tabs lead to the 'Cake' category

        Given I open Tesco website

        And I click on 'Bakery' button
        And I click on 'Pastry' button

        When I click on 'Cake' button
        Then 'Cake' category page is opened