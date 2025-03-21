package TDLBackend.tdl.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer>
{
	@Query(value = "select * from store", nativeQuery = true)
	List<Store> getStores();
}
