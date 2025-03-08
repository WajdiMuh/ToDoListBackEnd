package TDLBackend.tdl.Meal;

import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="meal")
public class Meal {

    @SequenceGenerator(
            name = "meal_id_seq",
            sequenceName = "meal_id_seq",
            allocationSize = 1
    )

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meal_id_seq"
    )

    @Column(name="id")
    private int id;

    @Column(name="label")
    private String label;

    @Column(name="mealdate")
    private Timestamp mealDate;
    
    Meal(){}
    
    public Meal(String mealName, LocalDateTime mealDate) {
    }
}
