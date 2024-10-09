package TDLBackend.tdl.Item;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.sql.Timestamp;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import TDLBackend.tdl.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/item")
public class ItemController {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ItemRepository itemRepository;


    @PostMapping("/add")
    public ResponseEntity addItem(@RequestParam("label") String label, @RequestParam("checked") boolean checked){

        try {
            itemRepository.save(new Item(label,checked));
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to to save items");
        }
        System.out.println("pls");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Item>> fetchItems(){
        List<Item> items;
    
        try {
            items = entityManager.createQuery("from item", Item.class).getResultList();
            System.out.println(items);
        }
        catch(Exception e) {
            System.out.println(e);

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save items");
        }
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity deleteItems(@RequestParam("itemIDs") List<Integer> itemIDs){
        try {
            itemRepository.deleteUsersWithIds(itemIDs);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete items");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @PostMapping("update")
    public ResponseEntity updatecheckedValue(@RequestParam("id") int id, @RequestParam("checked") boolean checked){
        try {
            itemRepository.updatecheckedValue(id,checked);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete items");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}