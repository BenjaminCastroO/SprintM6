package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.Administrative;
import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.AdministrativoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/administrativo")
public class AdministrativoController {
private final AdministrativoService service;
private final AdministrativoRestController administrativoRestController;
private final UsuarioRestController usuarioRestController;

    public AdministrativoController(AdministrativoService service,
                                    AdministrativoRestController administrativoRestController,
                                    UsuarioRestController usuarioRestController) {
        this.service = service;
        this.administrativoRestController = administrativoRestController;
        this.usuarioRestController = usuarioRestController;
    }

@GetMapping
    public String listAdministrativoes(Model model){
        List<Administrative> administratives =
                administrativoRestController.findAll().getBody();
        model.addAttribute("administratives",administratives);
        return "listAdministrativos";
}
    @GetMapping ("/create")
    public String crearAdministrativo(Model model){
        String op = "c";
        model.addAttribute("op",op);
        return "administrativo";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Administrative administrative,
                         @ModelAttribute User user,
                         HttpServletRequest request){
        administrative.setUserId(usuarioRestController.create(user).getBody().getId());
        administrativoRestController.create(administrative);
        return "administrativo";
    }

}
