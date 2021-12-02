package com.wasabi.demo.controllers;

import java.util.Optional;

import com.wasabi.demo.models.UsuarioModel;
import com.wasabi.demo.repositories.UsuarioRepository;
import com.wasabi.demo.services.UsuarioService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioControllerTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioServiceMock = Mockito.mock(UsuarioService.class);

    @Autowired
    UsuarioModel usuario = new UsuarioModel();

    @Autowired
    UsuarioController usuarioController = new UsuarioController();

    @BeforeEach
    void setUp() {

        UsuarioModel mockUsuarioModel = new UsuarioModel();
        mockUsuarioModel.setId((long) 1);
        mockUsuarioModel.setName("Pepe");
        mockUsuarioModel.setEmail("email@gmail.com");

        Mockito.when(usuarioServiceMock.obtenerPorId((long) 1)).thenReturn(Optional.of(mockUsuarioModel));

    }

    @Test
    void testObtenerUsuarioPorId() {
        Optional<UsuarioModel> respuestaEntity;
        respuestaEntity = usuarioController.obtenerUsuarioPorId((long) 1);
        Assertions.assertEquals("Pepe", respuestaEntity.get().getName());

    }
}
