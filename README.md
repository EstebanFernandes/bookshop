Examen d'architecture Logicielle, projet rendu par BENABBOU Douae et FERNANDES Esteban

Fait :
-prix affiché via l'api exchange rate
-Mapping des objets avec open library
-API Rest
-Le readme 
Pas fait:
-Affichage des informations supplémentaires
-Clé api dans un fichier à part


Route API :

http://localhost:8080/bookshop/api/v1/books 

Méthode GET récupérer tous les livres (on peut filtrer par auteur et titre avec des queryparam)
Méthode POST avec l'authorisation 42 on peut ajouter un livre

http://localhost:8080/bookshop/api/v1/books/n
Méthode GET Retourne le livre avec l'id correspondant
Méthode PUT Update le livre, nécessite l'authorisation
Méthode PATCH update les paramètres passés, nécessite l'authorisation 
Méthode DELETE nécessite l'autorisation, supprime le livre avec l'id n 