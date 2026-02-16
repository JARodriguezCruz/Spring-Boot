package com.ebac.modulo62.controller;

import com.ebac.modulo62.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    // GET - Obtener todos
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    //Get por Id
    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    // POST -Crear
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id,
                                     @RequestBody Usuario usuarioActualizado) {

        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                u.setNombre(usuarioActualizado.getNombre());
                u.setEmail(usuarioActualizado.getEmail());
                return u;
            }
        }
        return null;
    }

    // DELETE - Eliminar
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarios.removeIf(u -> u.getId().equals(id));
        return "Usuario eliminado";
    }
}
