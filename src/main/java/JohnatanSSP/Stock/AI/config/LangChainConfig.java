package JohnatanSSP.Stock.AI.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LangChainConfig {

    @Bean
    public ChatModel chatModel() {
        return (ChatModel) OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY")) // ou via @Value
                .modelName("gpt-4o-mini") // ou outro modelo suportado
                .build();
    }
}