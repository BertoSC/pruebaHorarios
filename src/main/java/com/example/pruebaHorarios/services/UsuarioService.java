package com.example.pruebaHorarios.services;

import com.example.pruebaHorarios.entities.Usuario;
import com.example.pruebaHorarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear Usuario
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }

    // Actualizar un usuario
    public Usuario updateUsuario(Integer id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombreUsuario(usuarioDetails.getNombreUsuario());
        usuario.setEmail(usuarioDetails.getEmail());

       // Si el tipo es un atributo en tu clase

        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}