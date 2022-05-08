Feature: Loading the Amazon website.

@AmazonLogin
  Scenario: User go to the Amazon website and search for the book.
    Given User go to Google page
    When User pass "Amazon" text option in the google search box 
    And User clicks on button button
    Then User enter to the Amazon home page
    And User pass the book "The Lost World by Arthur Conan Doyle" in amazon search box
    And User click on search button
    Then user go to the search reasult page and find the total books result
    When User change the language "French" using filter option
    Then User finds a different count for that particular book search