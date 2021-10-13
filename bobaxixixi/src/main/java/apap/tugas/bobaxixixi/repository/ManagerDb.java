package apap.tugas.bobaxixixi.repository;

import java.util.Optional;
// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tugas.bobaxixixi.model.ManagerModel;

@Repository
public interface ManagerDb extends JpaRepository<ManagerModel, Long> {
    Optional<ManagerModel> findByIdManager(Long idManager);
    // List<ManagerModel> findAllByOrderByNamaStoreAsc();
}