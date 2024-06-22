@SmokeTest

Feature: Online club information page

    Rule: New tab with Online Club information should be opened

        Scenario: New tab with Online Club information is opened after 'Online Club' button is clicked

          Given I open Tesco website


          When I click on 'Online Club' button
          Then New tab with Online Club information is opened

