package ftninformatika.test.projekat.service.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftninformatika.test.projekat.model.Prijava;
import ftninformatika.test.projekat.service.web.dto.PrijavaDTO;

@Component
public class PrijavaToPrijavaDto implements Converter <Prijava, PrijavaDTO> {
	
	
	@Override
	public PrijavaDTO convert(Prijava prijava) {
	
	PrijavaDTO prijavaDTO = new PrijavaDTO();
	prijavaDTO.setId(prijava.getId());
	prijavaDTO.setDrzava(prijava.getDrzava());
	prijavaDTO.seteMail(prijava.geteMail());
	prijavaDTO.setDatumPrijave(prijava.getDatumPrijave());
	
	if(prijava.getTakmicenje() != null) {
		prijavaDTO.setTakmicenjeId(prijava.getTakmicenje().getId());
		
		}
	return prijavaDTO;
	
	}
	
public List<PrijavaDTO> convert (List<Prijava>prijave){
		List<PrijavaDTO> retVal = new ArrayList<>();
		
		for (Prijava p : prijave) {
			retVal.add(convert(p));
			
		}
		
		return retVal;
	

	
}
	
}

