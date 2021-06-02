package ftninformatika.test.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftninformatika.test.projekat.model.Prijava;

@Repository
public interface PrijavaRepository extends JpaRepository <Prijava, Long> {

}
