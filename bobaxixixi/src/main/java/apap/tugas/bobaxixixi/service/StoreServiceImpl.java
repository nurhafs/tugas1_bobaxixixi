package apap.tugas.bobaxixixi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tugas.bobaxixixi.model.StoreModel;
import apap.tugas.bobaxixixi.repository.StoreDb;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
    @Autowired
    StoreDb storeDb;

    @Override
    public void addStore(StoreModel store) {
        storeDb.save(store);
    }

    @Override
    public void updateStore(StoreModel store) {
        storeDb.save(store);
    }

    @Override
    public List<StoreModel> getStoreList() { return storeDb.findAll();}

    @Override
    public StoreModel getStoreByIdStore(Long idStore) {
        Optional<StoreModel> store = storeDb.findByIdStore(idStore);
        if (store.isPresent()) {
            return store.get();
        }
        return null;
    }

    @Override
    public List<StoreModel> getStoreListSorted() { return storeDb.findAllByOrderByNamaStoreAsc(); }

    @Override
    public void deleteStore(StoreModel store) {
        storeDb.delete(store);
    }
}
