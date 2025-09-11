package JohnatanSSP.Stock.AI.service;

import JohnatanSSP.Stock.AI.model.ObjectItem;
import JohnatanSSP.Stock.AI.repository.ObjectItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectItemService {

    private ObjectItemRepository Repository;

    public ObjectItemService(ObjectItemRepository repository) {
        Repository = repository;
    }

    public ObjectItem saveObject(ObjectItem object) {
        return Repository.save(object);
    }

    public List<ObjectItem> showAll(ObjectItem object) {
        return Repository.showAll();
    }
    public ObjectItem showById(Long id) {
        return Repository.showById(id);
    }
}

