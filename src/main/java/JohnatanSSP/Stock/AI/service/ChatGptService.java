package JohnatanSSP.Stock.AI.service;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class ChatGptService {

    private final WebClient webClient;
    private String apiKey = System.getenv("API_KEY");

    public ChatGptService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generateReport(){
        String prompt = "quero que voce analise os items que irei fornecer e me faça um relatorio do meu estoque";
        Map<String, Object> requestBody = Map.of(
                "model", "gpt-5-nano",
                "messages", List.of(
                        Map.of("role","system","content","voce e um analista de estoque e cria relatorios"),
                        Map.of("role","user", "content", prompt)
                )
        );
        return webClient.post()
                .header(HttpHandler.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHandler.AUTHORIZATION, "Bearer" + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if(choices != null && !choices.isEmpty()){
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "não foi possivel realizar";
                });
    }

}
