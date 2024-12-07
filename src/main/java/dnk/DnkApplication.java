package dnk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dnk")
public class DnkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnkApplication.class, args);
		System.out.println("Hello World!");
	}

}
