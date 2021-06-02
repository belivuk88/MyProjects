package ftninformatika.test.projekat.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import ftninformatika.test.projekat.model.Format;
import ftninformatika.test.projekat.service.FormatService;
import ftninformatika.test.projekat.service.web.dto.FormatDTO;

@Component
public class FormatDtoToFormat implements Converter <FormatDTO, Format> {
	
	@Autowired
	private FormatService formatService;
	
	@Override
	public Format convert(FormatDTO dto) {
		
		Format format;
	
		if(dto.getId() == null) {
			format = new Format();
	}else {
		format = formatService.findOne(dto.getId()).get();
	}
		if(format !=null) {
			format.setTipTakmicenja(dto.getTip());
			format.setBrojUcesnika(dto.getBrojUcesnika());
		}
		return format;
}
	
}
	
	
