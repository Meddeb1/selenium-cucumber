@logout
Feature: Je souhaite tester la fonctionnalite de deconnexion de l application Swag labs
  ETQ utilisateur je souhaite tester la fonctionnalite de deconnexion de l application Swag Labs

  Background: 
    Given Je me connecte a l application Swag Labs

  @deconnexion
  Scenario: Je souhaite tester la fonctionnalite de deconnexion
    And Je clique sur le burguer menu button
    And Je clique sur le bouton Logout
    Then Je me redirige vers la page login "Swag Labs"



