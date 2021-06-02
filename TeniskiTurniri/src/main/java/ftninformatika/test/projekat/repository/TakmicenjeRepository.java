package ftninformatika.test.projekat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import ftninformatika.test.projekat.model.Takmicenje;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje,Long> {

	@Query("SELECT t FROM Takmicenje t WHERE " +
			"(:formatId = NULL OR t.format.id = :formatId) AND " +
			"(:mestoOdrzavanja = NULL OR t.mestoOdrzavanja LIKE  :mestoOdrzavanja)")
			Page<Takmicenje> pretraga(@Param("formatId") Long formatId, @Param("mestoOdrzavanja") String mestoOdrzavanja, Pageable pageable);
}
