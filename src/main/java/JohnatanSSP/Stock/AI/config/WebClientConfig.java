package JohnatanSSP.Stock.AI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private String ChatGptUrl = System.getenv("OPENAI_API_KEY");

    @Bean
    public WebClient webClient( WebClient.Builder builder) {
        return builder.baseUrl(ChatGptUrl).build();
    }
}