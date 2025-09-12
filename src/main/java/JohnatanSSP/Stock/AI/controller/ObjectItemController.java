package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.DTO.ObjectDTO;
import JohnatanSSP.Stock.AI.model.ObjectItem;
import JohnatanSSP.Stock.AI.service.ObjectItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class ObjectItemController {

    private final ObjectItemService service;

    public ObjectItemController(ObjectItemService service) {
        this.service = service;
    }

    //get ALL
    @GetMapping
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
    @PostMapping
    public ResponseEntity<String> create(@RequestBody ObjectDTO object){

        ObjectDTO newObject = service.saveObject(object);
        return ResponseEntity.ok("saved");
    }

    //update

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

