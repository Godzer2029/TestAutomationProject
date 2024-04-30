Feature: Search by the search field

    Rule: Search is allowed

        Scenario: When I search for the specific item via search field it should be found

            Given I open Tesco website

            And I accept cookies
            And I click on 'Search' field
            And I type 'Cucumber' into search field

            When I press the 'Search' button
            Then Results page with entered value is opened