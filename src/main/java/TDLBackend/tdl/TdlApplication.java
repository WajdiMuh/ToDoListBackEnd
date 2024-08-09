package TDLBackend.tdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import TDLBackend.tdl.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;




@SpringBootApplication
public class TdlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdlApplication.class, args);
	}

}
