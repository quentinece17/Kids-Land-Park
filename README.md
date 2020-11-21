# Project-Databases

Pour le pattern MVC, j'ai essayé de classer les classes dans les packages Controller, View et Model mais je suis pas sûr de moi, donc hésitez pas à le dire si vous pensez différemment 

Pour la DB qui stocke les commandes - Plusieurs possibilités :

- On stocke les tickets : un ticket a une date, une attraction, et il est attribué a une personne -> dans ce cas il faut rajouter des attributs a la classe Ticket

- On stocke les dates : À x date, on a un certain nombre de tickets réservé, dans ce cas le ticket a une attraction et est attribué à une personne, mais il n'a plus de date (c'est l'inverse)

- Je pense qu'il faut réfléchir aux liens entre les DB (foreign key) "Personne" et celle qui stocke les commandes, genre la DB ticket a une foreign key qui référence une personne par exemple ça peut être pas mal.
Par contre si on fait ça, il faut réfléchir a comment référencer une personne si c'est un GuestCustomer car la personne en question ne sera pas référencé dans une DB. Une solution pourraît être que dès qu'un guestCustomer passe une commande, on stocke ses infos dans une DB "GustCustomer" -> genre on construit la DB au fur et à mesure, pas comme les autres qui seront préalablement construites. 


Step à suivre pour l'application (je le vois comme ça, mais dites le si vous voyez ça autrement !): 

-	On demande à l’utilisateur s’il a un login 
o	Si oui : il rentre le login
o	Si non : c’est un guestCustomer

-	Si l’utilisateur rentre son login, on regarde dans la DB « Employee » s’il s’y trouve :
o	Si il s’y trouve : c’est un employé, il peut donc avoir accès à la DB qui gère les commandes
o	Si il ne s’y trouve pas -> on vérifie dans la DB « MemberCustomer » pour être sur

-	Si ce n’est pas un employé et qu’il se trouve dans la DB « MemberCustomer » -> c’est un MemberGuest ; Si il ne s’y trouve pas -> erreur : il faut ressaisir le login ou alors c’est un GuestCustomer

- Pour un Customer : 

    - Il devra d'abord sélectionner une date DISPONIBLE 
    - Les attractions disponibles pour cette date s'affichent
    - Il sélectionne une attraction
    - Il indique le nombre de tickets qu'il souhaite
    - Il valide la commande
    - Si c'est un Membre, la réduction s'applique

    En back : 
    - Quand la commande est validé, on rempli la liste de tickets dans la classe date et dans la classe   attraction -> quand la liste de tickets de la classe Attraction est rempli au max -> l'attraction devient indisponible pour la date en question. Idem, si la liste de ticket de la classe Date est rempli au max -> la date devient indisponible 

- Pour un Employee : Réfléchir à comment faire les points ci-dessous : 

    - Pas mal de possibilités : 
        - Modifier la disponibilité d'une attraction
        - Créer des promotions (disponible pour tous les customers ? Juste les membres ? Juste les guest ?)
        - Avoir accès aux dossiers des clients (MemberCustomer ?) -> avoir accès à la DB
        - Définir les attractions les + populaires

Interrogation :

- Les attributs mis dans date ne devraient peut-être pas y être ? Je me demande si ça ne devraient pas juste être dans la DB ? 
D'ailleurs, comment on gère toutes les dates ? Difficile de toutes les créer pour une année entière...

    


