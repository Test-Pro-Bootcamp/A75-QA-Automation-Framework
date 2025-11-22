Feature: Logout Feature

  Scenario Logout:
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I Logout
    Then Login Page is displayed





