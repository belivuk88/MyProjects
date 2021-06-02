package ftninformatika.test.projekat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftninformatika.test.projekat.model.Format;
import ftninformatika.test.projekat.repository.FormatRepository;
import ftninformatika.test.projekat.service.FormatService;
@Service
public class JpaFormatService implements FormatService {

	@Autowired
	FormatRepository formatRepository;
	
	@Override
	public List<Format> findAll() {
		// TODO Auto-generated method stub
		return formatRepository.findAll();
	}

	@Override
	public Optional<Format> findOne(Long id) {
		// TODO Auto-generated method stub
		return formatRepository.findById(id);
	}

	@Override
	public Format save(Format format) {
		// TODO Auto-generated method stub
		return formatRepository.save(format);
	}

}
