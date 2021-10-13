package apap.tugas.bobaxixixi.service;

import apap.tugas.bobaxixixi.model.StoreModel;
import java.util.List
;
public interface StoreService {
    void addStore(StoreModel store);
    void updateStore(StoreModel store);
    List<StoreModel> getStoreList();
    StoreModel getStoreByIdStore(Long idStore);
    List<StoreModel> getStoreListSorted();
    void deleteStore(StoreModel store);
}
