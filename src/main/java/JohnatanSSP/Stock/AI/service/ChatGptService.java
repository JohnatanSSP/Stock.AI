package JohnatanSSP.Stock.AI.service;

import JohnatanSSP.Stock.AI.DTO.ProductDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    private final WebClient Client;
    private final String apiKey = System.getenv("OPENAI_API_KEY");

    public ChatGptService(WebClient Client) {
        this.Client = Client;
    }

    public Mono<String> generateReport(List<ProductDTO> Model){

        String stock = Model.stream()
                .map(item -> String.format("%s (%s) - quantidade: %d, Validade: %s",
                        item.getName(),item.getCategory(), item.getQuantity(), item.getValidity(), item.getPrice()))
                .collect(Collectors.joining("\n"));

        String prompt = "quero que voce analise os items que irei fornecer e me faça um relatorio do meu estoque:\n " + stock;

        return Client.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(Map.of(
                        "model", "gpt-4o-mini",
                        "input", prompt
                ))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(json -> {
                    JsonNode textNode = json.path("output")
                            .get(0).path("content").get(0).path("text");
                    return textNode.isMissingNode() ? "não encontramos nenhuma resposta" : textNode.asText();
                        }
                );
    }

}
