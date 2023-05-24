
@uploadFileRobot
Feature: je verifie le chargement du fichier sur l application web 
  ETQ utilisateur je veux tester la fonctionnalite d charger un fichier

  @uploadFile
  Scenario:  je verifie le chargement du fichier sur l application web 
    Given Je me connecte aa l application 
    And   Je teste la fonctionnalite de charger un fichier 
    Then je verifie si le fichier est charge "chapitre 1 par donia abdelkarim.pptx"

 
