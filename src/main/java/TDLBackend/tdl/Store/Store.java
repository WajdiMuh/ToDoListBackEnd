package TDLBackend.tdl.Store;

import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity(name = "store")
public class Store {
	
	public Store(){}
	
	@SequenceGenerator(
			name = "store_id_seq",
			sequenceName = "store_id_seq",
			allocationSize = 1
	)
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "store_id_seq"
	)
	@Column(name= "id")
	private int id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "type")
	private StoreType type;
	
	
	public Store(int id, String name, StoreType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public StoreType getType() {
		return type;
	}
	
	public void setType(StoreType type) {
		this.type = type;
	}
}
