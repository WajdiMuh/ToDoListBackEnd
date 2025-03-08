package TDLBackend.tdl.Item;

import java.util.Objects;

import TDLBackend.tdl.Store.Store;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity(name = "item")
public class Item {

    public Item(){}

    @SequenceGenerator(
            name = "item_id_seq",
            sequenceName = "item_id_seq",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_seq"
    )
    @Column(name= "id")
    private int id;

    @Column(name= "label")
    private String label;

    @Column(name= "checked")
    private boolean checked;
    
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "storeid", referencedColumnName = "id")
    private Store store;

    Item(String label, boolean checked, Store storeid){
            this.label = label;
            this.checked = checked;
            this.store = storeid;
        }
    
    public Integer getId() {
        return id;
    }
    
    public String getLabel() {
        return label;
    }
    
    public boolean isChecked() {
        return checked;
    }
    
    public Store getStore() {
        return store;
    }
    
    public void setStore(Store storeId) {
        this.store = store;
    }
    
}