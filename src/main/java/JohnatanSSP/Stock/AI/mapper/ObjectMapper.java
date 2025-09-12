package JohnatanSSP.Stock.AI.mapper;

import JohnatanSSP.Stock.AI.DTO.ObjectDTO;
import JohnatanSSP.Stock.AI.model.ObjectItem;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {

    // DTO -> Entity
    public ObjectItem toEntity(ObjectDTO dto) {
        if (dto == null) return null;

        ObjectItem obj = new ObjectItem();
        obj.setId(dto.getId());
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
    public ObjectDTO toDTO(ObjectItem obj) {
        if (obj == null) return null;

        ObjectDTO objectDTO = new ObjectDTO();
        objectDTO.setId(obj.getId());
        objectDTO.setName(obj.getName());
        objectDTO.setPrice(obj.getPrice());
        objectDTO.setCategory(obj.getCategory());
        objectDTO.setQuantity(obj.getQuantity());
        objectDTO.setValidity(obj.getValidity());
        objectDTO.setImage(obj.getImage());
        objectDTO.setDescription(obj.getDescription());

        return objectDTO;
    }
}