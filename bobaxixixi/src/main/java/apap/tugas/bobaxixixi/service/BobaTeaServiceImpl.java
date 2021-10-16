package apap.tugas.bobaxixixi.service;

import apap.tugas.bobaxixixi.model.BobaTeaModel;
import apap.tugas.bobaxixixi.repository.BobaTeaDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
 
@Service
@Transactional
public class BobaTeaServiceImpl implements BobaTeaService{
    @Autowired
    BobaTeaDb bobaTeaDb;
 
    @Override
    public List<BobaTeaModel> getListBoba() {
        return bobaTeaDb.findAll();
    }
 
    @Override
    public void addBoba(BobaTeaModel boba){
        bobaTeaDb.save(boba);
    }
    
    @Override
    public void updateBoba(BobaTeaModel boba){
        bobaTeaDb.save(boba);
    }

    @Override
    public void deleteBoba(BobaTeaModel boba) {
        bobaTeaDb.delete(boba);
    }

    @Override
    public BobaTeaModel getBobaByIdBoba(Long idBoba){
        Optional<BobaTeaModel> boba = bobaTeaDb.findByIdBoba(idBoba);
        if (boba.isPresent()) {
            return boba.get();
        }
        return null;
    }
}
