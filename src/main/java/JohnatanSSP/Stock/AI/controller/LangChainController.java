package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.DTO.ProductDTO;
import JohnatanSSP.Stock.AI.service.LangChainService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/langchain")
public class LangChainController {

    private final LangChainService langChainService;

    public LangChainController(LangChainService langChainService) {
        this.langChainService = langChainService;
    }

    /**
     * Gera um relatório do estoque com base em uma lista de produtos.
     * Exemplo de requisição:
     * POST /langchain/report
     * Body: [
     *   {"name":"Arroz","category":"Alimentos","quantity":10,"validity":"2025-12-31"},
     *   {"name":"Feijão","category":"Alimentos","quantity":5,"validity":"2025-11-20"}
     * ]
     */
    @GetMapping(value = "/report", consumes = "application/json", produces = "application/json")
    public Mono<String> generateReport(@RequestBody List<ProductDTO> products) {
        return langChainService.generateReport(products);
    }
}
