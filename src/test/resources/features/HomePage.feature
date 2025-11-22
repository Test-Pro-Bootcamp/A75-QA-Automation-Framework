Feature: HomePage feature

  Scenario: Welcome Message
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    Then Home Page is displayed

  Scenario: Recently Played
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    Then Recently Played Label is displayed

  Scenario: Recently Played View All
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    Then View All Button is displayed

  Scenario: Recently Added Songs Displayed
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    Then Recently Added Songs is displayed

  Scenario: Recently Added Album Displayed
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    Then Recently Added Album is displayed

  Scenario: Search Field Displayed
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    Then Search field is displayed

  Scenario: Home Page is Displayed
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    And Most Played Label is displayed
    And Recently Played Label is displayed
    And Recently Added Songs is displayed
    And Top Artists is displayed
    And Top Albums is displayed
    Then Home Page is displayed

  Scenario: New Playlist Button
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    And Playlist Button is displayed
    Then Home Page is displayed

  Scenario: Playlist Panel
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    And Favorites Label is displayed
    And Playlist Recently Played Label is displayed
    And New Playlist Label is displayed
    Then Home Page is displayed

  Scenario: Profile Page is Displayed
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    And Profile Image is displayed
    And I open Profile page
    And I open Home Page
    Then Home Page is displayed

  Scenario: About Page is Displayed
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    And About Image is displayed
    And I open About Page
    And I close About Page
    Then Home Page is displayed

  Scenario: Logout Button is Clicked
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Home Page
    And Logout Image is displayed
    And I Logout
    Then Login Page is displayed






