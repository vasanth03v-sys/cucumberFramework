Feature: Login functionality
Background:
  Given I open the login page
  @smoke
  Scenario: Successful login
    When I enter valid username and password
    Then I should be logged in successfully

  @regression
  Scenario Outline: Invalid login
    When I enter username "<username>" and password "<password>"
    Then I should see the login error message
    Examples:
      | username      | password       |
      | standard_user | standard_passs |
      | passs         | secret_sauce   |

    @dataTable
    Scenario: Login  using dataTable
      When I enter login details
        |  username| standard_user |
        |      password |      secret_sauce  |

      Then I should be logged in successfully