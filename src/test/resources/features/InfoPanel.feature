Feature: Info Panel

  Scenario: Album
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Albums Page
    And I play Album
    Then Album is displayed

  Scenario: Lyrics
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Albums Page
    And I play Album
    Then Lyrics is displayed

  Scenario: Artist
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Artists Page
    And I play Artist
    Then Artists is displayed

  Scenario: Info
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Albums Page
    And I play Album
    And I click Info Button
    Then Info Panel is displayed

  Scenario: Info Hidden
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Albums Page
    And I play Album
    And I click Info Button
    And I click Info Button
    Then Info Panel is displayed


  Scenario: Shuffle Artist
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Artists Page
    And I play Artist
    And Artists is displayed
    Then I shuffle Artist

  Scenario: Shuffle Album
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Albums Page
    And I play Album
    And Album is displayed
    Then I shuffle Album




