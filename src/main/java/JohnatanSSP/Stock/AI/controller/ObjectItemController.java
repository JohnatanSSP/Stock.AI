package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.DTO.ObjectDTO;
import JohnatanSSP.Stock.AI.model.ObjectItem;
import JohnatanSSP.Stock.AI.service.ObjectItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class ObjectItemController {

    private final ObjectItemService service;

    public ObjectItemController(ObjectItemService service) {
        this.service = service;
    }

    //get ALL
    @GetMapping("/show_all")
    public ResponseEntity<List<ObjectDTO>> ShowAll(){
        List<ObjectDTO> objects = service.showAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(objects);
    }

    //get by ID
    @GetMapping("/id")
    public ResponseEntity<?> showById(@PathVariable Long id){
        ObjectDTO object = service.showById(id);
        if (object == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("not found");
        }else{
            return ResponseEntity.ok().body("Found succes");
        }
    }
    //create
    @PutMapping("/{id}")
    public ResponseEntity<ObjectDTO> update(@Validated @RequestBody ObjectDTO DTO, @PathVariable Long id) {
        ObjectDTO updatedObject = service.update(id, DTO);
        return ResponseEntity.ok(updatedObject);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ObjectDTO newBook){

        ObjectDTO book = service.update(id, newBook);
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

