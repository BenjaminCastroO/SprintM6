package awakelab.g6.grupal.model.persistence.mapper;


import awakelab.g6.grupal.model.domain.dto.Visit;
import awakelab.g6.grupal.model.persistence.entity.Visita;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VisitMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="cliente", target ="customer"),
          @Mapping(source ="fecha", target ="date"),
          @Mapping(source ="hora", target ="time"),
          @Mapping(source ="lugar", target ="place"),
          @Mapping(source ="realizado", target ="done"),
          @Mapping(source ="detalle", target ="detail"),
          @Mapping(source ="profesionalId", target ="profesionalId"),

  })
  Visit toVisit(Visita visita);
  List<Visit> toVisits(List<Visita> visitas);
  @InheritInverseConfiguration
  Visita toVisita(Visit visit);
}
