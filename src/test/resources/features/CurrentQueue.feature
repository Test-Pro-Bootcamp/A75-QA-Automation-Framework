Feature: Current Queue

  #Current Queue page should display currently played songs by a user in the app
  #The total count of songs should be displayed
  #The total duration count of all songs should be displayed
  #ID, Title, Artist, Album, and Time should be correctly displayed
  Scenario: Current
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Albums Page
    And I play Album
    And I display Total Song Count and Duration
    And I display Table Headers
    Then Current Queue is displayed

  #User should be navigated to the Current Queue page after double clicking on the song on the following pages:
  #Home, All songs, Albums, Artists, Favorites, Recently played, and user's created playlist
  Scenario: Album
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Albums Page
    And I play Album
    Then Album is displayed

  Scenario: Artist
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Artists Page
    And I play Artist
    Then Artists is displayed
    #Home Page Most Played and Recently Played does not go to Current Queue Page
    #All songs music plays but doesn't go to Current Queue Page
    #Favorites music plays but doesn't go to current queue page
    #Recently Played music plays but doesn't go to current queue page
    #User created playlist music plays but doesn't go to current queue page

  #'Shuffle All' button should shuffle songs
  #Songs should appear on the Current Queue page when clicking on the 'shuffling all songs'
Scenario: Shuffle All
  Given I open browser
  And I open Login page
  When I enter email "felicia.clay@testpro.io"
  And I enter password "ACw0FWOe#4"
  And I submit
  And I open All Songs Page
  And I shuffle All
  Then Current Queue is displayed

  #The page should be empty after clicking on 'Clear' button.
  # 'No songs queued. How about shuffling all songs?' message should appear.
  Scenario: Clear All
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe#4"
    And I submit
    And I open Albums Page
    And I play Album
    And I open Current Queue Page
    And I Clear All
    Then Current Queue Clear Page is displayed


