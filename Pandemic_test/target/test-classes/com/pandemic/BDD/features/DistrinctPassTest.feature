Feature: E-Pass Application Form Submission
  @AnotherPage
  Scenario: Submit E-Pass form with valid data
    Given User is on the E-Pass application page
    When User fills the form with "<name>", "<email>", "<mobile1>", "<mobile2>", "<mobile3>", "<district>", "<gender>", "<aadhaar>", "<reason>"
    And User submits the form
    Then Proper form result should be displayed for "success"

    Examples:
      | name   | email           | mobile1 | mobile2 | mobile3 | district | gender | aadhaar      | reason     |
      | Alice  | alice@gmail.com  | 987     | 654     | 3210    | Chennai  | Female | 123456789012 | Wedding      |
  
   @AnotherPage
  Scenario: Submit E-Pass form with invalid data
    Given User is on the E-Pass application page
    When User fills the form with "<name>", "<email>", "<mobile1>", "<mobile2>", "<mobile3>", "<district>", "<gender>", "<aadhaar>", "<reason>"
    And User submits the form
    Then Form should not be submitted

    Examples:
      | name  | email     | mobile1 | mobile2 | mobile3 | district | gender | aadhaar    | reason |
      | Bob   | bobmail   | 98x     | 12b     | 3aa     | Chennai    | Other  | abc123     | Interview    |
  @AnotherPage
  Scenario: Submit E-Pass form with empty data
    Given User is on the E-Pass application page
    When User fills the form with "<name>", "<email>", "<mobile1>", "<mobile2>", "<mobile3>", "<district>", "<gender>", "<aadhaar>", "<reason>"
    And User submits the form
    Then Proper form result should be displayed for "error"

    Examples:
      | name | email | mobile1 | mobile2 | mobile3 | district | gender | aadhaar | reason |
      |      |       |         |         |         |     Chennai     |        |         |     Interview   |
   @AnotherPage
  Scenario: Submit E-Pass form with valid data and table should be displayed
    Given User is on the E-Pass application page
    When User fills the form with "<name>", "<email>", "<mobile1>", "<mobile2>", "<mobile3>", "<district>", "<gender>", "<aadhaar>", "<reason>"
    And User submits the form
    Then Proper form result should be displayed for "success"
    And table should be there as a result

    Examples:
      | name   | email           | mobile1 | mobile2 | mobile3 | district | gender | aadhaar      | reason     |
      | Alice  | alice@gmail.com  | 987     | 654     | 3210    | Chennai  | Female | 123456789012 | Wedding     |  
   