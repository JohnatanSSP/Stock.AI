package JohnatanSSP.Stock.AI.controller;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.web.bind.annotation.*;
import dev.langchain4j.model.openai.OpenAiChatModel; // depende da implementação que quer usar
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@RestController
@RequestMapping("/langchain-openai")
public class LangChainController {

    ChatModel chatModel;
    public LangChainController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping
    public String reportLangChain(@RequestBody String product){
        return chatModel.chat(product);
    }

}
