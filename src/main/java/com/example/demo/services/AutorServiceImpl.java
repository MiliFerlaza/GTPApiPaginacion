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

@Service
public  class AutorServiceImpl extends BaseServicesImpl<Autor,Long> implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {

        super(baseRepository);
    }

    @Override
    public List<Autor> search(String filtro) throws Exception {

        try{

            //List<Autor> autores = autorRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);
            //    List<Autor> autores = autorRepository.search(filtro);
            List<Autor> autores = autorRepository.searchNativo(filtro);

            return autores;

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> search(String filtro, Pageable pageable) throws Exception {

        try{

            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);
            //    Page<Persona> personas = personaRepository.search(filtro);
            Page<Autor> autores = autorRepository.searchNativo(filtro, pageable);

            return autores;

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
