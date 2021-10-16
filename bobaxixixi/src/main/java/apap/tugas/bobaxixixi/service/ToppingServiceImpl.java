package apap.tugas.bobaxixixi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tugas.bobaxixixi.model.ToppingModel;
import apap.tugas.bobaxixixi.repository.ToppingDb;

@Service
@Transactional
public class ToppingServiceImpl implements ToppingService {
    @Autowired
    ToppingDb toppingDb;

    @Override
    public List<ToppingModel> getToppingList() { return toppingDb.findAll();}

    @Override
    public ToppingModel getToppingByIdTopping(Long idTopping) {
        Optional<ToppingModel> topping = toppingDb.findByIdTopping(idTopping);
        if (topping.isPresent()) {
            return topping.get();
        }
        return null;
    }
}
