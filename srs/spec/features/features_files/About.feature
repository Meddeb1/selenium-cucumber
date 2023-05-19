@about
Feature: Je souhaite tester la fonctionnalité About
  ETQ utilisateur je souhaite tester la fonctionnalite About de l application Swag Labs

  Background: 
    Given Je me connecte a l application Swag Labs

  @about_products
  Scenario: Je souhaite tester la fonctionnalite about avec le menu products
    When Je clique sur le burguer menu button
    And Je clique about
    And Je survole le menu Products
    And Je clique sur Sauce Mobile
    Then Je me redirige vers la page  Sauce Mobile "MOBILE APP TESTING"
