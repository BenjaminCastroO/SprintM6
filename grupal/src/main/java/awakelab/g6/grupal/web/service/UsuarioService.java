package awakelab.g6.grupal.web.service;

import awakelab.g6.grupal.model.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
Optional<List<User>> findAll();
Optional<User> findById(int id);
}
