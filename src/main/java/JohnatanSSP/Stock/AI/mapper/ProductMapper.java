package JohnatanSSP.Stock.AI.mapper;

import JohnatanSSP.Stock.AI.DTO.ProductDTO;
import JohnatanSSP.Stock.AI.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // DTO -> Entity
    public ProductModel toEntity(ProductModel dto) {
        if (dto == null) return null;

        ProductModel obj = new ProductModel();
        obj.setName(dto.getName());
        obj.setPrice(dto.getPrice());
        obj.setCategory(dto.getCategory());
        obj.setQuantity(dto.getQuantity());
        obj.setValidity(dto.getValidity());
        obj.setImage(dto.getImage());
        obj.setDescription(dto.getDescription());
        return obj;
    }

    // Entity -> DTO
    public ProductDTO toDTO(ProductModel obj) {
        if (obj == null) return null;

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(obj.getName());
        productDTO.setPrice(obj.getPrice());
        productDTO.setCategory(obj.getCategory());
        productDTO.setQuantity(obj.getQuantity());
        productDTO.setValidity(obj.getValidity());
        productDTO.setImage(obj.getImage());
        productDTO.setDescription(obj.getDescription());

        return productDTO;
    }
}