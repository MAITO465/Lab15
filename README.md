# 🎓 Gestionnaire Scolaire - Android SQLite (CRUD)

Une application Android pédagogique démontrant la mise en place d'une base de données locale avec **SQLite**. Ce projet illustre les opérations fondamentales **CRUD** (Create, Read, Update, Delete) au sein d'une interface moderne en "Dark Mode".

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![SQLite](https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white)

---

## 🎥 Démonstration Vidéo



https://github.com/user-attachments/assets/4feed095-d668-4d99-adf5-5d8ed3a1e605



---

## ✨ Fonctionnalités Implémentées

L'application permet de gérer une base de données locale (`gestion_scolaire.db`) à travers 3 actions principales :

1. 🟢 **Enregistrer un étudiant (Create)**
   - Saisie du Nom et du Prénom.
   - Insertion sécurisée dans la base de données via `ContentValues`.
   - Nettoyage automatique du formulaire et notification (Toast) de succès.

2. 🔵 **Rechercher un étudiant (Read)**
   - Recherche ciblée via l'identifiant unique (`id_etudiant`).
   - Utilisation d'un `Cursor` pour parcourir les résultats de la requête `SELECT`.
   - Affichage dynamique du résultat sur l'interface.

3. 🔴 **Supprimer un étudiant (Delete)**
   - Suppression d'une entrée spécifique dans la base de données à partir de son ID.
   - Vérification préalable de l'existence de l'étudiant pour éviter les erreurs.

---

## 🏗️ Architecture du Projet

Le code est structuré de manière modulaire pour séparer la logique métier de l'interface graphique :

- 📦 **`classes/Etudiant.java`** : Le modèle de données (POJO) représentant l'entité Étudiant.
- 🗄️ **`util/MySQLiteHelper.java`** : Hérite de `SQLiteOpenHelper`. Gère la création de la base de données (`onCreate`) et les mises à jour de version (`onUpgrade`).
- ⚙️ **`service/EtudiantService.java`** : Couche d'abstraction (DAO). Contient toutes les méthodes de requêtes SQL (ajouter, modifier, supprimer, chercher par ID, lister tous).
- 📱 **`MainActivity.java`** : Le contrôleur principal. Lie les actions de l'utilisateur (clics) aux méthodes du service SQLite.
- 🎨 **`res/layout/activity_main.xml`** : Interface utilisateur personnalisée avec un thème sombre (Dark UI) pour un rendu moderne.

---

## 🚀 Installation & Exécution

1. Clonez ce dépôt sur votre machine locale :
   ```bash
   git clone [https://github.com/MAITO465/Lab15.git](https://github.com/MAITO465/Lab15.git)
2. Ouvrez le projet avec Android Studio.
3. Patientez pendant la synchronisation Gradle.
4. Lancez l'application sur un émulateur ou un appareil physique via le bouton Run.
