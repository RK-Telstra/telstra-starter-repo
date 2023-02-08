Feature: sim card activator
  This feature activates SIM Cards

  Scenario: Valid SIM Card Activation
    Given Valid SIM Card ID has been provided attempt activation
    Then Confirm result of Valid SIM Card activation

  Scenario: Invalid SIM Card Activation
    Given Invalid SIM Card ID has been provided attempt activation
    Then Confirm result of Invalid SIM Card activation







