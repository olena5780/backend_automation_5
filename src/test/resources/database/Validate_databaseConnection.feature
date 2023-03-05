Feature: Validate database connection
  @db
  Scenario Outline:Validate the minimum salary
    Given User is able to connect to database
    When User sen "<query>" to database
    Then Validate the <salary>

    Examples: Database Query
    | query                  |salary
    | select min(salary) from employees | 2100