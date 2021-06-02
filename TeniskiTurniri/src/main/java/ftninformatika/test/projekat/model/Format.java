package ftninformatika.test.projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Table;


@Entity
@javax.persistence.Table(name = "formati")
public class Format {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String tip;
	
	@Column
	int brojUcesnika;
	
	@OneToMany(mappedBy = "format", fetch = FetchType.EAGER)
	private List<Takmicenje>takmicenja = new ArrayList<>();
	
	
	public Format() {
		super();
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTip() {
		return tip;
	}


	public void setTipTakmicenja(String tip) {
		this.tip = tip;
	}


	public int getBrojUcesnika() {
		return brojUcesnika;
	}


	public void setBrojUcesnika(int brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}


	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}


	public void setTakmicenja(List<Takmicenje> takmicenja) {
		this.takmicenja = takmicenja;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Format other = (Format) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Format [Id=" + Id + ", tipTakmicenja=" + tip + ", brojUcesnika=" + brojUcesnika + "]";
	}


	



	
	


	
}
