package ftninformatika.test.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftninformatika.test.projekat.model.Format;

@Repository
public interface FormatRepository extends JpaRepository <Format,Long>{

}
