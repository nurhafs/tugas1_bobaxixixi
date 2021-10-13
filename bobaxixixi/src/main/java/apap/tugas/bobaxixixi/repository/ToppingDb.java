package apap.tugas.bobaxixixi.repository;

import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import apap.tugas.bobaxixixi.model.ToppingModel;
 
@Repository
public interface ToppingDb extends JpaRepository<ToppingModel, String>{
    Optional<ToppingModel> findByNamaTopping(String nama);
}