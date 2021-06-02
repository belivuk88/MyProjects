package ftninformatika.test.projekat.service.web.dto;

import javax.persistence.Column;

public class FormatDTO {
	
	private Long Id;
	
	
	private String tip;
	
	
	int brojUcesnika;


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTip() {
		return tip;
	}


	public void setTip(String tip) {
		this.tip = tip;
	}


	public int getBrojUcesnika() {
		return brojUcesnika;
	}


	public void setBrojUcesnika(int brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}

}
