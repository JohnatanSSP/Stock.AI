package JohnatanSSP.Stock.AI.controller;

import JohnatanSSP.Stock.AI.model.ObjectItem;
import JohnatanSSP.Stock.AI.service.ObjectItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class ObjectItemController {

    private ObjectItemService Service;

    public ObjectItemController(ObjectItemService service) {
        Service = service;
    }

    //get
    public ShowAll(){

    }
    //post
    public ResponseEntity<ObjectItem> saveObject(@RequestBody ObjectItem objectItem){
        ObjectItem object = Service.saveObject(objectItem);
        return ResponseEntity.ok(object);
    }

    //update

    //delete
}

