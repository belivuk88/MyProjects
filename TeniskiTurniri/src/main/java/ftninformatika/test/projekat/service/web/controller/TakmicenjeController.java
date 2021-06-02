package ftninformatika.test.projekat.service.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftninformatika.test.projekat.model.Prijava;
import ftninformatika.test.projekat.model.Takmicenje;
import ftninformatika.test.projekat.service.PrijavaService;
import ftninformatika.test.projekat.service.TakmicenjeService;
import ftninformatika.test.projekat.service.support.PrijavaDtoToPrijava;
import ftninformatika.test.projekat.service.support.TakmicenjeDtoToTakmicenje;
import ftninformatika.test.projekat.service.support.TakmicenjeToTakmicenjeDto;
import ftninformatika.test.projekat.service.web.dto.PrijavaDTO;
import ftninformatika.test.projekat.service.web.dto.TakmicenjeDTO;

@RestController
@RequestMapping(value = "/api/takmicenja")
public class TakmicenjeController {
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private TakmicenjeDtoToTakmicenje toTakmicenje;
	
	@Autowired
	private TakmicenjeToTakmicenjeDto toDto;
	
	@Autowired
	private PrijavaDtoToPrijava toPrijava;
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<TakmicenjeDTO>> get(@RequestParam(value = "formatId", required = false) Long formatId,
			@RequestParam(value = "mestoOdrzavanja", required = false) String mestoOdrzavanja,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		
		Page<Takmicenje> page = null;
		
		if(formatId !=null || mestoOdrzavanja !=null) {
			page = takmicenjeService.pretraga(formatId, mestoOdrzavanja, pageNo);
		}else
			page = takmicenjeService.findAll(pageNo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<TakmicenjeDTO> getOne(@PathVariable Long id){
		Optional<Takmicenje> takmicenje = takmicenjeService.findOne(id);
		if(!takmicenje.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDto.convert(takmicenje.get()), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TakmicenjeDTO> add(@Validated @RequestBody TakmicenjeDTO newDto){
		
		Takmicenje takmicenje = toTakmicenje.convert(newDto);
		Takmicenje saved = takmicenjeService.save(takmicenje);
		
		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.CREATED);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TakmicenjeDTO> edit(@Validated @RequestBody TakmicenjeDTO takmicenjeDto,
			@PathVariable Long id){
		
		if(!id.equals(takmicenjeDto.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Takmicenje takmicenje = toTakmicenje.convert(takmicenjeDto);
		Takmicenje saved = takmicenjeService.update(takmicenje);
		
		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.OK);
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Takmicenje obrisanoTakmicenje = takmicenjeService.delete(id);
		
		if(obrisanoTakmicenje !=null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('KORISNIK')")
	@PostMapping (value = "/{id}/prijavi_se")
	public ResponseEntity<Takmicenje> prijava (@PathVariable Long id, @Validated @RequestBody PrijavaDTO prijavaDTO){
	Prijava prijava = toPrijava.convert(prijavaDTO);

	Takmicenje takmicenje = takmicenjeService.prijava(id,prijava);

	if(takmicenje !=null) {

	return new ResponseEntity<>(HttpStatus.OK);
	}else {
	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	}
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
