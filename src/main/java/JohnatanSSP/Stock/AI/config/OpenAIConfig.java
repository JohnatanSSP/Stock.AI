package JohnatanSSP.Stock.AI.config;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        return OpenAiChatModel.builder()
                .apiKey("SUA_CHAVE_AQUI")
                .modelName("gpt-3.5-turbo") // ou outro disponível
                .build();
    }
}

