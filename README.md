# Kids Land Park project

## Explication base de données

3 DB: Tickets, Ride, Personne

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


## Mode de représentation des données :

Tout d'abord, pour pouvoir utiliser le JFreeChart, nous incluons en amont les fichier 'jcommon-1.0.0.jar' et 'jfreechart-1.0.1.jar' à nos libraries.


## Librairies pour l'affichage des dates : 

    - JDatePicker
    - https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
