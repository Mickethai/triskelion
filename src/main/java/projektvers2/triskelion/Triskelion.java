package projektvers2.triskelion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//
@EnableScheduling
@SpringBootApplication
public class Triskelion {
    @Autowired

    BookRepository bookRepository;
	public static void main(String[] args) {

		SpringApplication.run(Triskelion.class, args);


	}

	 @Scheduled(fixedRate = 1000)
	 public void doSometime(){
		System.out.println("Hej");



	}
}







