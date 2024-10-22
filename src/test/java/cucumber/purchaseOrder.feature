@tag
Feature: Purchase the order from Ecomm website



  @tag2
  Scenario Outline: Positive test of submitting the order
    Given logged in with email <email> and password <password>
    When I add the product <productName> to cart
    And check out <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on confirmation page

    Examples:
      | email                 | password        | productName    |
      | zlanirini69@xmail.com | k?x;?d+$36;c8Ay | ZARA COAT 3    |
