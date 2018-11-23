Feature: Ryanair booking
  In order to book a trip
  As a generic user
  I want to search a flight  from some city
  to another city in the given days by the user
  for the given number and types of passengers

  Background:
    Given I am in ryanair webpage
    And I close cookies politics

  @Scenario
  Scenario: Ryanair booking
    When I click for 'ida'
    And I want to go from 'Madrid' to 'Gran Canaria'
    And I want to go tomorrow
    And I click in go button
    Then I should see the result page with at least one flight

  @ScenarioOut
  Scenario Outline: Ryanair booking with parameters table
    When I click for '<direction>'
    And I want to go from '<fromPlace>' to '<toPlace>'
    And with dates '<dateOut>'
    And '<dateReturn>'
    And I click in go button
    Then I should see the result page with at least one flight

    Examples:
      | direction | fromPlace | toPlace  | dateOut           | dateReturn        |
      | idaVuelta | Madrid    | Toulouse | November 24, 2018 | November 28, 2018 |