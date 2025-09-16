package JohnatanSSP.Stock.AI.model;

import JohnatanSSP.Stock.AI.enums.category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table( name = "tb_objects")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String image;
    private category category;
    private LocalDateTime validity;

}
