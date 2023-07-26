package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.web.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

@GetMapping
    public String listClientes(Model model){
        model.addAttribute("customers",service.findAll());
        return "listClientes";
}
}
