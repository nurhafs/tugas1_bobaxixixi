package apap.tugas.bobaxixixi.repository;
import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import apap.tugas.bobaxixixi.model.StoreBobaTeaModel;
import apap.tugas.bobaxixixi.model.BobaTeaModel;
import apap.tugas.bobaxixixi.model.StoreModel;

import java.util.List;

@Repository
public interface StoreBobaTeaDb extends JpaRepository<StoreBobaTeaModel, Long>{
    Optional<StoreBobaTeaModel> findById(Long id);
    // List<StoreBobaTeaModel> findById_boba(BobaTeaModel id_boba);
    // List<StoreBobaTeaModel> findById_store(StoreModel id_store);
}
