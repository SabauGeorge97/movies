package dev.bubu.movies;

//
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//annotation = what the class does
@SpringBootApplication

//a rest api controller class
//@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	//it lets the framework now that is a GET endpoint
	/*@GetMapping("/")
	public String firstMessage(){
		return "My first message!";
	}

	@GetMapping("/root")
	public String apiRoot(){
		return "Hello World!";
	}*/
}
