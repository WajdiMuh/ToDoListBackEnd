package TDLBackend.tdl.Item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ItemRepository itemRepository;
    
   
    @PostMapping("/add")
    public ResponseEntity<Void> addItem(@RequestBody Item item)
    {

        try 
        {
            itemRepository.addItem(item);
        }
        catch(Exception e) 
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Item>> fetchItems()
    {
        List<Item> items;
    
        try {
            items = entityManager.createQuery("from item", Item.class).getResultList();
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteItems(@RequestBody List<Integer> itemIDs)
    {
        try {
            itemRepository.deleteitemswithids(itemIDs);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @PutMapping("/updateCheck")
    public ResponseEntity<Void> updatecheckedValue(@RequestBody HashMap<Integer, Boolean> id_checked_map)
    {
        try {
            for (Map.Entry<Integer, Boolean> entry : id_checked_map.entrySet()) {
                itemRepository.updatecheckedValue(entry.getKey(), entry.getValue());
            }
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
