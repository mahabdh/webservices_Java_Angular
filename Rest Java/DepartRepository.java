package entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface DepartRepository extends JpaRepository<Departement,Long>{

	
}
