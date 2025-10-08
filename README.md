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

src/main/java/JohnatanSSP/Stock/AI/
├── controller/
│
│   └── LangChainController.java
│
│       └─ Responsável por expor os endpoints da API.
│
│          Recebe JSON com lista de produtos, envia para o serviço e retorna
│          o relatório gerado pela IA.
├── service/
│
│   └── LangChainService.java
│
│       └─ Contém a lógica de negócio relacionada ao LangChain.
│
│          Monta o prompt com os produtos recebidos e chama o modelo
│          OpenAI para gerar o relatório.
├── DTO/
│
│   └── ProductDTO.java
│
│       └─ Data Transfer Object que representa cada produto.
│
│          Contém campos como name, category, quantity, validity e price.
├── config/
│
│   └── LangChainConfig.java
│
│       └─ Configuração do bean OpenAiChatModel para integração
│
│          com o OpenAI GPT. Define API key, modelo e temperatura.
└── StockAiApplication.java
│
│    └─ Classe principal do Spring Boot. Inicializa a aplicação
│    │
│       e configura o contexto do Spring.
│


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
