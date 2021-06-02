package ftninformatika.test.projekat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftninformatika.test.projekat.model.Prijava;
import ftninformatika.test.projekat.model.Takmicenje;
import ftninformatika.test.projekat.repository.PrijavaRepository;
import ftninformatika.test.projekat.repository.TakmicenjeRepository;
import ftninformatika.test.projekat.service.PrijavaService;
import ftninformatika.test.projekat.service.TakmicenjeService;
@Service
public class JpaPrijavaService implements PrijavaService {
	
	@Autowired
	TakmicenjeRepository takmicenjeRepository;
	
	@Autowired
	TakmicenjeService takmicenjeService;

	@Autowired
	PrijavaRepository prijavaRepository;
	
	@Autowired
	PrijavaService prijavaService;
	
	@Override
	public Optional<Prijava> findOne(Long id) {
		// TODO Auto-generated method stub
		return prijavaRepository.findById(id);
	}

	@Override
	public List<Prijava> getAll() {
		// TODO Auto-generated method stub
		return prijavaRepository.findAll();
	}

	@Override
	public Prijava save(Prijava prijava) {
		// TODO Auto-generated method stub
		return prijavaRepository.save(prijava);
	}
	

}
