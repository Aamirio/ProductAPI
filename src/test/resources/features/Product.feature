Feature: Product Service
  As a consumer
  I want to be able to add and receive products from the product service
  So customers can receive product information and staff can add new products to the inventory

  Scenario: A customer can retrieve a product
    Given a product id of "abc123"
    When I ask for a product
    Then a valid product should be returned

  Scenario: A customer can view a graceful response when passing an invalid product id
    Given a product id of "xxx999"
    When I ask for a product
    Then an error should be returned

#  Scenario: A procurement officer may add a new product to the inventory
#    Given I need to add a new product
#    When I add a new product
#    Then I should receive a product id
