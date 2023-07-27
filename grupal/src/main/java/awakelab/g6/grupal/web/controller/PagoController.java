package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.Pay;
import awakelab.g6.grupal.model.domain.dto.Visit;
import awakelab.g6.grupal.model.persistence.entity.Pago;
import awakelab.g6.grupal.web.service.PagoService;
import awakelab.g6.grupal.web.service.VisitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pago")
public class PagoController {
private final PagoService service;
private final PagoRestController pagoRestController;


    public PagoController(PagoService service, PagoRestController pagoRestController) {
        this.service = service;
        this.pagoRestController = pagoRestController;
    }

    @GetMapping
public String listPagos(Model model){
    List<Pay> pays = pagoRestController.findAll().getBody();
    System.out.println(pays);
    model.addAttribute("pays",pays);
return "listPagos";
}
}
