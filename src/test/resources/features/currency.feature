Feature: Verify that the response based on countries

  Scenario Outline: Verify that the response contains correct currencies respectively
    When I select "<currency>" as query parameter
    Then Verify currency in response contains "<currency>"
    Examples:
      |currency|
      |GBP     |
      |EUR     |
      |SEK     |