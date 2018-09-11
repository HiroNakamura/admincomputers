package com.codemonkey.repository;

import com.codemonkey.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /*@Modifying
    @Query("UPDATE Usuario us SET us.apellidos=:apellidos, us.cargo=:cargo, us.nombre=:nombre, us.password=:password, us.usuario=:usuario, us.idcomputadora=:idcomputadora, us.iddepartamento=:iddepartamento WHERE us.idusuario=:idusuario")
    public void updateUpdateUsuario(@Param("idusuario") Long idusuario, @Param("apellidos") String apellidos,@Param("cargo") String cargo,@Param("nombre") String nombre,@Param("password") String password,@Param("usuario") String usuario,@Param("idcomputadora") Long idcomputadora,@Param("iddepartamento") String iddepartamento);
    */
}
