Feature: feature to test ClearTrip
Scenario: Check user is able to search and book flight
Given user is cleartrip URL
When user from and to and departure date
And Click on Search Flights
Then User is navigated to details page

