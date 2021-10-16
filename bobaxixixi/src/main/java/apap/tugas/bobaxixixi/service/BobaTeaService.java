package apap.tugas.bobaxixixi.service;

import apap.tugas.bobaxixixi.model.BobaTeaModel;
import java.util.List;

public interface BobaTeaService {
    List<BobaTeaModel> getListBoba();
    BobaTeaModel getBobaByIdBoba(Long idBoba);
    void addBoba(BobaTeaModel boba);
    void updateBoba(BobaTeaModel boba);
    void deleteBoba(BobaTeaModel boba);
}
