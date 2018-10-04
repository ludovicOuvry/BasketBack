Besoin d'installer : 
- une BDD, ici MySQL via WAMP voir fichier applications.properties (Besoin de crée la table auparavant)  
- POSTMAN
-Maven
-JAVA
Actuellement la gestion des produits se fait coté back mais on la fera probablement coté Front par la suite.   
techno utilisée REST, Spring , Hibernate BDD ( Mysql)

Commande de compilation : mvn package
Commande de lancement: java -jar .\target\gs-rest-service-0.1.0.jar

Liste fournisseur et montant due : Get http://localhost:8080
ajouter une facture : post http://localhost:8080
Headers content/type application/json  
body  
{  

"name": "a",  
"compagny" : "aaa",  
"price": 10,  
"quantity": 1  
	
} // name optionel   

