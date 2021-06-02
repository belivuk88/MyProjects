package ftninformatika.test.projekat.service.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftninformatika.test.projekat.model.Format;
import ftninformatika.test.projekat.service.web.dto.FormatDTO;

@Component
public class FormatToFormatDto implements Converter <Format, FormatDTO>{

	@Override
	public FormatDTO convert(Format format) {
		FormatDTO formatDTO = new FormatDTO();
		formatDTO.setId(format.getId());
		formatDTO.setTip(format.getTip());
		formatDTO.setBrojUcesnika(format.getBrojUcesnika());
		
		
		return formatDTO;
	}
	
	public List<FormatDTO> convert(List<Format>formati){
		List<FormatDTO> formatiDTO = new ArrayList<>();
		
		for (Format format : formati) {
			formatiDTO.add(convert(format));
		}
		
		return formatiDTO;
	}
}
