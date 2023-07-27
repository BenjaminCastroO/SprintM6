package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.model.domain.dto.Training;
import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
private final UsuarioService service;
private final UsuarioRestController usuarioRestController;

    public UsuarioController(UsuarioService service,
                             UsuarioRestController usuarioRestController) {
        this.service = service;
        this.usuarioRestController = usuarioRestController;
    }

@GetMapping
    public String listUsuarios(Model model){
        List<User> users = usuarioRestController.findAll().getBody();
        model.addAttribute("users",users);
        return "listUsuarios";
}
    @GetMapping ("/create")
    public String crearUsuario(Model model){
        String op = "c";
        model.addAttribute("op",op);
        return "usuario";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user, HttpServletRequest request){
        usuarioRestController.create(user);
        return "listCapacitaciones";
    }
}
