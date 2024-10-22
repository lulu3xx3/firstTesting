@tag
Feature: Error validation
  I want to use this

  @tag2
  Scenario Outline: Title
    Given I landed on Ecommerce Page
    When Logged in with username <username> and password <password>
    Then "Incorrect email or password." is to be displayed

    Examples:
      | username                   | password          |
      | zlanirinisd6559@xmail.com  | k?x;?d+$3sa6;c8Ay |
