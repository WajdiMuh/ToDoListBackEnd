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
import TDLBackend.tdl.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.*;


@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    List<Integer> itemsToDelete = new ArrayList<Integer>();

    @PostMapping("/add")
    public ResponseEntity<List<Item>> addItem(@RequestParam("itemID")int itemID,@RequestParam("label") String label, @RequestParam("checked") boolean checked){
        try {
            itemRepository.save(new Item(itemID,label,checked));
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to to save items");
        }
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @PostMapping("/fetch")
    public ResponseEntity fetchItems(){
        List<Item> items = new List<items>();
        try {
           iems = itemRepository.fetchItems();
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to to save items");
        }
        return new ResponseEntity<>(HttpStatus.OK);
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