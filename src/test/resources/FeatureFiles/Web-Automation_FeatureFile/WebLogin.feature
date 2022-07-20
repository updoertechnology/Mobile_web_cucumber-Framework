@LoginCreation
Feature: Creation Of Transfer Id with Various drivers

  @regresstionTest @TSID_001
  Scenario Outline: The client (compte pro) must be able to create a transfer with a professional driver and verify in admin the transfer is created. The transfer to be created with some attachments added.
    Given User is on Client Log In Page Of Demo Website
    Then User is Logged in with Valid Credentials "<clientEmailId>" and "<clientEmailPassword>"
    

    Examples: 
      | clientEmailId | clientEmailPassword |
      | email         | password            |
