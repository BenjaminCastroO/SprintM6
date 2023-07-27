package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.CheckList;
import awakelab.g6.grupal.model.domain.dto.Visit;
import awakelab.g6.grupal.model.persistence.entity.ListaChequeo;
import awakelab.g6.grupal.web.service.ListaChequeoService;
import awakelab.g6.grupal.web.service.VisitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chequeo")
public class ListaChequeoController {
private final ListaChequeoService service;
private final ListaChequeoRestController listaChequeoRestController;

    public ListaChequeoController(ListaChequeoService service, ListaChequeoRestController listaChequeoRestController) {
        this.service = service;
        this.listaChequeoRestController = listaChequeoRestController;
    }

    @GetMapping
public String listChequeo(Model model){
    List<CheckList> chequeos = listaChequeoRestController.findAll().getBody();
    System.out.println(chequeos);
    model.addAttribute("chequeos",chequeos);
return "listChequeos";
}
}
