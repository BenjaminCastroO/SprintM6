package awakelab.g6.grupal.web.controller;

import awakelab.g6.grupal.model.domain.dto.Training;
import awakelab.g6.grupal.model.domain.dto.Visit;
import awakelab.g6.grupal.model.persistence.entity.Visita;
import awakelab.g6.grupal.web.service.CapacitacionService;
import awakelab.g6.grupal.web.service.ClienteService;
import awakelab.g6.grupal.web.service.VisitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visita")
public class VisitaRestController {
  private final VisitaService service;
  public VisitaRestController(VisitaService service){
    this.service = service;
  }
  @GetMapping
  public ResponseEntity<List<Visit>> findAll(){
    return service.findAll().map(training -> new ResponseEntity<>(training, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }



}
