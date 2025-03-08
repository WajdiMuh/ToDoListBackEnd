package TDLBackend.tdl.Meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal,Integer> {


@Query(value="insert into meal (label,date) values (mealname,currentdate)", nativeQuery = true)
     void insertMeals(@Param("mealname") String mealName, @Param("currentdate") LocalDateTime currentDate);


@Query(value="select * from meal where weeknumber=: weeknumber", nativeQuery = true)
     List<Meal> fetchMeals(@Param("weeknumber") int weekNumber);

}


//weeknumber year
// 1 2 3 4 5