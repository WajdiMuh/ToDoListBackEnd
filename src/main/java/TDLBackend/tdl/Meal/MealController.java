package TDLBackend.tdl.Meal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/meal")
public class MealController {
	
	@Autowired
	MealRepository mealRepository;

	@PostMapping("/add")
	public ResponseEntity<Void> addMeal(@RequestBody Meal meal)
    {

        try 
        {
            mealRepository.addMeal(meal);
        }
        catch(Exception e) 
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
	public ResponseEntity<Void> deleteMeal(@RequestParam Integer id)
    {

        try 
        {
            mealRepository.deleteMeal(id);
        }
        catch(Exception e) 
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

	@GetMapping("/getMealsInWeek")
	public ResponseEntity<List<Meal>> fetchMeals(@RequestParam Integer year, @RequestParam Integer calenderWeek)
    {
		List<Meal> mealsInWeek;
        try 
        {
            mealsInWeek = mealRepository.getMealsInCalenderWeek(year, calenderWeek);
        }
        catch(Exception e) 
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<List<Meal>>(mealsInWeek, HttpStatus.OK);
    }
}
