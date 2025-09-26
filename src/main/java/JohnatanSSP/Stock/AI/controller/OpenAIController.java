package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.DTO.mensageDTO;
import JohnatanSSP.Stock.AI.model.ProductModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OpenAIController {

    ChatLanguageModel Model;

    Environment env;

    public OpenAIController(ChatLanguageModel model, Environment env) {
        Model = model;
        this.env = env;
    }

    @PostMapping("/chat")
    public String sendPrompt(@RequestBody mensageDTO message){
        return Model.generate(message.message());
    }
    @GetMapping("/template")
    public String conversarComGPT4Template(@RequestBody mensageDTO message) {
        PromptTemplate template = PromptTemplate.from(
                "Você é um programador Java. Você deve responder a pergunta: {{question}}"
        );

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("question", message.message());

        Prompt prompt = template.apply(mapa);
        return Model.generate(prompt.text());
    }
}
