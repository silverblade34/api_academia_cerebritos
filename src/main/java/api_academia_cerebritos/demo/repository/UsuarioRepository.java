package api_academia_cerebritos.demo.repository;

import api_academia_cerebritos.demo.models.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuarios,Integer> {

}
