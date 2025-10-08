package JohnatanSSP.Stock.AI.DTO;

import JohnatanSSP.Stock.AI.enums.category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDTO {
    // DTO para criar/atualizar
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String image;
    @JsonProperty("category_id")
    private category category;
    private LocalDateTime validity;

}