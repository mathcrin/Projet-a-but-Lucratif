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



