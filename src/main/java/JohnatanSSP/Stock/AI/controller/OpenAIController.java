package JohnatanSSP.Stock.AI.controller;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class OpenAIController {

    ChatModel chatModel;

    public OpenAIController(ChatModel chatModel){
        this.chatModel = chatModel;
    }

    @GetMapping
    public String chat(@RequestParam String message){
    return chatModel.chat(message);
    }
    
}
