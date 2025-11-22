Feature: Profile and Preferences feature

  Scenario: Update Name
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Profile page
    And I enter password "ACw0FWOe#4"
    And I enter Name "Felicia"
    And I Save
    And I open Home Page
    Then Home Page is displayed New Name

  Scenario: Update Email
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Profile page
    And I enter password "ACw0FWOe#4"
    And I enter new email "felicia.clay2.testpro.io"
    And I Save
    And I enter password "ACw0FWOe#4"
    And I enter new email "felicia.clay.testpro.io"
    And I Save
    Then Profile has been updated


  Scenario: Update Password
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Profile page
    And I enter current password "ACw0FWOe#4"
    And I enter new password "ACw0FWOe#4"
    And I Save
    And I enter current password "ACw0FWOe#4"
    And I enter new password "ACw0FWOe#4"
    And I Save
    Then Profile has been updated

  Scenario: Change Theme
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Profile page
    And I click theme
    And Profile has been updated
    Then I open Favorites Page

  Scenario: Show Now Playing
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Profile page
    Then I check Now Playing

  Scenario: Show Confirmation
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Profile page
    Then I check Confirmation

  Scenario: Show translucent
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Profile page
    Then I check show translucent

