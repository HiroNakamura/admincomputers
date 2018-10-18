package com.codemonkey.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codemonkey.entity.Computadora;
import com.codemonkey.repository.ComputadoraRepository;
import com.codemonkey.service.ComputadoraService;

import com.codemonkey.entity.Departamento;
import com.codemonkey.repository.DepartamentoRepository;
import com.codemonkey.service.DepartamentoService;


import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("computadoraService")
public class ComputadoraServiceImpl implements ComputadoraService {
        private final Logger LOGGER = LoggerFactory.getLogger(ComputadoraServiceImpl.class);

        @Autowired
        private ComputadoraRepository computadoraRepository;

        @Autowired
        private DepartamentoRepository departamentoRepository;

        @Override
        public List<Computadora> getAllComputadoras() {
        	return computadoraRepository.findAll();
        }

        @Override
        public Computadora getComputadoraById(long idcomputadora) {
        	return computadoraRepository.findById(idcomputadora).orElse(null);
        }

        @Override
        public Computadora addComputadora(Computadora computadora) {
                LOGGER.info("--Has agredado computadora -> addComputadora("+computadora+")");
                return computadoraRepository.save(computadora);
        }

        @Override
        public Computadora updateComputadora(long idcomputadora,String bien,String arrendado, 
                String asignado,String ip, String dns, 
                String red,String operativo,String maquina, String tipo, String modelo,String dominio,
                String administrador,String ubicacion,String dispositivo,boolean estado,boolean actualizada, long iddepartamento){
                        LOGGER.info("--Has entrado a #updateComputadora");
                Computadora computadoraUpdate = computadoraRepository.findById(idcomputadora).orElse(null);
                Departamento departamentoId = departamentoRepository.findById(iddepartamento).orElse(null);
                if(computadoraUpdate != null && departamentoId != null){
                        LOGGER.info("--Computadora existe:"+computadoraUpdate);
                        try{
                                computadoraUpdate.setBien(bien);
                                computadoraUpdate.setArrendado(arrendado);
                                computadoraUpdate.setAsignado(asignado);
                                computadoraUpdate.setIp(ip);
                                computadoraUpdate.setDns(dns);
                                computadoraUpdate.setRed(red);
                                computadoraUpdate.setOperativo(operativo);
                                computadoraUpdate.setMaquina(maquina);
                                computadoraUpdate.setTipo(tipo);
                                computadoraUpdate.setModelo(modelo);
                                computadoraUpdate.setDominio(dominio);
                                computadoraUpdate.setAdministrador(administrador);
                                computadoraUpdate.setUbicacion(ubicacion);
                                computadoraUpdate.setDispositivo(dispositivo);
                                computadoraUpdate.setEstado(estado);
                                computadoraUpdate.setActualizada(actualizada);
                                computadoraUpdate.setDepartamento(departamentoId);
                                LOGGER.info("--Has actualizado computadora:"+computadoraUpdate);
                                return computadoraRepository.save(computadoraUpdate);
                        }catch(Exception ex){
                                LOGGER.info("--#Ha ocurrido una excepcion: "+ex.toString());
                                LOGGER.info("--#Causa"+ex.getCause());
                                ex.printStackTrace();
                        }
                        
                }
                return null;
        }


        @Override
        public void deleteComputadora(long idcomputadora){
                Computadora computadoraEliminar = computadoraRepository.findById(idcomputadora).orElse(null);
                if(computadoraEliminar != null){
                        LOGGER.info("--Has eliminado la computadora:"+computadoraEliminar);
                        computadoraRepository.delete(computadoraEliminar);
                }
        }

    
}
