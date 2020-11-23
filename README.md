# Project-Databases

Pour le pattern MVC, j'ai essayé de classer les classes dans les packages Controller, View et Model mais je suis pas sûr de moi, donc hésitez pas à le dire si vous pensez différemment 


Pour les DB : 3 DB :

- La DB Tickets : 4 attributs
    - Id_tickets : identifiant du ticket -> Clé Primaire
    - Ride : une attraction : référence une attraction de la DB "Attraction" : Clé Étrangère -> Un ticket ne correspond qu'à une seule attraction
    - Date : une date de type Date 
    - Personne : une personne : référence à une personne de la DB "Personne" : Clé Étrangère -> Un ticket appartient a une seule et unique personne

- La DB Ride : 3 attributs :
    - name_Ride : le nom de l'attraction -> Clé Primaire
    - Price : le prix de l'attraction 
    - features : les caractéristiques de l'attraction : type String

- La DB Personne : 4 attributs (5ème pas sûr):
    - name : le nom de la personne -> Clé Primaire
    - age : l'âge de la personne
    - login : le login de la personne si elle en a un
    - type : le type de la personne : E pour Employé, MC pour MemberCustomer et GC pour GestCustomer
    - memberType : si la personne est un MemberCustomer, il a un type : regular, senior ou child

-> Cette DB sera modifié au fur et à mesure, dès qu'un GuestCustomer achétera des tickets, il sera référencé dans la DB personne sous le type "GC"

Remarques : 

    - Le nombre de tickets maximum disponible pour UNE DATE et pour UNE ATTRACTION ne se gère uniquement dans le code JAVA, pas dans les DB
    - Pour gérer les dates, on peut gérer seulement un semestre (3-4 mois) et donc faire un tableau de toutes les dates sur cette période. Si il faut gérer une année entière -> peut-être réfléchir à une autre solution


Step à suivre pour l'application (je le vois comme ça, mais dites le si vous voyez ça autrement !): 

-	On demande à l’utilisateur s’il a un login 
o	Si oui : il rentre le login
o	Si non : c’est un guestCustomer

-	Si l’utilisateur rentre son login, on regarde dans la DB « Personne » si le login existe :
o	Si il existe : on regarde si le login en question correspond à un Employé ou à un MemberCustomer (regarder le type : E ou MC)
o	Si il n'existe pas -> la personne n'est pas référencé dans la DB, on lui demande de resaisir son login ou de se connecter en tant que GuestCustomer

- Pour un Customer : 

    - Il devra d'abord sélectionner une date DISPONIBLE 
    - Les attractions disponibles pour cette date s'affichent
    - Il sélectionne une attraction
    - Il indique le nombre de tickets qu'il souhaite
    - Il valide la commande
    - Si c'est un Membre, la réduction s'applique

    En back : 
    - Quand la commande est validé, on rempli la liste de tickets dans la classe Date et dans la classe Ride -> quand la liste de tickets de la classe Ride est rempli au max -> l'attraction devient indisponible pour la date en question. Idem, si la liste de ticket de la classe Date est rempli au max -> la date devient indisponible 

- Pour un Employee : Réfléchir à comment faire les points ci-dessous : 

    - Pas mal de possibilités : 
        - Modifier la disponibilité d'une attraction
        - Créer des promotions (disponible pour tous les customers ? Juste les membres ? Juste les guest ?)
        - Avoir accès aux dossiers des clients (MemberCustomer ?) -> avoir accès à la DB
        - Définir les attractions les + populaires


Librairies pour l'affichage des dates : 

    - JDatePicker
    - https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
    