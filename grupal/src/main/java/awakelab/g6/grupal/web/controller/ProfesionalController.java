package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.Professional;
import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.ProfesionalService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profesional")
public class ProfesionalController {
private final ProfesionalService service;
private final ProfesionalRestController profesionalRestController;
private final UsuarioRestController usuarioRestController;

    public ProfesionalController(ProfesionalService service,
                                 ProfesionalRestController profesionalRestController, UsuarioRestController usuarioRestController) {
        this.service = service;
        this.profesionalRestController = profesionalRestController;
        this.usuarioRestController = usuarioRestController;
    }

@GetMapping
    public String listProfesionales(Model model){
        List<Professional> professionals =
                profesionalRestController.findAll().getBody();
        model.addAttribute("professionals",professionals);
        return "listProfesionales";
}
    @GetMapping ("/create")
    public String crearProfesional(Model model){
        String op = "c";
        model.addAttribute("op",op);
        return "profesional";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Professional professional,
                         @ModelAttribute User user,
                         HttpServletRequest request){
        professional.setUserId(usuarioRestController.create(user).getBody().getId());
        profesionalRestController.create(professional);
        return "profesional";
    }

}
