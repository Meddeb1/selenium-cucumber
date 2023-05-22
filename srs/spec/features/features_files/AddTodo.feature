
@addTdo
Feature: Je souhaite tester la fonctionnalité add todo

  @add
  Scenario: Je souhaite tester add todo
    Given Je me connecte a l application
    When Je souhaite ajouter un todo
    Then Je supprime le todo
    And Je check


  