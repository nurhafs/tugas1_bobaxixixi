package apap.tugas.bobaxixixi.repository;

import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import apap.tugas.bobaxixixi.model.BobaTeaModel;

@Repository
public interface BobaTeaDb extends JpaRepository<BobaTeaModel, String> {
    Optional<BobaTeaModel> findByNamaBoba(String nama);
}
