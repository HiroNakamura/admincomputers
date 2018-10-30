package com.codemonkey.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.codemonkey.service.DepartamentoRestService;
import org.springframework.web.bind.annotation.CrossOrigin;



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


    @Autowired
    @Qualifier("departamentoRestService")
    private DepartamentoRestService departamentoRestService;


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

    //READ ALL -> GET
    //http://localhost:8080/rest/usuariosRest
    @GetMapping("/usuariosRest")
    public List<Usuario> getAllUsuarios(){
        LOGGER.info("--Has entrado a http://localhost:8080/rest/usuariosRest");
        return usuarioService.getAllUsuarios();
    }

    //READ ONE -> GET
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

    //CREATE -> POST
    @PostMapping("/usuario/")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        LOGGER.info("Creando usuario: {}", usuario);
 
        if (usuarioService.existUsuario(usuario)) {
            LOGGER.error("El usuario ya existe!! >> ", usuario.getNombre());
            return null;
        }

        return usuarioService.addUsuario(usuario);
    }

    //UPDATE -> PUT
    @PutMapping("/usuario/{id}")
    public Usuario updateUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario){
        LOGGER.info("Actualizando usuario con id:"+id);
        Usuario encontrado = usuarioService.getUsuarioById(id);
        if(encontrado==null){
            LOGGER.info("No se puede actualizar usuario con id:"+id);
            return null;
        }
        encontrado.setNombre(usuario.getNombre());
        encontrado.setApellidos(usuario.getApellidos());
        encontrado.setUsuario(usuario.getUsuario());
        encontrado.setPassword(usuario.getPassword());
        encontrado.setCargo(usuario.getCargo());
        encontrado.setComputadora(usuario.getComputadora());
        encontrado.setDepartamento(usuario.getDepartamento());
        return encontrado;
    }

    //DELETE -> DELETE
    @PutMapping("/usuariodelete/{id}")
    public Usuario deleteUsuario(@PathVariable("id") long id){
        LOGGER.info("Borrando usuario con id:"+id);
        Usuario encontrado = usuarioService.getUsuarioById(id);
        if(encontrado==null){
            return null;
        }

        return encontrado;
    }


    /*Angular CLI*/
    //http://localhost:8080/rest/departamentosRestAng
    @GetMapping("/departamentosRestAng")
    public List<Departamento> getRestDepartamentos() {
        return departamentoRestService.getAllDepartamentos();
    }

    


}
