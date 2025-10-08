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
                .map(item -> String.format(
                        item.getName(),item.getDescription(), item.getQuantity()))
                .collect(Collectors.joining("\n"));

        String prompt = "quero que voce analise o meu estoque...\n " + stock;
        prompt = prompt.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        return Client.post()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer" + apiKey)
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
