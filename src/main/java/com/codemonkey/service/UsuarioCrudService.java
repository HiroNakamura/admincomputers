package com.codemonkey.service;

import java.util.List;
import com.codemonkey.entity.Usuario;

public interface UsuarioCrudService{
    public List<Usuario> buscarUsuarioByNombre(String nombre);
    public List<Usuario> buscarUsuarioByUsuario(String usuario);
    public List<Usuario> buscarUsuarioByComputadoraBien(String computadora);
    public List<Usuario> buscarUsuarioByComputadoraArrendado(String computadora);
    public List<Usuario> buscarUsuarioByDepartamento(String departamento);
}
