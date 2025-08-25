# Webservices – Lektion 4  
**Ämne:** Dynamiska Endpoints  

---

## **Recap**

### **Webservices**
- Kan kommunicera med olika OS och språk, är inte begränsad  
- Designade för interaktion mellan maskin och applikation  
- **Bör** vara tillgängliga över nätverk (internet)  

---

### **Node.js**
- Bidrar med terminalredskap (kommandon)

---

### **MongoDB**
- Flexibelt  
- Kan läggas till som dependency tillsammans med Spring  

---

### **Spring Boot**

#### **`@SpringBootApplication`**
- Annotering  
- Innehåller all information om projektet  
- Kommer med `@SpringBootConfiguration`  
- Startpunkt för applikationen  
- Här byggs applikationen  

#### **`@ComponentScan`**
- Inkluderar filter  
- Scannar projektet efter annotationer (beans) som:  
  - `@Component`, `@Service`, `@RestController`, `@Bean`, m.m.  

#### **Beans**
- Objekt som hanteras av Spring  

---

## **Dynamiska `/endpoints`**

### **Vad är en endpoint?**
Exempel:
https://localhost:1234/hrservices/v1/users

- **https://** → HyperText Transfer Protocol (Secure)  
- **localhost:** → Domännamn  
- **1234** → Port  
- **/hrservices** → Application context  
- **/v1** → Version  
- **/users** → Resurs  
- **/{id}** → Parameter  

---

### **RequestMapping vs GetMapping**
- `@RequestMapping` → Används på **klassnivå**  
- `@GetMapping` → Används på **metodnivå**  
- Det som sätts överst appliceras på det som ligger under  
- `@RequestMapping` hanterar t.ex. `/user`, då behöver `@GetMapping` bara hantera `/id` och inte hela vägen `/user/id`  
- Mappings används för att hantera requests via olika HTTP-metoder (GET, POST, PUT, DELETE)  

---

### **Reactive Web – WebFlux**
- Springs asynkrona webbmodell  
- Returtyper:  
  - `Mono<T>` → Ett enda objekt/värde  
  - `Flux<T>` → En ström av flera värden  

---

## **@RestController vs @Controller**
- `@RestController` → Innehåller `@Controller` och `@ResponseBody`  
- `@Controller` → Specialiserad `@Component` för classpath-scanning och mappings  
- `@Component` → Gör det möjligt att använda olika stereotyp-annotationer och aktiverar classpath-scanning  
- `@ResponseBody` → Returnerar resultat (JSON/HTML) direkt i svaret  

---

## **@PathVariable vs @RequestParam**
- `@PathVariable` → Dynamiskt värde i URL:en, **krävs** för att endpointen ska fungera  
- `@RequestParam` → Används för **frivilliga** värden i förfrågningar  
