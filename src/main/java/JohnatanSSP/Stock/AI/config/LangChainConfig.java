package JohnatanSSP.Stock.AI.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel; // depende da implementação que quer usar
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LangChainConfig {

    @Value("${langchain4j.open-ai.moderation-model.api-key}")
    private String apiKey;


    @Bean
    public ChatModel chatModel() {
        return OpenAiChatModel.builder()
                .apiKey(apiKey) // ou ler do application.properties
                .modelName("gpt-4o-mini")
                .build();
    }
}
