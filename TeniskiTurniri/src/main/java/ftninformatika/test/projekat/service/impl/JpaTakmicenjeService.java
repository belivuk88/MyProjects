package ftninformatika.test.projekat.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftninformatika.test.projekat.model.Prijava;
import ftninformatika.test.projekat.model.Takmicenje;
import ftninformatika.test.projekat.repository.FormatRepository;
import ftninformatika.test.projekat.repository.PrijavaRepository;
import ftninformatika.test.projekat.repository.TakmicenjeRepository;
import ftninformatika.test.projekat.service.PrijavaService;
import ftninformatika.test.projekat.service.TakmicenjeService;
@Service
public class JpaTakmicenjeService implements TakmicenjeService {

	@Autowired
	TakmicenjeService takmicenjeService;
	
	@Autowired
	PrijavaService prijavaService;
	
	@Autowired
	TakmicenjeRepository takmicenjeRepository;
	
	@Autowired
	PrijavaRepository prijavaRepository;
	
	@Autowired
	FormatRepository formatRepository;
	 
	@Override
	public Page<Takmicenje> findAll(int page) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findAll(PageRequest.of(page, 2));
		
	}

	@Override
	public Optional<Takmicenje> findOne(Long id) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findById(id);
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje delete(Long id) {
		Takmicenje takmicenje = findOne(id).get();
		if(takmicenje !=null) {
			takmicenje.getFormat().getTakmicenja().remove(takmicenje);
			takmicenje.setFormat(null);
			takmicenjeRepository.delete(takmicenje);
			return takmicenje;
		}
		return null;
	}

	@Override
	public Page<Takmicenje> pretraga(Long formatId, String mestoOdrzavanja, int page) {
		// TODO Auto-generated method stub
		if(mestoOdrzavanja !=null) {
			mestoOdrzavanja = "%" + mestoOdrzavanja + "%";
		}
		
		return takmicenjeRepository.pretraga(formatId, mestoOdrzavanja, PageRequest.of(page, 2));
	}

	@Override
	public Takmicenje update(Takmicenje takmicenje) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.save(takmicenje);
	}
	
	@Override
	public Takmicenje prijava(Long id, Prijava prijaviSe) {

	Takmicenje takmicenje = takmicenjeRepository.getOne(id);

	if(takmicenje.getFormat().getBrojUcesnika() > 0) {
	prijaviSe.setDatumPrijave(LocalDate.now().toString());
	prijaviSe.setTakmicenje(takmicenje);
//	prijaviSe.getTakmicenje().getFormat().setBrojUcesnika(1);
	prijavaService.save(prijaviSe);

	takmicenje.getFormat().setBrojUcesnika(takmicenje.getFormat().getBrojUcesnika() -1);
	takmicenjeService.update(takmicenje);

	return takmicenjeRepository.save(takmicenje);

	}

	return null;
	}

}
