package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.DTO.ProductDTO;
import JohnatanSSP.Stock.AI.model.ProductModel;
import JohnatanSSP.Stock.AI.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // create
    @PostMapping("/create")
    public ResponseEntity<?> save(@Validated @RequestBody ProductModel product) {
        ProductDTO savedProduct = service.create(product);
        if (savedProduct == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save product");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        }
    }

    //get ALL
    @GetMapping("/show_all")
    public ResponseEntity<List<ProductDTO>> ShowAll(){
        List<ProductDTO> objects = service.showAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(objects);
    }

    //get by ID
    @GetMapping("/id")
    public ResponseEntity<?> showById(@PathVariable Long id){
        ProductDTO object = service.showById(id);
        if (object == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("not found");
        }else{
            return ResponseEntity.ok().body("Found succes");
        }
    }
    //create
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@Validated @RequestBody ProductModel DTO, @PathVariable Long id) {
        ProductDTO updatedObject = service.update(id, DTO);
        return ResponseEntity.ok(updatedObject);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductModel newProduct){

        ProductDTO book = service.update(id, newProduct);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Object not found");
        }else  {
            return ResponseEntity.ok().body("updated successfully");

        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (service.showById(id)!= null) {
            service.delete(id);
            return ResponseEntity.ok("Object deleted"); // 204
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

