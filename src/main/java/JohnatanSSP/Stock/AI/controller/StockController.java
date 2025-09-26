package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.service.ChatGptService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Data
@RestController
public class StockController {

    private final ChatGptService Service;

    public StockController(ChatGptService Service) {
        this.Service = Service;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateReport(){
        return Service.generateReport()
                .map(report -> ResponseEntity.ok(report))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
