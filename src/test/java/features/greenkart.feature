Feature: To verify end to end checkout jpurney.

Scenario: Greenkart checkout.
Given user is on greenkart site.
When user add vegitable in the kart.
And do checkout journey
Then success messages is displayed and image is captured.

