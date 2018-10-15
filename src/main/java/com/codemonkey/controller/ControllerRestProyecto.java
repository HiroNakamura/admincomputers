package com.codemonkey.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.codemonkey.entity.Computadora;
import com.codemonkey.service.ComputadoraService;
import com.codemonkey.entity.Departamento;
import com.codemonkey.service.DepartamentoService;
import com.codemonkey.entity.Usuario;
import com.codemonkey.service.UsuarioService;

//import org.springframework.web.bind.annotation.CrossOrigin;

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


    /*CRUD Computadora*/
    //http://localhost:8080/rest/computadorasRest
    @GetMapping("/computadorasRest")
    public List<Computadora> getAllComputadoras(){
        LOGGER.info("--Has entrado a http://localhost:8080/rest/computadorasRest");
        return computadoraService.getAllComputadoras();
    }

    //http://localhost:8080/rest/departamentosRest
	@GetMapping("/departamentosRest")
    public List<Departamento> getAllDepartamentos(){
        LOGGER.info("--Has entrado a http://localhost:8080/rest/departamentosRest");
        return departamentoService.getAllDepartamentos();
    }



    /*CRUD Usuario*/

    //GET ALL
    //http://localhost:8080/rest/usuariosRest
    @GetMapping("/usuariosRest")
    public List<Usuario> getAllUsuarios(){
        LOGGER.info("--Has entrado a http://localhost:8080/rest/usuariosRest");
        return usuarioService.getAllUsuarios();
    }

    //GET ONE
    //http://localhost:8080/rest/usuariosRest/{id}
    @GetMapping("/usuariosRest/{id}")
    public Usuario getUsuario(@PathVariable("id") long id){
        LOGGER.info("--Buscas el id:"+id);
        Usuario encontrado = usuarioService.getUsuarioById(id);
        if(encontrado == null){
            return null;
        }
        return encontrado;
    }

    //CREATE
    @PutMapping("/usuario/")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        LOGGER.info("Creando usuario: {}", usuario);
 
        if (usuarioService.existUsuario(usuario)) {
            LOGGER.error("El usuario ya existe!! >> ", usuario.getNombre());
            return null;
        }

        return usuarioService.addUsuario(usuario);
    }

    


}
