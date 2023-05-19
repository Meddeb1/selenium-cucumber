@loginOutline
Feature: Je souhaite me connecter a l application avec plusieurs comptes

  Scenario Outline: Je souhaite me connecter a l application avec plusieurs comptes
    Given Je me connecte sur l application
    When Je saisi le username "<username>"
    When Je saisi le password "<password>"
    And Je clique sur le bouton login

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
