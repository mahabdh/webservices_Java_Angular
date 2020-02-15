package entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class GestionEmpApplication implements CommandLineRunner{
	
	@Autowired
	
	private EmployeRepository employeRepository;
	private DepartRepository departRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionEmpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}
}