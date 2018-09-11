package com.codemonkey.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codemonkey.entity.Computadora;

public interface ComputadoraCrudRepository extends CrudRepository<Computadora, Long>{

    @Query(value="SELECT idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion FROM public.computadora WHERE public.computadora.bien LIKE '%MXL%'",nativeQuery=true)
    public List<Computadora> computadorasArrendadas();
    @Query(value="SELECT idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion FROM public.computadora WHERE public.computadora.bien NOT LIKE '%MXL%'",nativeQuery=true)
    public List<Computadora> computadorasNoArrendadas();
   

    @Query(value="SELECT idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion FROM public.computadora WHERE public.computadora.bien LIKE %?1% ",nativeQuery=true)
    public List<Computadora> computadorasByBien(String bien);
    @Query(value="SELECT idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion FROM public.computadora WHERE public.computadora.arrendado LIKE %?1% ",nativeQuery=true)
    public List<Computadora> computadorasByArrendado(String arrendado);
    @Query(value="SELECT idcomputadora, actualizada, administrador, arrendado, asignado, bien, departamento, dns, dominio, ip, maquina, modelo, operativo, red, tipo, ubicacion FROM public.computadora WHERE public.computadora.ip LIKE %?1% ",nativeQuery=true)
    public List<Computadora> computadorasByIp(String ip);


}
