package com.codemonkey.service;

import java.util.List;
import com.codemonkey.entity.Computadora;

public interface ComputadoraCrudService{
    public List<Computadora> computadorasArrendadas();
    public List<Computadora> computadorasNoArrendadas();
    public List<Computadora> computadorasDispositivos();

    public List<Computadora> computadorasByBien(String bien);
    public List<Computadora> computadorasByArrendado(String arrendado);
    public List<Computadora> computadorasByIp(String ip);
    public List<Computadora> computadorasByDepartamento(String departamento);
}
