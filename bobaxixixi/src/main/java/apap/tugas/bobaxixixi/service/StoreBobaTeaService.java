package apap.tugas.bobaxixixi.service;

import apap.tugas.bobaxixixi.model.StoreBobaTeaModel;
import java.util.List;

public interface StoreBobaTeaService {
    List<StoreBobaTeaModel> getListStoreBoba();
    void addSbt(StoreBobaTeaModel storeBoba);
}
