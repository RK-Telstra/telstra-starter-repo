Feature: sim card activator
  This feature activates SIM Cards

  Scenario: Valid SIM Card Activation
    Given a valid SIM Card ID has been provided
    When a request to activate SIM Card is submitted
    Then confirm valid SIM Card activation attempt status from database

  Scenario: Invalid SIM Card Activation
    Given an invalid SIM Card ID has been provided
    When a request to activate SIM Card is submitted
    Then confirm invalid SIM Card activation attempt status from database







