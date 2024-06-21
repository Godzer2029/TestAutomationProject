@SmokeTest

Feature: Language change

    Rule: Language change is allowed

      Scenario: If I press the 'Magyar' button, language changes to Hungarian.
                If I press the 'English' button, language changes to English

        Given I open Tesco website

        And I accept cookies
        And 'Magyar' button is present on page

        When I change language to 'Magyar'
        Then language is changed to 'Magyar'

        And 'English' button is present on page

        When I change language to 'English'
        Then language is changed to 'English'