[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/dnW0dm4q)
# Projet "Dice" - Gestion de lancés de dés avec Spring Boot

## Description
Le projet "Dice" est une application construite avec Spring Boot permettant de simuler des lancés de dés et de gérer un historique des résultats en base de données. Ce projet met en œuvre les concepts fondamentaux de Spring Boot, notamment l'injection de dépendances, les services RESTful, les entités JPA et les repositories.

# Pour lancer le projet, il faut se rentre dans le dossier dice et lancer la commande suivante :
```bash 
mvn spring-boot:run
```
Pour lancer un seul dé, il faut suivre le lien suivant : http://localhost:8081/rollDice
Pour lancer plusieurs dés, il faut suivre le lien suivant : http://localhost:8081/rollDices/{nombre_de_roll}
Il faut ensuite suivre le lien suivant pour accéder à la documentation swagger : http://localhost:8081/swagger-ui/index.html#/


## Étapes de réalisation

### 1. Création du projet Spring Boot
- Utilisez [Spring Initializr](https://start.spring.io/) pour créer le projet.
- Choisissez la dernière version de Spring Boot disponible (LTS).
- Optez pour **Maven** ou **Gradle** comme outil de gestion de dépendances.
- Ajoutez les dépendances nécessaires : **Spring Web**, **Spring Data JPA**, **H2 Database** .

### 2. Configuration du projet
- Configurez l'application pour qu'elle utilise le port **8081**.
- Donnez un nom (**dice**) au projet dans le fichier de configuration :
- Utilisez **`application.properties`** présent dans /src/main/ressources/.


### 3. Création de la classe `Dice`
- Implémentez une classe représentant un dé avec les méthodes nécessaires pour effectuer un lancé.
- Marquez cette classe avec l'annotation `@Component` pour pouvoir l'injecter au besoin.

#### j'ai créé un répo supplémentaire pour la classe Dice nommé Service.
 - la classe est présente dans /src/main/java/fr.unice.miage.tille.dice/service/Dice.java

### 4. Création de l'entité `DiceRollLog`
- Modélisez une entité JPA `DiceRollLog` comprenant les champs suivants :
  - **`id`** : Identifiant unique.
  - **`diceCount`** : Nombre de dés lancés.
  - **`results`** : Liste ou chaîne des valeurs obtenues. Il existe de nombreuses façons de stocker des valeurs simples (simple String), certaines sont plus élégantes (@ElementCollection) que d'autres, vous pouvez choisir la solution qui vous conviendra.
  - **`timestamp`** : Horodatage du lancé.
- Utilisez des annotations JPA comme `@Entity`, `@Id`, `@GeneratedValue`, etc.

#### j'ai créé un répo supplémentaire pour la classe DiceRollLog nommé entity.
- la classe est présente dans /src/main/java/fr.unice.miage.tille.dice/entity/DiceRollLog.java


### 5. Création du `Repository`
- Implémentez une interface héritant de `JpaRepository<DiceRollLog, Long>` pour gérer les interactions avec la base de données.

#### j'ai ajouté cette interface dans le repo entity.
- l'interface' est présente dans /src/main/java/fr.unice.miage.tille.dice/entity/DiceRollLogRepository.java

### 6. Création du contrôleur REST pour lancer les dés
- Implémentez un contrôleur REST annoté avec `@RestController`.
- Ajoutez les endpoints suivants :
  - **`GET /rollDice`** : Lancer un seul dé.
  - **`GET /rollDices/{X}`** : Lancer X dés (X étant un paramètre dynamique).

#### Pour Tester les lancers d'un seul dé : http://localhost:8081/rollDice
#### Pour Tester les lancers de plusieurs dés : http://localhost:8081/rollDices/{nombre_de_roll}
- exemple : http://localhost:8081/rollDices/5

- j'ai créé un répo supplémentaire pour la classe DiceController nommé controller.
- la classe est présente dans /src/main/java/fr.unice.miage.tille.dice/controller/DiceController.java

### 7. Création du `Service`
- Créez un service marqué avec `@Service` contenant une méthode :
  - Prend en paramètre le nombre de dés à lancer.
  - Retourne les résultats des lancés au contrôleur.
  - Enregistre l’historique des lancés dans la base via le `Repository`.

#### j'ai créé un répo supplémentaire pour la classe DiceService nommé service.
- la classe est présente dans /src/main/java/fr.unice.miage.tille.dice/service/DiceService.java

### 8. Contrôleur pour afficher les historiques
- Ajoutez un autre contrôleur REST permettant d'afficher l'historique des lancés :
  - **`GET /diceLogs`** : Retourne tous les enregistrements de `DiceRollLog` au format JSON.

### 9. Tests et validation
- Démarrez l'application et testez les endpoints.
- Vérifiez les résultats dans la base de données et les réponses JSON.



### 10. (Bonus) Ajout de fonctionnalités avancées
- **Swagger** :
  - Ajoutez la dépendance Swagger/OpenAPI.
  - Configurez Swagger pour documenter vos endpoints.
  - Accédez à la documentation sur **`http://localhost:8081/swagger-ui.html`**.
- **Lombok** :
  - Utilisez Lombok pour simplifier les getters, setters et constructeurs de vos entités.

#### Pour ouvrir la documentation swagger sur un navigateur
http://localhost:8081/swagger-ui/index.html#/



---

## Livrables
- Le code complet du projet, accessible via un dépôt GitHub.
- Un fichier `README.md` décrivant les étapes réalisées

## Technologies
- **Framework principal** : Spring Boot
- **Base de données** : H2 
- **Documentation API** : Swagger (bonus)
- **Simplification de code** : Lombok (bonus)
