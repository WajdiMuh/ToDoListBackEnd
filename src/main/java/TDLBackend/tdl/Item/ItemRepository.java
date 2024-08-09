package TDLBackend.tdl.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import java.sql.Timestamp;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(value="select it.itemIDfrom item it where it.itemID=: itemID", nativeQuery = true)
    int findById(@Param("itemID") int itemID);


//    List<Item> fetchItems() {
//    return List<Item> items = entityManager.createQuery("from Item", Item.class).getResultList(); }


    @Modifying
    @Query(value="delete from item it where it.itemID in ?1",nativeQuery = true)
    void deleteUsersWithIds(List<Integer> itemIDs);
}