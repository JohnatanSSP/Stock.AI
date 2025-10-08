package JohnatanSSP.Stock.AI.service;

import JohnatanSSP.Stock.AI.DTO.ProductDTO;
import dev.langchain4j.model.openai.internal.chat.UserMessage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LangChainService {

    private OpenAiChatModel chatModel;

    public LangChainService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public Mono<String> generateReport(List<ProductDTO> products) {
        String stock = products.stream()
                .map(item -> String.format("%s (%s) - quantidade: %d, validade: %s",
                        item.getName(), item.getCategory(), item.getQuantity(), item.getValidity()))
                .collect(Collectors.joining("\n"));

        String prompt = "Analise o seguinte estoque e gere um relatório:\n" + stock;
        String response = chatModel.chat(prompt);
        return Mono.just(response);
//        return Mono.fromCallable(() -> chatModel.chat(String.valueOf(UserMessage.from(prompt))));
    }
}
