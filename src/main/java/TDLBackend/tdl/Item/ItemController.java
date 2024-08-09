package TDLBackend.tdl.Item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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


@RestController
@RequestMapping("/item")
public class ItemController {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ItemRepository itemRepository;

    List<Integer> itemsToDelete = new ArrayList<Integer>();

    @PostMapping("/add")
    public ResponseEntity<List<Item>> addItem(@RequestParam("label") String label, @RequestParam("checked") boolean checked){

        try {
            itemRepository.save(new Item(label,checked));

        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to to save items");
        }
        System.out.println("pls");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/fetch")
    public ResponseEntity<List<Item>> fetchItems(){
        List<Item> items = new ArrayList<Item>();

        try {

            items = entityManager.createQuery("from Item", Item.class).getResultList();
            System.out.println(items);
        }
        catch(Exception e) {
            System.out.println(e);

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to to save items");
        }
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity deleteItems(@RequestParam("itemIDs") List<Integer> itemIDs){

        try {
            for(Integer itemId: itemIDs) {
            itemsToDelete.add(itemId);
            }
            itemRepository.deleteUsersWithIds(itemsToDelete);
        }
            catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete items");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}