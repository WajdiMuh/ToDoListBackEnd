package TDLBackend.tdl.Meal;


import TDLBackend.tdl.Store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("meals")
public class MealController {
	
	@Autowired
	MealRepository mealRepository;
	@PostMapping("addmeals")
	HttpEntity insertMeals(@RequestParam("mealname") String mealName, @RequestParam("mealdate")LocalDateTime mealDate) {
		try {
			mealRepository.insertMeals(mealName,mealDate);
			
		} catch (Exception exception) {
		
		}
		
		return null;
	}
}
