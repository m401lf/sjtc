Feature: Verifying e-commerce Search to Order item functionality

  @Search_E2E1
  Scenario: search keyword should be for Products meeting the search criteria
    Given I landed on Ecommerce website
    When I search with a keyword ""
    And I search for job with "Category"
    And I can see the search result for "Category"
    And I can see page url, title and header as follows:
      | Page Url                                | Page Title | Page Header |
      | index.php?rt=product/search&category_id | Search     | SEARCH      |
    And I can see current page breadcrumb "Search"
    And I can see the followings displayed in the search result page:
      | Search Criteria                                       |
      | Search in product descriptions                        |
      | Search in product model                               |
      | Products meeting the search criteria                  |
      | There is no product that matches the search criteria. |
    And I can see the followings displayed in the Sort By dropdown search result page:
      | Date Old > New   |
      | Name A - Z       |
      | Name Z - A       |
      | Price Low > High |
      | Price High > Low |
      | Rating Highest   |
      | Rating Lowest    |
      | Date New > Old   |




