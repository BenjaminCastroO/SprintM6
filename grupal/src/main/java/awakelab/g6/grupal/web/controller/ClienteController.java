package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
private final ClienteService service;
private final ClienteRestController clienteRestController;
private final UsuarioRestController usuarioRestController;

    public ClienteController(ClienteService service,
                             ClienteRestController clienteRestController, UsuarioRestController usuarioRestController) {
        this.service = service;
        this.clienteRestController = clienteRestController;
        this.usuarioRestController = usuarioRestController;
    }

@GetMapping
    public String listClientes(Model model){
        List<Customer> customers = clienteRestController.findAll().getBody();
        model.addAttribute("customers",customers);
        return "listClientes";
}
    @GetMapping ("/create")
    public String crearCliente(Model model){
        String op = "c";
        model.addAttribute("op",op);
        return "cliente";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer,
                         @ModelAttribute User user,
                         HttpServletRequest request){
        customer.setUserId(usuarioRestController.create(user).getBody().getId());
        clienteRestController.create(customer);
        return "cliente";
    }

}
