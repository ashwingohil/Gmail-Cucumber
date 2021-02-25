Feature: Validating compose feature


  Background: User is logged in
    Given navigate to gmail page
    When user logs in using username as "ashwin.k.gohil@gmail.com" and password as "password"
    Then gmail account page title should contain "ashwin.k.gohil@gmail.com"

  Scenario: Send email to the recipient
    Given User is at his account page with username as "ashwin.k.gohil@gmail.com" and clicks on compose
    When user sends email with attachment to "ashwin.k.gohil@gmail.com" and subject as "My data"
    Then in sent items email should be present with subject as "My data"
    And a message should pop up stating "Message sent"

