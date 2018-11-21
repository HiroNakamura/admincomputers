package com.codemonkey.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codemonkey.entity.Computadora;

public interface ComputadoraCrudRepository extends CrudRepository<Computadora, Long>{

    @Query(value="SELECT distinct idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion, dispositivo, estado FROM public.computadora WHERE public.computadora.bien LIKE '%MXL%' AND public.computadora.dispositivo='Computadora' ",nativeQuery=true)
    public List<Computadora> computadorasArrendadas();
    @Query(value="SELECT distinct idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion, dispositivo, estado FROM public.computadora WHERE public.computadora.bien NOT LIKE '%MXL%' AND public.computadora.dispositivo='Computadora'",nativeQuery=true)
    public List<Computadora> computadorasNoArrendadas();
    @Query(value="SELECT distinct idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion, dispositivo, estado FROM public.computadora WHERE public.computadora.dispositivo!='Computadora'",nativeQuery=true)
    public List<Computadora> computadorasDispositivos();
   

    @Query(value="SELECT distinct idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion, dispositivo, estado FROM public.computadora WHERE public.computadora.bien LIKE %?1% ",nativeQuery=true)
    public List<Computadora> computadorasByBien(String bien);
    @Query(value="SELECT distinct idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion, dispositivo, estado FROM public.computadora WHERE public.computadora.arrendado LIKE %?1% ",nativeQuery=true)
    public List<Computadora> computadorasByArrendado(String arrendado);
    @Query(value="SELECT distinct idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion, dispositivo, estado FROM public.computadora WHERE public.computadora.ip LIKE %?1% ",nativeQuery=true)
    public List<Computadora> computadorasByIp(String ip);


    @Query(value="SELECT distinct emp.nombre, emp.apellidos, emp.cargo, dpto.nombre as area, comp.idcomputadora, comp.bien, comp.arrendado, comp.asignado, comp.administrador, comp.departamento,comp.dominio, comp.dns, comp.ip, comp.maquina, comp.modelo, comp.operativo, comp.red, comp.tipo, comp.ubicacion, comp.actualizada, comp.dispositivo, comp.estado FROM public.usuario as emp, public.computadora as comp, public.departamento as dpto WHERE emp.iddepartamento = dpto.iddepartamento AND emp.idcomputadora = comp.idcomputadora AND dpto.nombre like %?1%  ",nativeQuery=true)
    public List<Computadora> computadorasByDepartamento(String departamento);
    

}
