package ftninformatika.test.projekat.service.web.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

import ftninformatika.test.projekat.model.Takmicenje;

public class PrijavaDTO {
	
	
	private Long Id;
	
	@Length(max = 3)
	private String drzava;
	
	
	private String eMail;
	
	
	private  String datumPrijave;
	
	
	private TakmicenjeDTO takmicenje;
	
	private Long takmicenjeId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(String datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public TakmicenjeDTO getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(TakmicenjeDTO takmicenje) {
		this.takmicenje = takmicenje;
	}

	public Long getTakmicenjeId() {
		return takmicenjeId;
	}

	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}

}
