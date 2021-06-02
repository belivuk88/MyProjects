package ftninformatika.test.projekat.service;

import java.util.List;
import java.util.Optional;

import ftninformatika.test.projekat.model.Prijava;

public interface PrijavaService {
	
	Optional<Prijava>findOne(Long id);
	
	List<Prijava> getAll();
	
	Prijava save (Prijava prijava);
	
	
	
	
	

}
