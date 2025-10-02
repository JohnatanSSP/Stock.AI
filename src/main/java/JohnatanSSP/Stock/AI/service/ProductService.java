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

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Autowired
    public ProductService(ProductMapper mapper, ProductRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    // CREATE
    public ProductDTO create(ProductModel product) {
        ProductModel entity = mapper.toEntity(product);
        ProductModel saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    // READ ALL
    public List<ProductDTO> showAll() {
        List<ProductModel> list = repository.findAll();
        return list.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    // READ BY ID
    public ProductDTO showById(Long id) {
        Optional<ProductModel> optional = repository.findById(id);
        return optional.map(mapper::toDTO).orElse(null);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // UPDATE
    public ProductDTO update(Long id, ProductModel dto) {
        Optional<ProductModel> entity = repository.findById(id);

        if (entity.isPresent()) {
            ProductModel updated = mapper.toEntity(dto);
            updated.setId(id);
            repository.save(updated);
            return mapper.toDTO(updated);
        }
        return null;
    }
}

