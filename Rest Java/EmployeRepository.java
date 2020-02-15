 package entities;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import entities.Employe;


@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long>{
	@Query("select e from Employe e where e.nom like :x or e.departement.nomDepart like :x") 
	public List<Employe> nomParMotCle(@Param("x")String nom);
}
//"select e from Employe e where e.nom like :x or e.departement.nomDepart like :x"
