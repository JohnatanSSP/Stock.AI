package JohnatanSSP.Stock.AI.DTO;

import JohnatanSSP.Stock.AI.enums.category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    // DTO para criar/atualizar
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String image;
    private category category;
    private LocalDateTime validity;

}
