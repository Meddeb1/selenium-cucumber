@Login
Feature: Je souhaite tester la page de la connexion de l application Swag labs
  En tant que utilisateur je souhaite tester la page de la connexionde l application Swag Labs

  @Login_CasPassant
  Scenario: Je souhaite tester la page de la connexion avec un cas passant
    Given Je me connecte a l application Swag Labs      
    When Je saisis le username "standard_user"          
    And Je saisis le password "secret_sauce"            
    And Je clique sur le bouton Login                   
    Then Je me redirige la page home "Products"         
