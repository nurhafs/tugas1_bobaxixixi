package apap.tugas.bobaxixixi.controller;

import apap.tugas.bobaxixixi.model.BobaTeaModel;
import apap.tugas.bobaxixixi.model.ToppingModel;
import apap.tugas.bobaxixixi.service.BobaTeaService;
import apap.tugas.bobaxixixi.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class BobaTeaController {
    @Qualifier("bobaTeaServiceImpl")
    @Autowired
    BobaTeaService bobaService;

    @Qualifier("toppingServiceImpl")
    @Autowired
    ToppingService toppingService;

    @GetMapping("/boba/add")
    public String addBobaForm(Model model){
        BobaTeaModel btm = new BobaTeaModel();
        List<ToppingModel> listTopping = toppingService.getToppingList();
        model.addAttribute("boba", btm);
        model.addAttribute("toppingList", listTopping);
        return "form-add-boba";
    }

    @PostMapping("/boba/add")
    public String addBobaSubmit(
        @ModelAttribute BobaTeaModel boba,
        Model model
    ){
        bobaService.addBoba(boba);
        model.addAttribute("namaBoba", boba.getNamaBoba());
        return "add-boba";
    }

    @GetMapping("/boba")
    public String viewAllBoba(
        Model model
    ){
        model.addAttribute("listBoba", bobaService.getListBoba());
        return "viewall-boba";
    }

    @GetMapping("/boba/update/{idBoba}")
    public String updateBobaForm(@PathVariable Long idBoba, Model model){
        BobaTeaModel btm = bobaService.getBobaByIdBoba(idBoba);
        List<ToppingModel> listTopping = toppingService.getToppingList();
        model.addAttribute("boba", btm);
        model.addAttribute("toppingList", listTopping);
        return "form-update-boba";
    }

    @PostMapping("/boba/update")
    public String updateBobaSubmit(
        @ModelAttribute BobaTeaModel boba,
        Model model
    ){
        bobaService.updateBoba(boba);
        model.addAttribute("namaBoba", boba.getNamaBoba());
        return "update-boba";
    }

    @GetMapping("/boba/delete/{idBoba}")
    public String deleteBoba(@PathVariable Long idBoba, Model model){
        BobaTeaModel boba = bobaService.getBobaByIdBoba(idBoba);
        String name = boba.getNamaBoba();
        bobaService.deleteBoba(boba);
        model.addAttribute("namaBoba", name);
        return "delete-boba";
    }
}
