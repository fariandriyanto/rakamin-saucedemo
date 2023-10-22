Feature: Login page web SauceDemo

  Scenario: Success Login
    Given halaman login SauceDemo
    When input username
    And input password
    And klik tombol login
    Then user masuk ke dashboard

    Scenario: Failed Login
      Given halaman login SauceDemo
      When input username
      And input invalid password
      And klik tombol login
      Then user get error mesasge