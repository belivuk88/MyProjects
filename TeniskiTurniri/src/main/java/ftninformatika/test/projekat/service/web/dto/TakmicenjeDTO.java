package ftninformatika.test.projekat.service.web.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

import ftninformatika.test.projekat.model.Format;

public class TakmicenjeDTO {
	
	
	private Long id;
	
	
	private String naziv;
	
	@Length(max = 50)
	private String mestoOdrzavanja;
	
	
	private String datumPocetka;
	
	
	private String datumZavrsetka;
	
	
	private Long formatId;
	
	private String formatTip;



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}


	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}


	public String getDatumPocetka() {
		return datumPocetka;
	}


	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}


	public String getDatumZavrsetka() {
		return datumZavrsetka;
	}


	public void setDatumZavrsetka(String datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}


	public Long getFormatId() {
		return formatId;
	}


	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}



	public String getFormatTip() {
		return formatTip;
	}


	public void setFormatTip(String formatTip) {
		this.formatTip = formatTip;
	}
	
	
	
}
