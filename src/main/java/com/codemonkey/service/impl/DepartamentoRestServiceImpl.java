package com.codemonkey.service.impl;

import com.codemonkey.entity.Departamento;
import com.codemonkey.repository.DepartamentoRestRepository;
import com.codemonkey.service.DepartamentoRestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("departamentoRestService")
public class DepartamentoRestServiceImpl implements DepartamentoRestService{

    @Autowired
    private DepartamentoRestRepository departamentoRestRepository;

    @Override
    public List<Departamento> getAllDepartamentos() {
        return departamentoRestRepository.findAll();
    }
    
}
