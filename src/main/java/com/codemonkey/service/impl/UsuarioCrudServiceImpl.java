package com.codemonkey.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codemonkey.entity.Usuario;
import com.codemonkey.entity.Departamento;
import com.codemonkey.entity.Computadora;
import com.codemonkey.repository.UsuarioCrudRepository;
import com.codemonkey.service.UsuarioCrudService;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("usuarioCrudService")
public class UsuarioCrudServiceImpl implements UsuarioCrudService {

    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioCrudServiceImpl.class);

    @Autowired
	private UsuarioCrudRepository usuarioCrudRepository;

    
    @Override 
    public List<Usuario> buscarUsuarioByNombre(String nombre){
        List<Usuario> buscarUsuarioByNombreList = usuarioCrudRepository.buscarUsuarioByNombre(nombre);
        LOGGER.info("--Resultado:"+buscarUsuarioByNombreList.toString());
        return buscarUsuarioByNombreList; 
    }

    @Override 
    public List<Usuario> buscarUsuarioByUsuario(String usuario){
        List<Usuario> buscarUsuarioByNombreList = usuarioCrudRepository.buscarUsuarioByUsuario(usuario);
        LOGGER.info("--Resultado:"+buscarUsuarioByNombreList.toString());
        return buscarUsuarioByNombreList; 
    }

    @Override
    public List<Usuario> buscarUsuarioByComputadoraBien(String computadora){
        List<Usuario> buscarUsuarioByComputadoraBienList = usuarioCrudRepository.buscarUsuarioByComputadoraBien(computadora);
        LOGGER.info("--Resultado:"+buscarUsuarioByComputadoraBienList.toString());
        return buscarUsuarioByComputadoraBienList; 
    }

    @Override
    public List<Usuario> buscarUsuarioByComputadoraArrendado(String computadora){
        List<Usuario> buscarUsuarioByComputadoraArrendadoList = usuarioCrudRepository.buscarUsuarioByComputadoraArrendado(computadora);
        LOGGER.info("--Resultado:"+buscarUsuarioByComputadoraArrendadoList.toString());
        return buscarUsuarioByComputadoraArrendadoList; 
    }
}
