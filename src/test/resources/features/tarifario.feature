#Author: jortizf@choucairtesting.com
Feature: Verify the tariff PDF's
  As a user, I want to know the tariff of the services of Banitsmo

  Background:
    Given that Camilo is in the Banitsmo Page
    And he goes to the tariff page

  @automatizacion
  Scenario: Deposit Account Fees PDF
    When he click the Deposit Account Fees
    Then he sees the PDF of that service

  Scenario: Credit Card Fees PDF
    When he click the Credit Card Fees link
    Then he sees the PDF of that service