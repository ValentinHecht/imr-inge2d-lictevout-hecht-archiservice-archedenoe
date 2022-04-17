# imt-inge2d-lictevout-hecht-archiservice-archedenoe

## Mini Projet Architecture à Services
# Lictevout Pierre & Hecht Valentin

## Sommaire

1. Lancement du projet
2. Explication du service
3. Architecture du service

## 1. Lancement du projet

## 2. Explication du service

    Le service que l'on a codé représente l'Arche de Noé, il peut exister plusieurs arches de taille variable contenant 
    un ou plusieurs animaux divers et variés avec une taille qui peut aussi différer.


## 3. Architecture du service
    
    Un back end développé en Spring Boot avec Java (version ?) qui est une API REST 
    et un front rien de plus classique : HTML, CSS et jQuery.

### - Structure du code :
    App
        -src
            -Resources (dossier contenant les routes pour Arches et Animaux)
            -Entity (Description des entités pour la base de données)
            -Repository (Dossier contenant les repository pour les entites, autrement dit la communication avec la BDD)
        -resources 
            -front
                -html (fichier HTML)
                -css  (fichier CSS)
                -index.html fichier html racine
        - persistence.xml (Fichier de configuration de la connexion à la BDD)
        - pom.xml (Fichier de dépendences à ce projet)


### - Base de données :
    La base de données HSQLDB s'architecture en 2 tables : arches et animaux
    Pour synthétiser, Arche et Animaux représentent une relation OneToMany.
    Une arche contient plusieurs animaux, un animal appartient à une arche et une seule.
    Table Arche :
        Concernant la table Arche, on connait Le nom de l'arche, la taille, l'occupation et les animaux quelle contient

        | Type   | Variable   |
        |--------|------------|
        | Long   | id         |
        | String | nom        | 
        | int    | capacite   | 
        | int    | occupation | 

    Table Animaux:
        Plusieurs infos auraient pu se retrouver dans cette table, ici on s'est limité à la race, le nombre de patte et 
        la place que prend l'animal. Bien sur il y a les infos de l'arche dans laquelle se trouve l'animal.

        | Type   | Variable | 
        |--------|----------|
        | Long   | id       |
        | Long   | idarche  |
        | String | Race     | 
        | Long   | nbPatte  |
        | int    | place    |
        
### - Routes disponibles :

#### Arche :
    - GET /api/arches : Renvoi toutes les arches
    - GET /api/arches/{id} : Renvoi une arche d'id {id}
    - POST /api/arches : Ajoute une arche
    - DELETE /api/arches: Supprime une arche
    - PUT /api/arches : Modifie entière une arche
    - PATCH /api/arches : Modifie partiellement ou totalement une arche
    - GET /api/arches/{id}/animaux (en cours de développement) : Renvoi les animaux appartenant à l'arche d'id {id}

#### Animaux :

    - GET /api/animaux : Renvoi tous les animaux
    - GET /api/animaux/{id} : Renvoi un animal d'id {id}
    - POST /api/animaux : Ajoute un animal
    - DELETE /api/animaux : Supprime une ressource de type animal 
    - PUT /api/animaux : Modifie entièrement un animal
    - PATCH /api/animaux : Modifie partiellement ou totalement une ressource animal
    - GET /api/animaux/{id}/arche (en cours de développement) : Renvoi l'arche a laquelle appartient l'animal d'id {id}

Il faut :
La date de rendu du projet est fixée au 17 avril inclus. Il faudra me fournir :

- Un lien Git contenant votre code
- Une vidéo de démonstration de votre site web   
- Un support (slides, documentation, readme…) dans lequel il doit y avoir au minimum :
    - Un schéma représentant le fonctionnement global de votre application
    - La répartition du travail (si TP réalisé en groupe)
    - Les difficultés rencontrées si vous en avez eu

Pensez à mettre votre repo Git en publique ou alors à m’habiliter dessus, voici mes noms d’utilisateurs :

Github : jerome59
Gitlab ou bitbucket : jeromed59
Pensez également à mettre dans votre README, la procédure pour lancer votre projet.

Tout projet qui ne sera pas rendu dans les temps ne sera pas noté.
