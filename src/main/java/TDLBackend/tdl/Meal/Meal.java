package TDLBackend.tdl.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate mealDate;
    
    Meal(){}
    
    public Meal(String label, LocalDate mealDate) {
        this.label = label;
        this.mealDate = mealDate;
    }

    public Integer getId() {
        return this.id;
    }

    public String getLabel()
    {
        return this.label;
    }

    public LocalDate getMealDate()
    {
        return this.mealDate;
    }
}
