Feature: Language change

    Rule: Language change is allowed

      Scenario: When I press the 'Magyar' button, language changes to Hungarian
        Given I open Tesco website

        And I accept cookies
        And language is set to 'English'

        When I change language to 'Hungarian'
        Then language is changed to 'Hungarian'

      Scenario: When I press the 'English' button, language changes to English

        Given I open Tesco website

        And I accept cookies
        And language is set to 'Hungarian'

        When I change language to 'English'
        Then language is changed to 'English'
