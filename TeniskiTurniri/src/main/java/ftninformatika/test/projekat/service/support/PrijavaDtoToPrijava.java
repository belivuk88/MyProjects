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
import ftninformatika.test.projekat.service.web.dto.FormatDTO;
import ftninformatika.test.projekat.service.web.dto.PrijavaDTO;

@Component
public class PrijavaDtoToPrijava implements Converter <PrijavaDTO, Prijava>  {
	
	
		@Autowired
		private PrijavaService prijavaService;
		
		@Autowired
		private TakmicenjeService takmicenjeService;
		
		@Override
		public Prijava convert(PrijavaDTO dto) {
			
			Takmicenje takmicenje = null;
			if(dto.getTakmicenjeId() != null) {
				takmicenje = takmicenjeService.findOne(dto.getTakmicenjeId()).get();
			}
		
		
			
		if(takmicenje !=null) {
			Long id = dto.getId();
			Prijava prijava = id == null ? new Prijava(): prijavaService.findOne(id).get();
			
			if(prijava !=null) {
				prijava.setDrzava(dto.getDrzava());
				prijava.seteMail(dto.geteMail());
				prijava.setDatumPrijave(dto.getDatumPrijave());
				prijava.setTakmicenje(takmicenje);
			}
			
			return prijava;
		
		}else {
			throw new IllegalStateException("Trying to attach to non-existant");
		}	
}

		
}
	