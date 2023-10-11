package com.example.demo.services;

import com.example.demo.entities.Autor;
import com.example.demo.entities.Persona;
import com.example.demo.repositories.AutorRepository;
import com.example.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AutorService extends BaseServices<Autor,Long>  {

    List<Autor> search(String filtro) throws Exception;

    Page<Autor> search(String filtro, Pageable pageable) throws Exception;
}
