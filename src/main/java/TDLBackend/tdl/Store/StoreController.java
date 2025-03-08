package TDLBackend.tdl.Store;

import TDLBackend.tdl.Item.Item;
import TDLBackend.tdl.Item.ItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/fetch")
public class StoreController {
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	StoreRepository storeRepository;
	
	@GetMapping("/getstores")
	public ResponseEntity getStores(){
		List<Store> stores = new ArrayList<>();
		try {
			stores = storeRepository.getStores();
			
		}  catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to to fetch stores");
		}
		
		return new ResponseEntity<>(stores,HttpStatus.OK);
	}
	
	
}
