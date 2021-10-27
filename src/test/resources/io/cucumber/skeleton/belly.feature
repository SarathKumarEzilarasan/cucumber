Feature: Belly

  @tag
  Scenario: A few cukes
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl


  @tag1
  Scenario: a few cukes
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl


#  mvn test -Dcucumber.filter.tags="@tag"
