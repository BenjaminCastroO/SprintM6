package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.Pay;
import awakelab.g6.grupal.model.domain.dto.Visit;
import awakelab.g6.grupal.web.service.ClienteService;
import awakelab.g6.grupal.web.service.PagoService;
import awakelab.g6.grupal.web.service.VisitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoRestController {
  private final PagoService service;
  private final ClienteService clienteService;

  public PagoRestController(PagoService service, ClienteService clienteService) {
    this.service = service;
    this.clienteService = clienteService;
  }

  @GetMapping
  public ResponseEntity<List<Pay>> findAll(){
    return service.findAll().map(pay -> new ResponseEntity<>(pay, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }



}
