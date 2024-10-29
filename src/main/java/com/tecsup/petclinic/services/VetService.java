package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

/**
 *
 * @author [Tu Nombre]
 *
 */
public interface VetService {

    /**
     * Crear un nuevo veterinario
     *
     * @param vet
     * @return
     */
    Vet create(Vet vet);

    /**
     * Actualizar un veterinario existente
     *
     * @param vet
     * @return
     */
    Vet update(Vet vet);

    /**
     * Eliminar un veterinario por ID
     *
     * @param id
     * @throws VetNotFoundException
     */
    void delete(Integer id) throws VetNotFoundException;

    /**
     * Buscar un veterinario por ID
     *
     * @param id
     * @return
     * @throws VetNotFoundException
     */
    Vet findById(Integer id) throws VetNotFoundException;

    /**
     * Buscar veterinarios por nombre
     *
     * @param firstName
     * @return
     */
    List<Vet> findByFirstName(String firstName);

    /**
     * Buscar veterinarios por apellido
     *
     * @param lastName
     * @return
     */
    List<Vet> findByLastName(String lastName);

    /**
     * Obtener todos los veterinarios
     *
     * @return
     */
    List<Vet> findAll();
}
