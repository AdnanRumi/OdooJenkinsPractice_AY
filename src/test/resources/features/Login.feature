@basicSteps
Feature: Login

  Background:
    Given the user is on the login page

  Scenario Outline: Entering valid credentials for different user types

    When the user enters valid "<username>" and "<password>"
    Then the user should be able to login to the app
    Examples:
      | username                   | password         |
      | salesmanager15@info.com    | salesmanager     |
      | posmanager10@info.com      | posmanager       |
      | imm10@info.com             | inventorymanager |
      | expensesmanager10@info.com | expensesmanager  |
      | manuf_user10@info.com      | manufuser        |

  Scenario Outline: Entering valid username but invalid password for different user types

    When the user enters valid "<username>" but invalid "<password>"
    Then the user should NOT be able to login to the app
    Examples:
      | username                   | password         |
      | salesmanager15@info.com    | Ssalesmanager    |
      | posmanager10@info.com      | poosmanager      |
      | imm10@info.com             | inventorimenager |
      | expensesmanager10@info.com | expensivemanager |
      | manuf_user10@info.com      | manuf user       |

  Scenario Outline: Entering invalid username but valid password for different user types

    When the user enters invalid "<username>" but valid "<password>"
    Then the user should NOT be able to login to the app
    Examples:
      | username                    | password         |
      | Salesmanager15@info.com     | salesmanager     |
      | postmanager10@info.com      | posmanager       |
      | @info.com                   | inventorymanager |
      | expenses manager10@info.com | expensesmanager  |
      | manuf-user10@info.com       | manufuser        |


