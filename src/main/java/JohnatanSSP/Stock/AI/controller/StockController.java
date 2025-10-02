package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.DTO.ProductDTO;
import JohnatanSSP.Stock.AI.service.ChatGptService;
import JohnatanSSP.Stock.AI.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class StockController {

    private final ChatGptService chatGptService;
    private  ProductService productService;

    public StockController(ChatGptService chatGptService, ProductService productService) {
        this.chatGptService = chatGptService;
        this.productService = productService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateReport(){
        List<ProductDTO> productModel = productService.showAll();
        return chatGptService.generateReport(productModel)
                .map(report -> ResponseEntity.ok(report))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
