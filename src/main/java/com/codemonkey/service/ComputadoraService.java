package com.codemonkey.service;

import java.util.List;
import com.codemonkey.entity.Computadora;

public interface ComputadoraService{
    public List<Computadora> getAllComputadoras(); 
    public Computadora getComputadoraById(long idcomputadora);
    public Computadora addComputadora(Computadora computadora);
    public Computadora updateComputadora(long idcomputadora,String bien,String arrendado, String asignado,String ip, String dns, String red,String operativo,String maquina, String tipo, String modelo,String dominio,String administrador,String ubicacion,String dispositivo,boolean estado,boolean actualizada, long iddepartamento);
    public void deleteComputadora(long idcomputadora);
}
