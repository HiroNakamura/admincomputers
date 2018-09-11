package com.codemonkey.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.codemonkey.entity.Computadora;
import com.codemonkey.service.ComputadoraService;
import com.codemonkey.entity.Departamento;
import com.codemonkey.service.DepartamentoService;
import com.codemonkey.entity.Usuario;
import com.codemonkey.service.UsuarioService;

@RestController
@RequestMapping("/rest")
public class ControllerRestProyecto{

	private final Logger LOGGER = LoggerFactory.getLogger(ControllerRestProyecto.class);

    @Autowired
    @Qualifier("computadoraService")
    private ComputadoraService computadoraService;

    @Autowired
    @Qualifier("departamentoService")
    private DepartamentoService departamentoService;

    @Autowired
    @Qualifier("usuarioService")
    private UsuarioService usuarioService;

    @GetMapping("/computadorasRest")
    public List<Computadora> getAllComputadoras(){
        LOGGER.info("--Has entrado a http://localhost:8080/rest/computadorasRest");
        return computadoraService.getAllComputadoras();
    }

	@GetMapping("/departamentosRest")
    public List<Departamento> getAllDepartamentos(){
        LOGGER.info("--Has entrado a http://localhost:8080/rest/departamentosRest");
        return departamentoService.getAllDepartamentos();
    }

    @GetMapping("/usuariosRest")
    public List<Usuario> getAllUsuarios(){
        LOGGER.info("--Has entrado a http://localhost:8080/rest/usuariosRest");
        return usuarioService.getAllUsuarios();
    }


}
