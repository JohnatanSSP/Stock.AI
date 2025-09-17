package JohnatanSSP.Stock.AI.DTO;

import JohnatanSSP.Stock.AI.enums.category;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

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

    public ProductDTO(LocalDateTime validity, category category, String image, Integer quantity, Double price, String description, String name, Long id) {
        this.validity = validity;
        this.category = category;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public LocalDateTime getValidity() {
        return validity;
    }

    public void setValidity(LocalDateTime validity) {
        this.validity = validity;
    }
}
