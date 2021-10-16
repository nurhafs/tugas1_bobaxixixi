package apap.tugas.bobaxixixi.controller;

import apap.tugas.bobaxixixi.model.StoreModel;
import apap.tugas.bobaxixixi.model.BobaTeaModel;
import apap.tugas.bobaxixixi.model.ManagerModel;
import apap.tugas.bobaxixixi.model.StoreBobaTeaModel;
import apap.tugas.bobaxixixi.service.StoreService;
import apap.tugas.bobaxixixi.service.BobaTeaService;
import apap.tugas.bobaxixixi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.apache.commons.lang3.*;

import java.time.LocalTime;
import java.util.List;

@SuppressWarnings("ALL")
@Controller
public class StoreController {
    @Qualifier("storeServiceImpl")
    @Autowired
    private StoreService storeService;

    @Qualifier("managerServiceImpl")
    @Autowired
    private ManagerService managerService;

    @Qualifier("bobaTeaServiceImpl")
    @Autowired
    private BobaTeaService bobaTeaService;

    @GetMapping("/store")
    public String listStore(Model model) {
        List<StoreModel> listStore = storeService.getStoreList();
        model.addAttribute("listStore", listStore);
        return "viewall-store";
    }

    @GetMapping("/store/add")
    public String addStoreForm(Model model) {
        StoreModel store = new StoreModel();
        List<ManagerModel> listManager = managerService.getListManager();

        model.addAttribute("store", store);
        model.addAttribute("listManager", listManager);
        return "form-add-store";
    }

    @PostMapping(value = "/store/add")
    public String addStoreSubmit(
            @ModelAttribute StoreModel store,
            Model model
    ) {
        StringBuilder sb = new StringBuilder(store.getNamaStore().substring(0,3));
        String buka = ("0" + store.getJamBuka().getHour());
        if (buka.length() > 2) { buka = buka.substring(1, 3); }
        int tutup = store.getJamTutup().getHour() / 10;
        String storecode = "SC" + sb.reverse().toString().toUpperCase() + buka + tutup + RandomStringUtils.randomAlphabetic(2).toUpperCase();
        store.setStore_code(storecode);
        storeService.addStore(store);
        model.addAttribute("store_code", store.getStore_code());
        return "add-store";
    }

    @GetMapping("/store/{idStore}")
    public String viewDetailStore(
            @PathVariable Long idStore,
            Model model
    ) {
        StoreModel store = storeService.getStoreByIdStore(idStore);
        // for (StoreBobaTeaModel stm : store.getBobas()) {
        //     stm.
        // }
        model.addAttribute("store", store);

        return "view-store";
    }

    @GetMapping("/store/update/{idStore}")
    public String updateStoreForm(
            @PathVariable Long idStore,
            Model model
    ) {
        StoreModel store = storeService.getStoreByIdStore(idStore);
        LocalTime now = LocalTime.now();
        if ((now.isBefore(store.getJamBuka()) || now.isAfter(store.getJamTutup()))) {
            List<ManagerModel> listManager = managerService.getListManager();
            model.addAttribute("store", store);
            model.addAttribute("listManager", listManager);
            return "form-update-store";
        }
        model.addAttribute("namaStore", store.getNamaStore());
        model.addAttribute("store_code", store.getStore_code());
        return "error-cannot-delete";
    }

    @PostMapping("/store/update")
    public String updateStoreSubmit(
            @ModelAttribute StoreModel store,
            Model model
    ) {
        StringBuilder sb = new StringBuilder(store.getNamaStore().substring(0,3));
        String buka = ("0" + store.getJamBuka().getHour());
        if (buka.length() > 2) { buka = buka.substring(1, 3); }
        int tutup = store.getJamTutup().getHour() / 10;  
        String storecode = "SC" + sb.reverse().toString().toUpperCase() + buka + tutup + RandomStringUtils.randomAlphabetic(2).toUpperCase();
        store.setStore_code(storecode);
        storeService.updateStore(store);
        model.addAttribute("store_code", store.getStore_code());
        return "update-store";
    }
    @GetMapping("/store/delete/{idStore}")
    public String deleteStore(@PathVariable Long idStore, Model model) {
        StoreModel store = storeService.getStoreByIdStore(idStore);
        LocalTime now = LocalTime.now();
        LocalTime open = store.getJamBuka();
        LocalTime close = store.getJamTutup();
        List<StoreBobaTeaModel> bobas = store.getBobas();
        if ((now.isBefore(open) || now.isAfter(close)) && bobas.isEmpty()) {
            String storecode = store.getStore_code();
            storeService.removeStore(store);
            model.addAttribute("store_code", storecode);
            return "delete-store";
        }
        model.addAttribute("namaStore", store.getNamaStore());
        model.addAttribute("store_code", store.getStore_code());
        return "error-cannot-delete";
    }
    //postmapping
    @PostMapping("/store/delete/{idStore}")
    public String deleteStoreSubmit(@PathVariable Long idStore, Model model) {
        StoreModel store = storeService.getStoreByIdStore(idStore);
        LocalTime now = LocalTime.now();
        LocalTime open = store.getJamBuka();
        LocalTime close = store.getJamTutup();
        List<StoreBobaTeaModel> bobas = store.getBobas();
        if ((now.isBefore(open) || now.isAfter(close)) && bobas.isEmpty()) {
            String storecode = store.getStore_code();
            storeService.removeStore(store);
            model.addAttribute("store_code", storecode);
            return "delete-store";
        }
        model.addAttribute("namaStore", store.getNamaStore());
        model.addAttribute("store_code", store.getStore_code());
        return "error-cannot-delete";
    }

    @GetMapping("/store/{idStore}/assign-boba")
    public String assignBoba(@PathVariable Long idStore, Model model) {
        StoreModel store = storeService.getStoreByIdStore(idStore);
        List<BobaTeaModel> listBoba = bobaTeaService.getListBoba();
        // for (BobaTeaModel e: listBoba) {
        //     StoreBobaTeaModel obj = new StoreBobaTeaModel();
        //     obj.setId_store(store);
        //     obj.setId_boba(e);
        //     store.getBobas().add(obj);
        // }
        model.addAttribute("store", store);
        model.addAttribute("listBoba", listBoba);
        return "assign-boba";
    }

    public String generateProdCode(Long idStore, BobaTeaModel boba) {
        String store = "00" + idStore;
        String prod = "00" + boba.getIdBoba();
        if (boba.getTopping() == null) {
            return ("PC" + store + "0" + prod);
        }
        return ("PC" + store + "1" + prod);
    }

    // @PostMapping("/store/{idStore}/assign-boba/")
    // public String assignBobaSubmit(@PathVariable Long idStore, @ModelAttribute List<BobaTeaModel> listBoba, Model model) {
    //     for (BobaTeaModel btm : listBoba) {
    //         String prod_code = generateProdCode(idStore, btm);
    //         StoreBobaTeaModel sbtm = new StoreBobaTeaModel();
    //         sbtm.setId_boba(btm.getIdBoba());
    //         sbtm.setId_store(idStore);
    //         sbtm.setProdCode(prod_code);
    //     }
    //     return "assigned-boba";
    //}


}
