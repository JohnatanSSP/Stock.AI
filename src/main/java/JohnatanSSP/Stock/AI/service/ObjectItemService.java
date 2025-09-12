package JohnatanSSP.Stock.AI.service;

import JohnatanSSP.Stock.AI.DTO.ObjectDTO;
import JohnatanSSP.Stock.AI.mapper.ObjectMapper;
import JohnatanSSP.Stock.AI.model.ObjectItem;
import JohnatanSSP.Stock.AI.repository.ObjectItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectItemService {

    private final ObjectItemRepository repository;
    private  final ObjectMapper mapper;

    public ObjectItemService(ObjectMapper mapper, ObjectItemRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }


    public ObjectDTO saveObject(ObjectDTO objectDTO) {
        ObjectItem object = new ObjectMapper().map(objectDTO);
        object = repository.save(object);
        return mapper.map(object);
    }

    public List<ObjectDTO> showAll() {
        return repository.findAll();
    }
    public ObjectDTO showById(Long id) {
        return repository.findById(id);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public ObjectItem update(ObjectItem object) {
        return repository.save(object);
    }

}

