package JohnatanSSP.Stock.AI.service;

import JohnatanSSP.Stock.AI.DTO.ProductDTO;
import JohnatanSSP.Stock.AI.mapper.ProductMapper;
import JohnatanSSP.Stock.AI.model.ProductModel;
import JohnatanSSP.Stock.AI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository repository;
    @Autowired
    private final ProductMapper mapper;

    public ProductService(ProductMapper mapper, ProductRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }



//    public ObjectDTO saveObject(ObjectDTO objectDTO) {
//        ObjectItem object = mapper.toEntity(objectDTO);
//        object = repository.save(object);
//        return mapper.toDTO(object);
//    }
//
    public ProductDTO create(ProductDTO productDTO){
        ProductModel object = new ProductModel();
        object = repository.save(object);
        return mapper.toDTO(object);
    }

    public List<ProductDTO> showAll() {
        List<ProductModel> objects = repository.findAll();
        return objects.stream()
                .map(object -> mapper.toDTO(object))
                .collect(Collectors.toList());
    }

    public ProductDTO showById(Long id) {
        Optional<ProductModel> object = repository.findById(id);
        return mapper.toDTO(object.get());
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public ProductDTO update(Long id, ProductDTO object) {
        Optional<ProductModel> objectItem = repository.findById(id);
        if(objectItem.isPresent()){
            ProductModel newObject = mapper.toEntity(object);
            newObject.setId(id);
            ProductModel updatedObject = repository.save(newObject);
            return mapper.toDTO(updatedObject);
        }
        return null;
    }

}

