package com.poli.spmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poli.spmysql.dto.UsuarioDto;
import com.poli.spmysql.models.Usuario;
import com.poli.spmysql.repositoryes.UsuarioRepository;
import com.poli.spmysql.services.UsuarioServices;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String Inicio() {
        return "Hola Mundo " + "desde Spring Boot";
    }

    @GetMapping("/usuarios")
    public String listarClientes() {
        return usuarioRepository.findAll().toString();
    }

    @GetMapping("/usuarios2")
    public List<Usuario> listarClientes2() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/user2/{id}")
    public Usuario listarCliente2(@PathVariable Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id) {
        return usuarioRepository.findById(id).toString();
    }

    @PostMapping("/usuario1")
    public Usuario crearusuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/user/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return "Usuario eliminado con éxito";
    }

    @PutMapping("usuario/{id}")
    public Usuario UserUpdate(@PathVariable String id, @RequestBody Usuario usuario) {
        Usuario usuarioupdate = usuarioRepository.findById(Integer.parseInt(id)).orElse(null);
        if (usuarioupdate == null) {
            return null; // or throw an exception
        }
        usuarioupdate.setNombres(usuario.getNombres());
        usuarioupdate.setApellidos(usuario.getApellidos());
        usuarioupdate.setId_ciudad(usuario.getId_ciudad());
        usuarioRepository.save(usuarioupdate);
        return usuarioupdate;
    }

    @Autowired
    private UsuarioServices usuarioservice;

    @GetMapping("/usuarios1")
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        return new ResponseEntity<>(usuarioservice.getUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/inicio")
    public String Inicio2() {
        return "Hola Mundo " + "desde Spring Boot";
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioDto> saveUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuarioservice.save(usuarioDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<UsuarioDto> getUsuario(@PathVariable Integer usuarioId) {
        return new ResponseEntity<>(usuarioservice.getUsuario(usuarioId),
                HttpStatus.OK);
    }

    @PutMapping("/usuario/{usuarioId}")

    public ResponseEntity<UsuarioDto> updateUser(@PathVariable Integer usuairoId, @PathVariable UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuarioservice.update(usuairoId, usuarioDto),
                HttpStatus.OK);
    }

    @DeleteMapping("usuario/{usuarioId}")

    public ResponseEntity<UsuarioDto> delete(@PathVariable Integer usuarioId) {
        return new ResponseEntity<>(usuarioservice.deleteUsuario(usuarioId),
                HttpStatus.OK);
    }

}
