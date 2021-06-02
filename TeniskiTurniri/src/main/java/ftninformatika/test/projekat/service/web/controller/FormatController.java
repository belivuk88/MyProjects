package ftninformatika.test.projekat.service.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftninformatika.test.projekat.model.Format;
import ftninformatika.test.projekat.service.FormatService;
import ftninformatika.test.projekat.service.support.FormatToFormatDto;
import ftninformatika.test.projekat.service.web.dto.FormatDTO;

@RestController
@RequestMapping("api/formati")
public class FormatController {
	
	@Autowired
	private FormatService formatService;
	
	@Autowired
	private FormatToFormatDto toDto;
	
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<FormatDTO>> getAll(
	@RequestParam(required = false) String tip){
		
		List<Format>formati = formatService.findAll();
		return new ResponseEntity<>(toDto.convert(formati), HttpStatus.OK);
		
	}

}
