# Stock.AI

Stock.AI é uma aplicação Java Spring Boot que integra **inteligência artificial** (via LangChain4j e OpenAI) para gerar relatórios inteligentes de estoque a partir de listas de produtos enviadas em JSON.

---

## ⚙️ Tecnologias utilizadas

- **Java 21**
- **Spring Boot 3.5.5**
    - Web (`spring-boot-starter-web`)
    - Data JPA (`spring-boot-starter-data-jpa`)
- **H2 Database** (banco em memória/arquivo)
- **Flyway** (gerenciamento de migrações de banco)
- **Lombok** (redução de boilerplate)
- **Reactor / Mono** (reativo, integração com WebFlux opcional)
- **LangChain4j 1.7.1** (integração com OpenAI GPT)
- **Dotenv / Spring-Dotenv** (carregamento de variáveis de ambiente)

---

## 📂 Estrutura do projeto

src/main/java/JohnatanSSP/Stock/AI/
├── controller/
│ └── LangChainController.java # Recebe JSON com lista de produtos e retorna relatório
├── service/
│ └── LangChainService.java # Monta o prompt e chama o LangChain
├── DTO/
│ └── ProductDTO.java # Mapeia cada produto enviado
├── config/
│ └── LangChainConfig.java # Configura OpenAiChatModel
└── StockAiApplication.java # Classe principal Spring Boot


---

## 📝 DTO: `ProductDTO`

```java
@Data
public class ProductDTO {
    private String name;
    private String category;
    private Integer quantity;
    private String validity;
    private Double price;
}
