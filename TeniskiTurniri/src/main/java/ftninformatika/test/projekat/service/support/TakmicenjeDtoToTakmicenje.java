package ftninformatika.test.projekat.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftninformatika.test.projekat.model.Format;
import ftninformatika.test.projekat.model.Prijava;
import ftninformatika.test.projekat.model.Takmicenje;
import ftninformatika.test.projekat.service.FormatService;
import ftninformatika.test.projekat.service.PrijavaService;
import ftninformatika.test.projekat.service.TakmicenjeService;
import ftninformatika.test.projekat.service.web.dto.PrijavaDTO;
import ftninformatika.test.projekat.service.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeDtoToTakmicenje implements Converter <TakmicenjeDTO, Takmicenje>{
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private FormatService formatService;
	
	@Override
	public Takmicenje convert(TakmicenjeDTO dto) {
		
		Format format = null;
		if(dto.getFormatId() != null) {
			format = formatService.findOne(dto.getFormatId()).get();
		}
	
		
	if(format !=null) {
		Long id = dto.getId();
		Takmicenje takmicenje = id == null ? new Takmicenje(): takmicenjeService.findOne(id).get();
	
		if(takmicenje !=null) {
			takmicenje.setNaziv(dto.getNaziv());
			takmicenje.setMestoOdrzavanja(dto.getMestoOdrzavanja());
			takmicenje.setDatumPocetka(dto.getDatumPocetka());
			takmicenje.setDatumZavrsetka(dto.getDatumZavrsetka());
			takmicenje.setFormat(format);
		}
	
		return takmicenje;
	
	}else {
		throw new IllegalStateException ("Trying to attach to non-existant");
	}
	
	
	}
	
	

}
