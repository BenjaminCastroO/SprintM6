package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
private final UsuarioService service;
private final UsuarioRestController userRest;

    public UsuarioController(UsuarioService service,
                             UsuarioRestController userRest) {
        this.service = service;
        this.userRest = userRest;
    }

@GetMapping
    public String listUsuarios(Model model){
        List<User> users = userRest.findAll().getBody();
        model.addAttribute("users",users);
        return "listUsuarios";
}
}
