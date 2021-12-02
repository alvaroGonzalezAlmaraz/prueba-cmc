package com.wasabi.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wasabi.demo.models.UsuarioModel;
import com.wasabi.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
   
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<UsuarioModel>> obtenerUsuarios() {
        List<UsuarioModel> usuarioModels = usuarioService.obtenerUsuarios();
        return new ResponseEntity<>(usuarioModels,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> guardarUsuario(@RequestBody UsuarioModel usuario) {
        UsuarioModel usuarioModel = usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(usuarioModel, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UsuarioModel>> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        Optional <UsuarioModel> usuarioModelOptional = usuarioService.obtenerPorId(id);
        return new ResponseEntity<>(usuarioModelOptional,HttpStatus.O);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuarioPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se elimino el usuario con id " + id;
        } else {
            return "No se pudo eliminar el usuario con id " + id;
        }
    }

}
