package api_academia_cerebritos.demo.controller;

import api_academia_cerebritos.demo.models.ApiResponse;
import api_academia_cerebritos.demo.models.Usuarios;
import api_academia_cerebritos.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping("/create")
    public ResponseEntity<?> saveUsuario(@RequestBody Usuarios usuario){
        try {
            // Generar un nuevo id aleatorio de números
            Random random = new Random();
            int newId = random.nextInt(10000); // Cambia el rango según tus necesidades
            // Asignar el nuevo ID al usuario
            usuario.setId(newId);
            Usuarios usersave = usuarioRepository.save(usuario);
            String message = "Usuario insertado correctamente";
            boolean status = true;
            return ResponseEntity.ok().body(new ApiResponse(message, status));
        } catch (Exception e) {
            String message = "Error al insertar usuario: " + e.toString();
            boolean status = false;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(message, status));
        }
    }


    @GetMapping("/list")
    public ResponseEntity<?> findAllUsuarios(){
        try {
            List<Usuarios> usuarios = usuarioRepository.findAll();
            return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
        }catch (Exception e){
            String message = "Error al listar usuarios: "+ e.toString();
            boolean status = false;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(message, status));
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editUsuario(@RequestBody Usuarios usuario){
        try {
            Usuarios usersave = usuarioRepository.save(usuario);
            String message = "Usuario actualizado correctamente";
            boolean status = true;
            return ResponseEntity.ok().body(new ApiResponse(message, status));
        }catch (Exception e){
            String message = "Error al actualizar usuario: "+ e.toString();
            boolean status = false;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(message, status));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Integer id){
        try {
            usuarioRepository.deleteById(id);
            String message = "Usuario eliminado correctamente";
            boolean status = true;
            return ResponseEntity.ok().body(new ApiResponse(message, status));
        }catch (Exception e){
            String message = "Error al eliminar usuario: "+ e.toString();
            boolean status = false;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(message, status));
        }
    }
}
