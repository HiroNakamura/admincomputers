package com.codemonkey.service;

import java.util.List;
import com.codemonkey.entity.Usuario;

public interface UsuarioService{
    public List<Usuario> getAllUsuarios(); 
    public Usuario getUsuarioById(long idusuario);
    public Usuario addUsuario(Usuario usuario);
    public Usuario updateUsuario(Long idusuario, String apellidos, String cargo, String nombre, String password,String usuario,Long idcomputadora,Long iddepartamento);
    public void deleteUsuario(long idusuario);
    public boolean existUsuario(Usuario usuario);
}
