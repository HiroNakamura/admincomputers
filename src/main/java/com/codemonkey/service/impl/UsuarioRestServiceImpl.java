package com.codemonkey.service.impl;

import com.codemonkey.entity.Usuario;
import com.codemonkey.repository.UsuarioRestRepository;
import com.codemonkey.service.UsuarioRestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioRestService")
public class UsuarioRestServiceImpl implements UsuarioRestService{

    @Autowired
    private UsuarioRestRepository usuarioRestRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRestRepository.findAll();
    }
    
}
