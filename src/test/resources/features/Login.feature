Feature: Login Feature
  #this is for comments

 # Scenario:
    Given I open browser
    And I open Login page
    When I enter email "felicia.clay@testpro.io"
    And I enter password "ACw0FWOe"
    And I submit
    Then I am logged in

  Scenario Outline:
    Given I open browser
    And I open Login page
    When I enter email "<Email>"
    And I enter password "<Password>"
    And I submit
    Then I am logged in
    Examples:
      |Email                   |Password  |
      |felicia.clay@testpro.io |ACw0FWOe  |
      |demo@testpro.io         |ACw0FWOe  |
      |felicia.clay@testpro.io |demotest  |
      |felicia.clay@testpro.io |          |
      |                        |ACw0FWOe  |

