Feature: Verify  the email and Password
  Scenario Outline: Verify Rest API Post Call
    Given crate a user with "<url>" with "<username>" and "<password">
    Then Response Code should be "<responseCode>"
    Examples:
    | url                 | user            | pass       | responseCode|  |
    | /register/preprod   | abc@gmail.com   | Test@123   |    201         |  |