package ftninformatika.test.projekat.service;

import java.util.List;
import java.util.Optional;

import ftninformatika.test.projekat.model.Format;

public interface FormatService {
	
	List<Format>findAll();
	
	Optional<Format> findOne(Long id);
	
	Format save(Format format);

}
