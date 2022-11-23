Sample story

Narrative:
As a renter
I want to do a search
In order to look at available apartments

Scenario: Search on StudentHousing
Given the browser is open
And the page http://localhost:8080/site/index.html is displayed
When I search for small apartment
Then the content View Apartment is displayed

