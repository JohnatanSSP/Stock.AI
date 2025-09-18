package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.service.ChatGptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

public class StockController {

    private final ChatGptService Service;

    public StockController(ChatGptService Service) {
        this.Service = Service;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateReport(){
        return Service.generateReport();

    }
}
