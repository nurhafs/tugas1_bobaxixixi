package apap.tugas.bobaxixixi.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tugas.bobaxixixi.model.StoreModel;

@Repository
public interface StoreDb extends JpaRepository<StoreModel, Long> {
    Optional<StoreModel> findByIdStore(Long idStore);
    List<StoreModel> findAllByOrderByNamaStoreAsc();
}
