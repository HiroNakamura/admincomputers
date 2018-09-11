package com.codemonkey.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codemonkey.entity.Departamento;
import com.codemonkey.repository.DepartamentoRepository;
import com.codemonkey.service.DepartamentoService;

import org.springframework.transaction.annotation.Transactional;


@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService {

        @Autowired
        private DepartamentoRepository departamentoRepository;

        @Override
        public List<Departamento> getAllDepartamentos() {
                return departamentoRepository.findAll();
        }
    
}
