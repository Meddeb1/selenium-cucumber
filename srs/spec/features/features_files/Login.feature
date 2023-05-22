@login
Feature: Je souhaite tester la page de la connexion de l application Swag labs
  ETQ utilisateur je souhaite tester la page de la connextion de l application Swag Labs

  @connexionCasPassant
  Scenario: Je souhaite tester la page de la connexion avec un cas passant
    Given Je me connecte a l application Swag Labs
    Then Je me redirige vers la page home "Products"
  @login_casNonPassant
  Scenario: Je souhaite tester la page connexion avec un cas non passant
    Given Je me connecte sur l application
    When Je saisi le username "zayn"
    When Je saisi le password "zaynmeddeb"
    When Je clique sur le bouton login
    Then Le message d erreur s affiche "Epic sadface: Username and password do not match any user in this service"
    
    

    
    

    
       
