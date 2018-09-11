package com.codemonkey.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codemonkey.entity.Usuario;
import com.codemonkey.entity.Departamento;
import com.codemonkey.entity.Computadora;
import com.codemonkey.repository.UsuarioRepository;
import com.codemonkey.repository.DepartamentoRepository;
import com.codemonkey.repository.ComputadoraRepository;
import com.codemonkey.service.UsuarioService;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
        private final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Autowired
        private DepartamentoRepository departamentoRepository;

        @Autowired
        private ComputadoraRepository computadoraRepository;

        @Override
        public List<Usuario> getAllUsuarios() {
                return usuarioRepository.findAll();
        }

        @Override
        public Usuario addUsuario(Usuario usuario) {
                LOGGER.info("--Has agredado usuario -> addUsuario("+usuario+")");
                return usuarioRepository.save(usuario);
        }

        @Override
        public void deleteUsuario(long idusuario){
                Usuario usuarioEliminar = usuarioRepository.findById(idusuario).orElse(null);
                if(usuarioEliminar != null){
                        LOGGER.info("--Has eliminado usuario:"+usuarioEliminar);
                        usuarioRepository.delete(usuarioEliminar);
                }
        }

        @Override 
        public Usuario updateUsuario(Long idusuario, String apellidos, String cargo, String nombre, String password,String usuario,Long idcomputadora,Long iddepartamento){
                LOGGER.info("--Has entrado a >> #updateUsuario");
                Usuario usuarioUpdate = usuarioRepository.findById(idusuario).orElse(null);
                Computadora computadoraId = computadoraRepository.findById(idcomputadora).orElse(null);
                Departamento departamentoId = departamentoRepository.findById(iddepartamento).orElse(null);
                if(usuarioUpdate != null && computadoraId != null && departamentoId != null){
                        LOGGER.info("--Usuario existe:"+usuarioUpdate);
                        try{
                                usuarioUpdate.setNombre(nombre);
                                usuarioUpdate.setApellidos(apellidos);
                                usuarioUpdate.setCargo(cargo);
                                usuarioUpdate.setUsuario(usuario);
                                usuarioUpdate.setPassword(password);
                                usuarioUpdate.setDepartamento(departamentoId);
                                usuarioUpdate.setComputadora(computadoraId);
                                LOGGER.info("--Has actualizado usuario:"+usuarioUpdate);
                                return usuarioRepository.save(usuarioUpdate);
                        }catch(Exception ex){
                                LOGGER.info("--#Ha ocurrido una excepcion: "+ex.toString());
                                LOGGER.info("--#Causa"+ex.getCause());
                                ex.printStackTrace();
                        }
                        
                }
                return null;
        }

        @Override
        public Usuario getUsuarioById(long idusuario){
                return usuarioRepository.findById(idusuario).orElse(null);
        }
    
}
