package TDLBackend.tdl.Store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/store")
public class StoreController {
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	StoreRepository storeRepository;
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Store>> getStores()
	{
		List<Store> stores;
		try 
		{
			stores = storeRepository.getStores();
		}
		catch(Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
	
}
