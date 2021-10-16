package apap.tugas.bobaxixixi.service;

import apap.tugas.bobaxixixi.model.StoreBobaTeaModel;
import apap.tugas.bobaxixixi.repository.StoreBobaTeaDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;

@Service
public class StoreBobaTeaServiceImpl implements StoreBobaTeaService {
    @Autowired
    StoreBobaTeaDb storeBobaTeaDb;
 
    @Override
    public List<StoreBobaTeaModel> getListStoreBoba() {
        return storeBobaTeaDb.findAll();
    }
 
    @Override
    public void addSbt(StoreBobaTeaModel stb){
        storeBobaTeaDb.save(stb);
    }
}
