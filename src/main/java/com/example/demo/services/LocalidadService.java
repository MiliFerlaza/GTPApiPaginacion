package com.example.demo.services;

import com.example.demo.entities.Localidad;
import com.example.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocalidadService extends BaseServices<Localidad,Long>{

    List<Localidad> search(String filtro) throws Exception;

    Page<Localidad> search(String filtro, Pageable pageable) throws Exception;
}
