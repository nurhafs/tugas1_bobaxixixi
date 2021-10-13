package apap.tugas.bobaxixixi.repository;
import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import apap.tugas.bobaxixixi.model.StoreBobaTeaModel;

@Repository
public interface StoreBobaTeaDb extends JpaRepository<StoreBobaTeaModel, Long>{
    Optional<StoreBobaTeaModel> findById(Long id);
}
