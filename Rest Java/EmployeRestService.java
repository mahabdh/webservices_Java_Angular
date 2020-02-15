package entities;




import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*") 
@RestController
public class EmployeRestService {
	@Autowired
	EmployeRepository employeRepository;
	
	@Autowired
	DepartRepository departRepository;
	@GetMapping(value="/listEmployes") 
	public List<Employe> getAllEmp(){
		return employeRepository.findAll();		
	}
	
	
	@GetMapping(value="/listEmployes/{id}")
	public Employe getEmp(@PathVariable(name="id")Long id) {
		return employeRepository.findById(id).get();
	}
	
@PutMapping(value="/listEmployes/{id}")
public Employe updateEmp(@PathVariable(name="id")Long id, @RequestBody Employe emp ) {
	emp.setId(id);
	return employeRepository.save(emp);
}

@PostMapping(value="/listEmployes")
public Employe save(@RequestBody Employe emp) {
	return employeRepository.save(emp);
}

@DeleteMapping(value="/listEmployes/{id}")

public void delete(@PathVariable(name="id") Long id) {
	employeRepository.deleteById(id);
}
@RequestMapping(value="/chercherEmployes",method=RequestMethod.GET) 
public List<Employe> chercher( @RequestParam(name= "x", defaultValue="") String motCle ){
	
	return employeRepository.nomParMotCle(motCle);		
}
@PostMapping(value="/listEmployes/{nbremp}/{nbrdep}")
public List <Employe> save(@PathVariable(name="nbremp")int nbremp,
		            @PathVariable(name="nbrdep")int nbrdep) {
	for(int i=1; i<=nbrdep;i++) {
		Departement d= new Departement("depart"+i);
		departRepository.save(d);
		for(int j=1;j<=nbremp;j++) {
			employeRepository.save(new Employe("nom"+i+j,"prenom"+i+j,"nom"+i+j+".prenom"+i+j+"@gmail.com",d));
		}}
		return employeRepository.findAll();
}
}
