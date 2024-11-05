# Sujet : Gestion d’un système bancaire  
Votre chef de projet est maintenant responsable d’un nouveau projet, celui-ci permet la gestion d’un petit système bancaire. La phase de cadrage/conception a été effectuée avec l'équipe responsable de l’interface web de l’application, un contrat de service a été mis en place, ce qui permet à cette équipe d’avancer de son côté, car je le rappelle le contrat de service définit les entrées et les sorties de vos web services, le reste c’est une boite noire pour lui.  

De votre côté, vous allez devoir développer à l’aide de Spring Boot, une API Rest qui répond aux normes définies par le contrat de service.  
Vous avez la responsabilité de mettre en place la base de données qui permettra de stocker l’ensemble des données qui seront nécessaires à vos traitements.  

Globalement, le système bancaire est capable de gérer ses différents clients et doit pouvoir connaître son client de manière précise. Son nom, son prénom, son âge, des coordonnées pour le contacter, son adresse etc…  

Le client est rattaché à un code banque et un code guichet/agence.  

Les clients peuvent posséder des comptes, les comptes peuvent être des comptes joints c'est-à-dire avec plusieurs titulaires, les titulaires doivent être dans la même agence.  

Les comptes possèdent un solde. Les comptes sont identifiés à l’aide d’un IBAN (International Bank Account Number). Les iban français sont composés comme ceci : le code pays sur 2 caractères, la clé de contrôle sur 2 caractères : Pour un iban français FR76. Puis du code banque sur 5 caractères (sera celui du client), le code guichet/agence sur 5 caractères (sera celui du client) puis numéro de compte sur 11 caractères et une clé RIB de 2 caractères calculée de la manière suivante :   

Clé RIB = 97 - ( (  
   89 x Code banque +  
   15 x Code guichet +  
   3 x Numéro de compte ) modulo 97 )  
Exemple pour l’iban suivant :   
FR76 30003 02054 10313400399 49  

Exemple de code banque : 30003   
Exemple de code guichet : 02054  

Les comptes peuvent avoir aucune ou une ou plusieurs cartes bancaires associées, maximum 2.  
Les cartes débitent le compte sur lequel elles sont rattachées, elles peuvent également créditer un compte. Elles ne peuvent pas débiter si le solde du compte sera négatif après la transaction.  
Les cartes sont identifiables à l’aide d’un numéro de carte sur 16 caractères, elles possèdent un mot de passe et un mois et année d’expiration.  

Les clients peuvent effectuer des virements vers des comptes. Le compte doit être un compte existant dans la base de données, il n’est pas possible d’effectuer un virement vers un compte externe. Les virements possèdent une date d'exécution, un compte bénéficiaire, un compte émetteur.  
L’ensemble des transactions sont listées sur la synthèse des comptes afin que le client puisse visualiser les opérations passées sur son compte, nous devons être capable de différencier une transaction via un virement ou une carte.  

Vous devez également veiller aux différents codes retours et aux messages de retours et aux cohérences des données en entrée des services.   
## Consignes  

Vous devez mettre en place un schéma de votre base de données répondant aux besoins ci-dessus avant de commencer le code, ne foncez pas tête baissée !

Vous devez mettre en place une API Rest répondant aux besoins et respectant les standards qui ont été définis dans le contrat de service.

Vous devez mettre en place une collection Postman utilisant l’ensemble de votre API Rest.  

Le code sera à rendre dans un fichier zip ou via github.  

Lien du sujet complet : https://docs.google.com/document/d/1jxZi0huyw7pC8Bd7TfZZPiHIJ5kuyVZFaBkfAYsSeLo/edit?tab=t.0#heading=h.ght5bn55n7bd

# Reflexion sur le projet :
## MCD : 

![MCD](https://github.com/mathcrin/Projet-a-but-Lucratif/assets/73893829/9cac4067-2766-4113-8c44-f7d80dc77dda)

## Problème rencontré : 
 Soucis de CORS policy lors d'envoi de requête depuis le front vers le backend 

# BackEnd
## Etape de lancement 

On commence par Lancer le Back dans l'ordre suivant (En sachant que la gateway doit être lancer sur le port 8080 et les microservices doivent simplement être sur des ports différents):

-Lancer le serveur discovery
-Lancer Les microservices
-Lancer la gateway

Si vous voulez réalisez des test sur le back séparement nous avons joint une collection postman dans laquelle il sera simplement nécéssaire de demander un token et l'utilisée.

## Fonctionnalité développés :
-Service de gestion des restaurant
-Service de gestion des Clients (ce service implément RabbitMQ en exemple pour envoyer un message dans la console lors l'enregistrement d'un nouveau clien)
-Service de gestion des commandes et des articles
-Serveur discovery
-Service de Gateway avec authentification

# FrontEnd
## Etape de lancement 
Se rendre dans le dossier "front-angular" et exécuter les commandes suivantes : 

-npm install

-ng serve

## Fonctionnalité initialement prévu
Au debut  nous voulions un systeme permettant a plusieurs restaurant de s'enregistrer et mettre a disposition leurs menu. Les clients aurait pu voir les différents restaurant et Menu associé puis passer une commande (En payant sur place ou directement sur l'application ) .

## Fonctionnalité Actuelle
Systeme permettant a un restaurant de proposer son menu. Les clients peuvent (se connecter/ sinscrire),voir le menu du restaurant puis passer une commande (En payant sur place) .

## Fonctionnalité future possible
-Régler les Très Problable Problème de securité (ce qui nécessiterais biens plus de temps et de connaissances)
-Page pour l'inscription d'un restaurant 
-Page pour l'intégration des menu et photos par le restaurant 
-Page et système de payement 
-Le payement implique la possibilité d'integrer un système de suivit de livraison 


# Les membres de notre équipe : 
__Nahan Galfano__, __Kokou Jean-Luc N'TSOUVI__ et __Mathis Crinchon__



