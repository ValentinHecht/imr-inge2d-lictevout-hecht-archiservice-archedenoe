# imt-inge2d-lictevout-hecht-archiservice-archedenoe

## Mini Projet Architecture à Services
# Lictevout Pierre & Hecht Valentin
## Répartition du travail :
- 30% Back/70% Front Pierre Lictevout
- 70% Back/30% Front Valentin Hecht

Nous avons travaillé avec IntelliJ en collaboration avec CodeWithMe permettant de lancer/coder sur une seule machine. 
Nous avons ensuite ouvert les ports de nos box afin de pouvoir accéder au back et front de l'application.

Lien de la vidéo démo :
https://youtu.be/uXR1D0dCp-Y


## Sommaire

1. Lancement du projet
2. Explication du service
3. Architecture du service
4. Difficultés rencontrées

## 1. Lancement du projet

Front End :
- Se rendre index.html

Back End :
- Run avec Java 17 ArchedenoeApplication.java

BDD :

Se placer à la racine du repo Git et taper la commande : 
<code>java -cp hsqldb-2.6.1/hsqldb/lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:database.db --dbname.0 archeBDD</code>

## 2. Explication du service

    Le service que l'on a codé représente l'Arche de Noé, il peut exister plusieurs arches de taille variable contenant 
    un ou plusieurs animaux divers et variés avec une taille qui peut aussi différer.

## 3. Architecture du service
    
    Un back end développé en Spring Boot avec Java (version ?) qui est une API REST 
    et un front rien de plus classique : HTML, CSS et jQuery.

### - Fonctionnement global :

@startuml
User -> Front: Interact with button, fields
Front -> Back: REST API Calls to fetch, modify and delete data
Back -> Repository: Interface java langauge and database
Repository -> Back: Return data
Back -> Front: Format data
@enduml

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
        | Long   | arche_id |
        | String | Race     | 
        | Long   | nbPatte  |
        | int    | place    |
        
### - Routes disponibles :

#### Arche :
    - GET /api/arches : Renvoi toutes les arches
    - GET /api/arches/{id} : Renvoi une arche d'id {id}
    - POST /api/arches : Ajoute une arche
    - DELETE /api/arches: Supprime une arche
    - PUT /api/arches (en cours de développement): Modifie entière une arche
    - PATCH /api/arches : Modifie partiellement ou totalement une arche
    - GET /api/arches/{id}/animaux : Renvoi les animaux appartenant à l'arche d'id {id}

#### Animaux :

    - GET /api/animaux : Renvoi tous les animaux
    - GET /api/animaux/{id} : Renvoi un animal d'id {id}
    - POST /api/animaux : Ajoute un animal
    - DELETE /api/animaux : Supprime une ressource de type animal 
    - PUT /api/animaux (en cours de développement): Modifie entièrement un animal
    - PATCH /api/animaux : Modifie partiellement ou totalement une ressource animal
    - GET /api/animaux/{id}/arche (en cours de développement) : Renvoi l'arche a laquelle appartient l'animal d'id {id}

## 4. Difficultés rencontrées

### - Front End:
* La relation Animaux/Arche

### - Back End:
* L'implémentation des relations OneToMany/ManyToOne
* Update des arches et animaux
* HSQLDB (Manager, connexion à la BDD depuis le Back)

### - Globalement:
* Travail collaboratif (ouverture de port sur le réseau de l'IMT par ex)