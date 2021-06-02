package ftninformatika.test.projekat.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import ftninformatika.test.projekat.model.Prijava;
import ftninformatika.test.projekat.model.Takmicenje;

public interface TakmicenjeService {

	Page<Takmicenje>pretraga (Long formatId, String mestoOdrzavanja, int pageNum);

	Page<Takmicenje> findAll(int page);

	Optional<Takmicenje> findOne(Long id);
	
	Takmicenje save (Takmicenje takmicenje);
	
	Takmicenje update (Takmicenje takmicenje);
	
	Takmicenje delete (Long id);
	
	Takmicenje prijava (Long id, Prijava prijaviSe);
	

}
