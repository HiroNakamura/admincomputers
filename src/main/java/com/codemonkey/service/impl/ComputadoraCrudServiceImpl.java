package com.codemonkey.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codemonkey.entity.Computadora;
import com.codemonkey.repository.ComputadoraCrudRepository;
import com.codemonkey.service.ComputadoraCrudService;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("computadoraCrudService")
public class ComputadoraCrudServiceImpl implements ComputadoraCrudService {

    private final Logger LOGGER = LoggerFactory.getLogger(ComputadoraCrudServiceImpl.class);

    @Autowired
	private ComputadoraCrudRepository computadoraCrudRepository;

    @Override
    public List<Computadora> computadorasArrendadas(){
        return computadoraCrudRepository.computadorasArrendadas();
    }

    @Override
    public List<Computadora> computadorasNoArrendadas(){
        return computadoraCrudRepository.computadorasNoArrendadas();
    }

    @Override
    public List<Computadora> computadorasDispositivos(){
        return computadoraCrudRepository.computadorasDispositivos();
    }

    @Override
    public List<Computadora> computadorasByBien(String bien){
        return computadoraCrudRepository.computadorasByBien(bien);
    }

    @Override
    public List<Computadora> computadorasByArrendado(String arrendado){
        return computadoraCrudRepository.computadorasByArrendado(arrendado);
    }

    @Override
    public List<Computadora> computadorasByIp(String ip){
        return computadoraCrudRepository.computadorasByIp(ip);
    }
	
    @Override
    public List<Computadora> computadorasByDepartamento(String departamento){
        return computadoraCrudRepository.computadorasByDepartamento(departamento);
    }


}
