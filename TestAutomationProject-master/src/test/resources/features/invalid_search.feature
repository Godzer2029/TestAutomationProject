Feature: Unsuccessful search by the search field

    Rule: Search with invalid values is allowed and shows appropriate message

        Scenario: When I search for the specific item via search field it should be found

            Given I open Tesco website

            Then I type "qwerty" into search field

            When I press the 'Search' button
            Then Search results page is opened
            And Message about unsuccessful search is shown
            And Shop and Search buttons are presented on page and clickable

