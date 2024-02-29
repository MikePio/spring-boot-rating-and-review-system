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

### STEP 5

Creazione della pagina di dettaglio

- creazione del metodo "detail" nel controller

- creazione della view/pagina di dettaglio per il product (inserito uno script per rendere le righe delle colonne cliccabili)

### STEP 6

Creazione sistema di login e di registrazione con password criptata

1) Registrazione

- il link per il form di registrazione e creata la view con il form di registrazione

- aggiunta la dipendenza per crittografare la password:

```html
  <!-- per installare PasswordEncoder -->
  <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-crypto</artifactId>
    <version>5.7.7</version>
  </dependency>
```

- eseguiti i comandi Maven: `clean` e `install`

- creata una cartella/directory chiamata `config` dove all'interno ho creato un file/la classe `SecurityConfig` in cui con il metodo passwordEncoder faccio ritornare `new BCryptPasswordEncoder()`. 

```java
@Configuration
public class SecurityConfig {
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
```

- creato metodo save nell'AccountService dove all'interno viene utilizzato il metodo `encode` appartenente a PasswordEncoder

```java
  @Autowired
  private PasswordEncoder passwordEncoder;

	public Account save(Account account) {
		// Codifica la password prima di salvarla nel database
		String encodedPassword = passwordEncoder.encode(account.getPassword());

		account.setPassword(encodedPassword);
		
		return accountRepo.save(account);
	}
```

- in AccountController, richiamare con @Autowired PasswordEncoder e creare 2 metodi:

  1. il metodo GET per la pagina di registrazione con un oggetto/account vuoto 

  2. il metodo POST per inviare il form e creare l'oggetto nel db

#### Metodo 1
```java
  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/registration") //! http://localhost:8080/account/registration
  public String registration(Model model){
    // Aggiungi un account vuoto al modello per il form di registrazione
    model.addAttribute("account", new Account());
    return "account-registration";
  }
```
#### Metodo 2

```java
  @PostMapping("/registration") //! http://localhost:8080/account/registration
  public String registration(@ModelAttribute Account account, @RequestParam(required = true) String username, String password, @RequestParam(required = true) String fullName) {
    
    accountService.save(account);

    return "redirect:/products";
  
  }
```

2) Login

- il link per il form di login e creata la view con il form di login

- aggiunto il metodo `findByUsername` nell'AccountRepo

- richiamato `findByUsername` nel AccountService

- in AccountController, richiamare con @Autowired PasswordEncoder e creare 2 metodi:

  1. il metodo GET per la pagina di login con un oggetto/account vuoto 

  2. il metodo POST per inviare il form e verificare che esista un oggetto nel db con lo stesso username e la stessa password (altrimenti ritorna nella pagina di login)

#### Metodo 1

```java
  @GetMapping("/login") //! http://localhost:8080/account/login
  public String login(Model model){
    
    // Aggiungi un account vuoto al modello per il form di login
    model.addAttribute("account", new Account());
    
    return "account-login";
  }
```

#### Metodo 2

```java
  @PostMapping("/login") //! http://localhost:8080/account/login
  public String login(@ModelAttribute("account") Account account) {

    // Cerca l'account nel database utilizzando il nome utente
    Account existingAccount = accountService.findByUsername(account.getUsername());

    // Controlla se l'account esiste e se la password inserita corrisponde a quella memorizzata nel database
    // ! VISTO CHE LA PASSWORD è CRIPTATA SI UTILIZZA matches` PER VERIFICARE SE è UGUALE O MENO (E NON equals)
    if (existingAccount != null && passwordEncoder.matches(account.getPassword(), existingAccount.getPassword())) {
      // Login riuscito
      return "redirect:/products";
    } else {
      // Login fallito, reindirizza al form di login con un messaggio di errore
      return "redirect:/account/login?error";
    }
  }
```

### STEP 7

Aggiungere la funzionalità di creazione delle recensioni nella pagina di dettaglio quando l'utente è loggato



> **!!! ATTENZIONE !!!**
>
> **In basso ci sono tutti i passaggi del video ma nello svolgimento del mio progetto sono stati effettuati dei passaggi differenti ed implementate alcune soluzioni differenti da quelle presenti nel video.**
>
> **!!!**


### Recap video:

##### 4:06 Inizio esercizio concreto - creazione delle entities/dei model
##### 5:07-5:24 mostra le tabelle del db (è possibile vedere le chiavi secondarie (/ colonne delle many-to-many o one-to-many) che si trovano all'interno delle tabelle in modo da capire le relazioni tra le tabelle cioè many-to-many o one-to-many)
##### 5:46 creazione dei repository
##### 6:09 compilazione della repo Product
##### 8:00 creazione dei services
##### 12:34 creazione del controller Product
##### 14:46 creazione file della view (usando jsp)
##### 14:59 stampa degli oggetti nella view (pagina index)
##### 18:57 creazione del metodo "detail" nel controller
##### 19:35 creazione e compilazione della view/pagina di dettaglio per il product
##### 22:22 inserimento di css
##### 23:57 creazione sistema login e registrazione
##### 25:12 creazione del controller per l'account con il metodo GET di login
##### 26:17 creazione del form per il login
##### 29:49 fixato bug per mostrare i link di login e di registrazione
##### 30:46 creazione del metodo GET di registrazione nel controller dell'account
##### 31:47 creazione del form per la registrazione
##### 33:53 creazione del metodo POST di registrazione nel controller dell'account
##### 35:33 aggiunto il metodo findByUsernameAndPassword nella repo dell'account e metodo di login nel service
##### 36:28  creazione del metodo POST di login nel controller dell'account
##### 41:15 creazione del form nella pagina di dettaglio per far inserire la recensione del prodotto all'utente che ha fatto il login
##### 46:33 creazione del metodo POST nel controller del prodotto per inviare/creare la review/recensione al db
##### 48:55 aggiunto il metodo FindByUsername nella repo dell'account e successivamente al service dell'account 
##### 50:23 continuazione del metodo POST nel controller del prodotto per inviare/creare la review/recensione al db
##### 50:35 creazione del service e della repo per le review/recensioni (aggiunti i metodi save)
##### 52:38 completato il metodo POST nel controller del prodotto per inviare/creare la review/recensione al db
##### 54:38-56:08 mostra in pagina le recensioni inserite cioè quelle presenti nel db  
##### 56:35 mostra in pagina le stelle per le recensioni inserite cioè quelle presenti nel db  
##### FINE😊