package apap.tugas.bobaxixixi.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tugas.bobaxixixi.model.ManagerModel;
import apap.tugas.bobaxixixi.repository.ManagerDb;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDb managerDb;

    @Override
    public List<ManagerModel> getListManager() {
        return managerDb.findAll();
    }
}
