package awakelab.g6.grupal.web.service;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.model.domain.dto.Training;
import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.model.persistence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
Optional<List<Customer>> findAll();
Optional<Customer> findById(int id);
Optional<Customer> create(Customer customer);
  Optional<Customer> update(Customer customer);
}
