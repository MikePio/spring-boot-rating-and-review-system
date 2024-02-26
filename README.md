# Rating And Review System in Spring Boot

### `Progetto ispirato da `[Build Rating and Review System with Spring MVC and Spring Data JPA in Spring Boot](https://www.youtube.com/watch?v=3geqxSMpU0o)

### STEP 1 - Creazione e setup del progetto

Progetto Spring Boot:

* Maven
* Spring Boot: 3.2.2
* Java: 17
* Packaging: Jar

Creare un progetto con le seguenti dipendenze:

* Spring Data JPA
* MySQL Driver
* Spring Web
* Spring Boot DevTools

Creare un db su DBeaver

Collegare il progetto con il db nel file application.properties `src\main\resources\application.properties`

Implementare il CommandLineRunner sotto @SpringBootApplication

### STEP 2

Creare le entities cioè i model / le tabelle del db

Creare le relazioni tra le varie entities/tabelle cioè many-to-many e/o one-to-many:

1) relazione one-to-many tra prodotto e recensione
2) relazione one-to-many tra account e recensione

Creare i services e le repositories per ogni entity 

Controllare se le tabelle sono state create nel db (NON IMPORTA SE COMPARE L'ERRORE "Whitelabel Error Page" SUL BROWSER NEL LOCALHOST/SITO http://localhost:8080/ è tutto normale perché non è stato configurato un controller e una vista)

### STEP 3

Salvare dei dati fittizi nel db per verificarne il funzionamento delle tabelle e delle relazioni

- Aggiungere il metodo save nel service

- Aggiungere i dati fittizi nel file Application e richiamati i metodi save del service per salvare i dati nel db

### STEP 4

Creare i controller e le view che mostrano gli oggetti(es. prodotti) 

- importare la dipendenza thymeleaf in pom.xml

- creare il/i controller

- creare una view (file html che mostra i dati degli oggetti)

- richiamare i metodi del service (che provengono dalla repo ma modificati con una logica) per gestire i dati nel controller ed infine restituire la view con una rotta

- stampare nella view l'oggetto utilizzando thymeleaf

- aggiunta barra di ricerca per cercare gli oggetti(i prodotti in questo caso) in base al name



Recap video:

##### 4:06 Inizio esercizio concreto - creazione delle entities/dei model
##### 5:07-5:24 mostra le tabelle del db (è possibile vedere le chiavi secondarie (/ colonne delle many-to-many o one-to-many) che si trovano all'interno delle tabelle in modo da capire le relazioni tra le tabelle cioè many-to-many o one-to-many)
##### 5:46 creazione dei repository
##### 6:09 compilazione della repo Product
##### 8:00 creazione dei services
##### 12:34 creazione dei controller
##### 14:46 creazione della view
##### 
##### 
##### 
##### 



















