package ftninformatika.test.projekat.service.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftninformatika.test.projekat.model.Takmicenje;
import ftninformatika.test.projekat.service.web.dto.FormatDTO;
import ftninformatika.test.projekat.service.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDto implements Converter <Takmicenje, TakmicenjeDTO>{
	
	@Autowired
	private FormatToFormatDto toDto;
	
	@Override
	public TakmicenjeDTO convert(Takmicenje takmicenje) {
		TakmicenjeDTO takmicenjeDTO = new TakmicenjeDTO();
		takmicenjeDTO.setId(takmicenje.getId());
		takmicenjeDTO.setNaziv(takmicenje.getNaziv());
		takmicenjeDTO.setMestoOdrzavanja(takmicenje.getMestoOdrzavanja());
		takmicenjeDTO.setDatumPocetka(takmicenje.getDatumPocetka());
		takmicenjeDTO.setDatumZavrsetka(takmicenje.getDatumZavrsetka());
		
		if(takmicenje.getFormat() !=null) {
			takmicenjeDTO.setFormatId(takmicenje.getFormat().getId());
			takmicenjeDTO.setFormatTip(takmicenje.getFormat().getTip());
		}
		
		
		
		return takmicenjeDTO;
		
	}
	
	public List<TakmicenjeDTO> convert (List<Takmicenje> takmicenja){
		List<TakmicenjeDTO> retVal = new ArrayList<>();
		
		for(Takmicenje t: takmicenja) {
			retVal.add(convert(t));
		}
		
		return retVal;
	}

}
