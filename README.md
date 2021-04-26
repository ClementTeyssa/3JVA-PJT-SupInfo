# JEE project release for 3JAV course

Voici la documentation pour le [projet SupPictures](./3JVA-Project-SupPictures.pdf). 

Ce projet utilise le responsive design !

Groupe : 
- 293042 : Robin Pierrat
- 295114 : Axel Kimmel
- 292621 : Clément Teyssandier

## Sommaire

0. Installation
1. Structure de données
2. La page d'index
3. L'enregistrement et l'authentification
4. Moteur de recherche
5. Photo
6. Web Service
7. Pages de profil
8. Déconnexion
9. Pannel administrateur

## 0. Installation

Vous aurez besoin au préalable d'une base de données MySQL, ainsi qu'un serveur TomCat.
Les instructions d'installations sont pour utiliser ce projet via Eclipse.

Vous devez tout d'abord importer le projet, pour celà, veuillez suivre les instructions données via les captures d'écran suivantes.

![installation](./img/install1.PNG)
![installation](./img/install2.PNG)
![installation](./img/install3.PNG)
![installation](./img/install4.PNG)
![installation](./img/install5.PNG)
![installation](./img/install6.PNG)

Si il y a toujours une erreur, copier la ligne si dessous, supprimez la, puis collez la.

![installation](./img/install7.PNG)

Vous devriez ne plus avoir d'erreurs.

![installation](./img/install8.PNG)

Il faut ensuite ajouter une connection à la base de données, puis générer les tables grâce aux entitées.

![installation](./img/install9.PNG)
![installation](./img/install10.PNG)

Vous devriez déjà avoir un ORM de selectionné (carré vert), sinon référez vous à [cet magnifique documentation](https://docs.google.com/document/d/1GN3_Wsf1v6Chzhc_nopwWvhdhu_tvkuXl6PepB9ItzU/edit?usp=sharing)

![installation](./img/install11.PNG)
![installation](./img/install12.PNG)
![installation](./img/install13.PNG)
![installation](./img/install14.PNG)
![installation](./img/install15.PNG)
![installation](./img/install16.PNG)
![installation](./img/install17.PNG)
![installation](./img/install18.PNG)
![installation](./img/install20.PNG)

Petites astuces pour un meilleur fonctionnement :
- il est préférable d'utiliser le navigateur internet d'éclipse pour un bon affichage des images
- le dossier qui stock les images sera à la racine de C:\ mais on peut le changer si besoin

![installation](./img/install19.PNG)

## 1. Structure de données

Nous avons représenté la structure de données de notre application via un diagramme UML.

![diagrammeUML](./img/SupPictures.png)

## 2. La page d'index

La page d'accueil donne des informations sur le nombre de **personnes inscrites**, le nombre de **photos publiées**. 
Elle nous permet également de voir une **liste de photos publiées** sur SupPictures.

![](./img/11.png)

## 3. L'enregistrement et l'authentification

Une personne peut s'enregistrer sur le site en cliquant sur ``Register`` dans le menu de navigation.

![](./img/1.1.png)

Dans cette page, des informations personnelles doivent être renseignées. 
Il peut y avoir plusieurs utilisateurs avec le même email. 
Cependant ils ne peuvent pas avoir le même username.
Le premier utilisateur qui s'enregistre aura le rang administrateur.

![](./img/2.png)

Un utilisateur enregistré peut ensuite se connecter au site en cliquant sur ``Login`` dans le menu de navigation.

![](./img/1.2.png)

L'utilisateur doit ensuite renseigner son nom d'utilisateur, ainsi que sont mot de passe pour se connecter.

![](./img/3.png)

Les pages qui doivent être accessibles uniquement pour les utilisateurs authentifiés sont sous un filtre ``auth``, ce qui donne des urls tel que ``url/auth/----``.

## 4. Moteur de recherche

Il est possible de rechercher des photos par leur nom, description, la localisation de l'utilisateur qui l'a publiée ou par la catégorie auquel il appartient.
Ces recherches peuvent être faites par la barre située dans la barre de navigation.

![](./img/1.3.png)

Cela affiche donc les photos correspondant à la recherche.

![](./img/14.png)

## 5. Photo

Quand on affiche une photo, on voit sont titre, sa description, sa date de publication, sa catégorie (si elle en a une), le nombre de vois qu'elle a été vue.

![](./img/15.png)

L'utilisateur qui a publié la photo peut également modifié les éléments de la photos, ou la supprimer.
Cela en cliquant sur ``Me``, puis sur ``MyPicture``.

![](./img/5.1.png)
![](./img/16.png)

## 6. Web Service

Non implémenté.

## 7. Pages de profil

Pour accéder à son profil, un utilisateur doit cliquer sur ``Me``, puis sur ``My Profile``, situé dans le menu de navigation.

![](./img/btnProfile.png)

Le profil permet à un utilisateur d'accéder aux informations de son profil, ainsi que les modifier. Cependant, un autre utilisateur ne peut pas voir le profil d'un autre utilisateur.

![](./img/17.png)

## 8. Déconnexion

Chaque personne connectée, administrateur ou non, peut se déconnecter en cliquant le bouton ``Log Out``, situé dans le menu de navigation. Cela détruit sa session et il sera obligé de se reconnecter pour y accéder de nouveau.

![](./img/4.1.png)

## 9. Pannel administrateur

La partie administration est sécurisée par un filtre sur les urls ``/admin/*``. Il y a deux interfaces de gestion pour l'administrateur : l'interface de **gestion des utilisateurs** et l'interface de **gestion des photos**.

### 9.1 Gestion des utilisateurs

La gestion des utilisateurs est accessible via le menu de navigation sur ``Me``, puis ``Users``.

![](./img/5.2.png)

Une fois sur cette page, l'administrateur a la possibilité de voir quels utilisateurs sont également administrateur. 
Cette interface permet également de supprimer des utilisateurs.

![](./img/18.png)

### 9.2 Gestion des photos

La gestion des photos est accessible via le menu de navigation sur ``Me``, puis ``Pictures``.

![](./img/5.3.png)

Sur cette interface, l'administrateur voit les images, leurs noms et il est possible de les supprimer.

![](./img/19.png)
