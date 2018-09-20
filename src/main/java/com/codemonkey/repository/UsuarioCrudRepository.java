package com.codemonkey.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codemonkey.entity.Usuario;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long>{

    @Query(value="SELECT public.usuario.idusuario, public.usuario.apellidos, public.usuario.cargo, public.usuario.nombre, public.usuario.password, public.usuario.usuario,public.usuario.iddepartamento , public.usuario.idcomputadora FROM public.usuario WHERE public.usuario.nombre LIKE %?1% ",nativeQuery=true)
    public List<Usuario> buscarUsuarioByNombre(String nombre);

    @Query(value="SELECT public.usuario.idusuario, public.usuario.apellidos, public.usuario.cargo, public.usuario.nombre, public.usuario.password, public.usuario.usuario,public.usuario.iddepartamento , public.usuario.idcomputadora FROM public.usuario WHERE public.usuario.usuario LIKE %?1% ",nativeQuery=true)
    public List<Usuario> buscarUsuarioByUsuario(String usuario);

    @Query(value="SELECT public.usuario.idusuario, public.usuario.apellidos, public.usuario.cargo, public.usuario.nombre, public.usuario.password, public.usuario.usuario, public.usuario.idcomputadora, public.usuario.iddepartamento, public.computadora.bien, public.computadora.arrendado FROM public.usuario, public.computadora WHERE public.usuario.idcomputadora=public.computadora.idcomputadora AND public.computadora.bien LIKE %?1% ",nativeQuery=true)
    public List<Usuario> buscarUsuarioByComputadoraBien(String computadora);

    @Query(value="SELECT public.usuario.idusuario, public.usuario.apellidos, public.usuario.cargo, public.usuario.nombre, public.usuario.password, public.usuario.usuario, public.usuario.idcomputadora, public.usuario.iddepartamento, public.computadora.bien, public.computadora.arrendado FROM public.usuario, public.computadora WHERE public.usuario.idcomputadora=public.computadora.idcomputadora AND public.computadora.arrendado LIKE %?1% ",nativeQuery=true)
    public List<Usuario> buscarUsuarioByComputadoraArrendado(String computadora);
	
   @Query(value="SELECT my_user.idusuario, my_user.apellidos, my_user.cargo, my_user.nombre, my_user.password, my_user.usuario, my_comp.bien, my_comp.ip, my_depto.nombre FROM public.usuario as my_user, public.computadora as my_comp, public.departamento as my_depto WHERE my_user.idcomputadora = my_comp.idcomputadora AND my_user.iddepartamento = my_depto.iddepartamento AND my_comp.ip = %?1% ",nativeQuery=true)
    public List<Usuario> buscarUsuarioByComputadoraIp(String ip);

    

    /*
    public List<Usuario> buscarUsuarioByNombre(@Param("nombre") String nombre);
    @Query("SELECT public.usuario.idusuario, public.usuario.apellidos, public.usuario.cargo,public.usuario.nombre, public.usuario.password, public.usuario.usuario,public.computadora.bien, public.departamento.nombre FROM public.usuario,public.computadora,public.departamento WHERE public.usuario.nombre LIKE '%:usuario%' AND public.usuario.idcomputadora = public.computadora.idcomputadora AND public.usuario.iddepartamento = public.departamento.iddepartamento")
    public List<Usuario> buscarUsuarioByUsuario(@Param("usuario") String usuario);
    @Query("SELECT public.usuario.idusuario, public.usuario.apellidos, public.usuario.cargo, public.usuario.nombre, public.usuario.password, public.usuario.usuario, public.computadora.bien, public.departamento.nombre FROM public.usuario, public.computadora, public.departamento WHERE public.usuario.idcomputadora = :bien AND public.usuario.idcomputadora = public.computadora.idcomputadora AND public.usuario.iddepartamento = public.departamento.iddepartamento")
    public List<Usuario> buscarUsuarioByComputadora(@Param("bien") String bien);
    
	@Query(value="SELECT *FROM person_table WHERE last_name=?1",nativeQuery=true)
	List<Person> getPeronInfoByLastName(String lastName);	
	@Query(value="SELECT *FROM person_table WHERE first_name=?1 AND email=?2",nativeQuery=true)
    List<Person> findByFirstNameAndEmail(String firstName,String email);
    */
}
