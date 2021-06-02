package ftninformatika.test.projekat.service.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftninformatika.test.projekat.model.Prijava;
import ftninformatika.test.projekat.model.Takmicenje;
import ftninformatika.test.projekat.service.PrijavaService;
import ftninformatika.test.projekat.service.TakmicenjeService;
import ftninformatika.test.projekat.service.support.PrijavaDtoToPrijava;
import ftninformatika.test.projekat.service.support.PrijavaToPrijavaDto;
import ftninformatika.test.projekat.service.web.dto.PrijavaDTO;

@RestController
@RequestMapping(value = "/api/prijave")
public class PrijavaController {
	
	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private PrijavaToPrijavaDto toPrijavaDto;
	
	@Autowired
	private PrijavaDtoToPrijava toPrijava;
	
	@GetMapping
	public ResponseEntity<List<PrijavaDTO>>getAll(){
		List<Prijava>prijave = prijavaService.getAll();
		
		return new ResponseEntity<>(toPrijavaDto.convert(prijave), HttpStatus.OK);
	}
	

	
}
