package com.example.demo.repositories;

import com.example.demo.entities.Localidad;
import com.example.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long> {

    List<Localidad> findByDenominacionContaining(String denominacion);

    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);

    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%")
    List<Localidad> search(@Param("filtro") String filtro);

    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%")
    Page<Localidad> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Localidad> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
