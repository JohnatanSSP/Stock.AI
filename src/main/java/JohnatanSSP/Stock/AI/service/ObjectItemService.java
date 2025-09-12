package JohnatanSSP.Stock.AI.service;

import JohnatanSSP.Stock.AI.DTO.ObjectDTO;
import JohnatanSSP.Stock.AI.mapper.ObjectMapper;
import JohnatanSSP.Stock.AI.model.ObjectItem;
import JohnatanSSP.Stock.AI.repository.ObjectItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjectItemService {

    @Autowired
    private final ObjectItemRepository repository;
    @Autowired
    private final ObjectMapper mapper;

    public ObjectItemService(ObjectMapper mapper, ObjectItemRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }



//    public ObjectDTO saveObject(ObjectDTO objectDTO) {
//        ObjectItem object = mapper.toEntity(objectDTO);
//        object = repository.save(object);
//        return mapper.toDTO(object);
//    }
//
    public ObjectDTO create(ObjectDTO objectDTO){
        ObjectItem object = new ObjectItem();
        object = repository.save(object);
        return mapper.toDTO(object);
    }

    public List<ObjectDTO> showAll() {
        List<ObjectItem> objects = repository.findAll();
        return objects.stream()
                .map(object -> mapper.toDTO(object))
                .collect(Collectors.toList());
    }

    public ObjectDTO showById(Long id) {
        Optional<ObjectItem> object = repository.findById(id);
        return mapper.toDTO(object.get());
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public ObjectDTO update(Long id,ObjectDTO object) {
        Optional<ObjectItem> objectItem = repository.findById(id);
        if(objectItem.isPresent()){
            ObjectItem newObject = mapper.toEntity(object);
            newObject.setId(id);
            ObjectItem updatedObject = repository.save(newObject);
            return mapper.toDTO(updatedObject);
        }
        return null;
    }

}

