Feature: Login Feature
  #this is for comments

  Scenario Outline:
    Given I open browser
    And I open Login page
    When I enter email "<Email>"
    And I enter password "<Password>"
    And I submit
    Then I am logged in
    Examples:
      |Email                   |Password  |
      |felicia.clay@testpro.io |ACw0FWOe#3|
      |demotestprio            |ACw0FWOe#3|
      |felicia.clay@testpro.io |demotest  |
      |felicia.clay@testpro.io |          |
      |                        |ACw0FWOe#3|
      |                        |          |
# This row represents empty input

  #Opens Login with no issues
  Scenario: Login
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    Then I am logged in

#Open Home Page
  Scenario: HomePage
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open Home Page
    Then Home Page is displayed

  #Open Current Queue Page
  Scenario: Current Queue
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open Current Queue Page
     Then Current Queue is displayed

  #Open All Songs Page
  Scenario: All Songs
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open All Songs Page
    Then All Songs Page displayed

  #Open Albums Page
  Scenario: Albums
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open Albums Page
    Then All Albums are displayed

  #Open Artists Page
  Scenario: Artists
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open Artists Page
    Then Artists Page is displayed

  #Open Favorites Page
  Scenario: Favorites
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open Favorites Page
    Then Favorites Page is displayed

  #Open Recently Played Page
  Scenario: Recently Played
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open Recently Played Page
    Then Recently Played is displayed

#Open User created playlist
  Scenario: User Playlist
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open User created playlist
    Then User Playlist is displayed

   #Open Profile Page
  Scenario: Update
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#3"
    And I submit
    And I open Profile page
    And I enter current password "ACw0FWOe#3"
    And I enter new password "ACw0FWOe#4"
    And I Save
    And I enter current password "ACw0FWOe#4"
    And I enter new password "ACw0FWOe#3"
    And I Save
    Then Profile has been updated

  #Scenario Outline:
  #  Given I open browser
  #  And I open Login page
  #  When I enter email "<Email>"
  #  And I enter password "<Password>"
  #  And I submit
  #  Then I am logged in
  #  Examples:
  #    |Email                   |Password  |
  #    |felicia.clay@testpro.io |ACw0FWOe#3|
  #    |demotestprio            |ACw0FWOe#3|
  #    |felicia.clay@testpro.io |demotest  |
  #    |felicia.clay@testpro.io |          |
  #    |                        |ACw0FWOe#3|
  #    |                        |          |
# This row represents empty input
