# Project-Databases

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


## Mode de représentaiton des données :

Tout d'abord, pour pouvoir utiliser le JFreeChart, nous incluons en amont les fichier 'jcommon-1.0.0.jar' et 'jfreechart-1.0.1.jar' à nos libraries.


## Librairies pour l'affichage des dates : 

    - JDatePicker
    - https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component


## Script SQL

- create database KidsLand;
- use KidsLand;

- Pour la DB Personne : 

    - create table Personne (user_id INT AUTO_INCREMENT, user_name VARCHAR(20), user_age INT, user_pseudo VARCHAR(20), user_login VARCHAR(20), user_type VARCHAR(10), member_type VARCHAR(10), PRIMARY KEY (user_id));

    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type, image) values ("Jerome Davido", 42, "jdavido@gmail.com", "jdavido", "MC", "regular", "C:\Users\\lonyf\\OneDrive\\Documents\\ECE 2020\\Project-Databases\\Application\\Images\\Personnes\\Member_Homme.jpg");`
    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type, image) values ("Stéphanie Durand", 37, "sdurand@gmail.com", "sdurand", "E", "NULL", "C:\Users\\lonyf\\OneDrive\\Documents\\ECE 2020\\Project-Databases\\Application\\Images\\Personnes\\Employee_Homme.jpg");
    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type, image) values ("Véronique Rivaud", 40, "NULL", "NULL", "GC", "NULL", "C:\Users\\lonyf\\OneDrive\\Documents\\ECE 2020\\Project-Databases\\Application\\Images\\Personnes\\Guest_Femme.jpg");
    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type, image) values ("Clémence Dirma", 70, "NULL", "NULL", "GC", "NULL", "C:\Users\\lonyf\\OneDrive\\Documents\\ECE 2020\\Project-Databases\\Application\\Images\\Personnes\\Guest_Femme.jpg");
    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type, image) values ("Jérémy Pied", 78, "NULL", "NULL", "GC", "NULL", "C:\Users\\lonyf\\OneDrive\\Documents\\ECE 2020\\Project-Databases\\Application\\Images\\Personnes\\Member_Homme.jpg");`
    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type, image) values ("Yusuf Yazici", 28, "yyazici@gmail.com", "yyazici", "MC", "regular", "C:\Users\\lonyf\\OneDrive\\Documents\\ECE 2020\\Project-Databases\\Application\\Images\\Personnes\\Member_Homme.jpg");
    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type, image) values ("Janette During", 69, "janeo2@yahoo.fr", "januil2", "MC", "senior", "C:\Users\\lonyf\\OneDrive\\Documents\\ECE 2020\\Project-Databases\\Application\\Images\\Personnes\\Guest_Femme.jpg");
    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type, image) values ("Clémence Dirma", 70, "NULL", "NULL", "GC", "NULL", "C:\Users\\lonyf\\OneDrive\\Documents\\ECE 2020\\Project-Databases\\Application\\Images\\Personnes\\Guest_Femme.jpg");


    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type) values ("Marie Clair", 24, "clair_marie24", "clair24", "MC", "regular");

    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type) values ("Esteban Letalec", 17, "letalec_esteban17", "letalec17", "MC", "children");

    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type) values ("Jean-Pierre Foumeau", 66, "fourmeau_jp66", "foumeau66", "MC", "senior");

    - insert into Personne (user_name, user_age, user_pseudo, user_login, user_type,member_type) values ("Fabien Bartez", 44, "bartez_fabien44", "bartez44", "E", "X");

- Pour la DB Ride :

    - create table Ride (id_ride INT AUTO_INCREMENT, name_ride VARCHAR(20), price_ride DOUBLE, features_ride VARCHAR(300), max_tickets INT ,PRIMARY KEY (id_ride));

    - insert into Ride (name_ride, price_ride, features_ride, max_tickets) values ("SpeedLand Express", 6.75,"Extreme speed, not recommended for shy people. Strong sensations guaranteed. Forbidden for less than 1m50", 16);

    -  insert into Ride (name_ride, price_ride, features_ride, max_tickets) values ("AquaImmersion", 4.5,"Get ready to be soaked! Accessible to everyone. Average speed", 14);

    - insert into Ride (name_ride, price_ride, features_ride, max_tickets) values ("GhostTerror", 5,"Don’t be afraid! Thrills guaranteed in this ghost train. Very dark ride", 20);

    - insert into Ride (name_ride, price_ride, features_ride, max_tickets) values ("FlyingChairs",4,"Find the famous flying chairs in this ride for children. Average flying height", 14);

    - insert into Ride (name_ride, price_ride, features_ride, max_tickets) values ("ExtremeLand", 7,"The most extreme attraction of the park! Maximum speed of 100km/h. Several looping and very big thrills. Prohibited under 1m60", 18);

    - insert into Ride (name_ride, price_ride, features_ride, max_tickets) values ("Giga Bumper-car", 5.5,"Giga bumper car for any level! Session duration: 3 minutes", 25);

- Pour la DB Tickets :

    - create table Tickets (id_ticket INT AUTO_INCREMENT, ride_ticket INT, user_ticket INT, date_ticket Date, PRIMARY KEY (id_ticket), CONSTRAINT fk_ride_id FOREIGN KEY (ride_ticket) REFERENCES Ride(id_ride), CONSTRAINT fk_user_id FOREIGN KEY (user_ticket) REFERENCES Personne(user_id));

    - insert into Tickets (ride_ticket, user_ticket, date_ticket) values (2, 5, NOW());



create table Command (id_command INT AUTO_INCREMENT, ride_command INT, user_command INT, adult_ticket INT, child_ticket INT, date_command Date, date_purchase Date, PRIMARY KEY (id_command), CONSTRAINT fk_ride_id FOREIGN KEY (ride_command) REFERENCES Ride(id_ride), CONSTRAINT fk_user_id FOREIGN KEY (user_command) REFERENCES Personne(user_id));

