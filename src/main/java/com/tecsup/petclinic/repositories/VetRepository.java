package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Vet;

/**
 *
 * @author [Tu Nombre]
 *
 */
@Repository
public interface VetRepository extends JpaRepository<Vet, Integer> {

    // Buscar veterinarios por nombre
    List<Vet> findByFirstName(String firstName);

    // Buscar veterinarios por apellido
    List<Vet> findByLastName(String lastName);

    @Override
    List<Vet> findAll();
}
