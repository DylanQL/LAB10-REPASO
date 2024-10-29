package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testFindVetById() {
        Integer ID = 1;
        Vet vet = null;

        try {
            vet = this.vetService.findById(ID);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }
        assertNotNull(vet);
        assertEquals(ID, vet.getId());
    }

    @Test
    public void testFindVetByFirstName() {
        String FIND_FIRST_NAME = "James";
        List<Vet> vets = this.vetService.findByFirstName(FIND_FIRST_NAME);
        assertNotNull(vets);
        assertTrue(vets.size() > 0);
    }

    @Test
    public void testFindVetByLastName() {
        String FIND_LAST_NAME = "Carter";
        List<Vet> vets = this.vetService.findByLastName(FIND_LAST_NAME);
        assertNotNull(vets);
        assertTrue(vets.size() > 0);
    }

    @Test
    public void testCreateVet() {
        String FIRST_NAME = "John";
        String LAST_NAME = "Doe";

        Vet vet = new Vet(FIRST_NAME, LAST_NAME);

        Vet vetCreated = this.vetService.create(vet);

        log.info("VET CREATED :" + vetCreated.toString());

        assertNotNull(vetCreated.getId());
        assertEquals(FIRST_NAME, vetCreated.getFirstName());
        assertEquals(LAST_NAME, vetCreated.getLastName());
    }

    @Test
    public void testUpdateVet() {

        String FIRST_NAME = "Michael";
        String LAST_NAME = "Smith";

        String UP_FIRST_NAME = "Mike";
        String UP_LAST_NAME = "Johnson";

        Vet vet = new Vet(FIRST_NAME, LAST_NAME);

        // Crear
        log.info(">" + vet);
        Vet vetCreated = this.vetService.create(vet);
        log.info(">>" + vetCreated);

        // Actualizar
        vetCreated.setFirstName(UP_FIRST_NAME);
        vetCreated.setLastName(UP_LAST_NAME);

        // Ejecutar actualización
        Vet updatedVet = this.vetService.update(vetCreated);
        log.info(">>>>" + updatedVet);

        // Validar
        assertEquals(UP_FIRST_NAME, updatedVet.getFirstName());
        assertEquals(UP_LAST_NAME, updatedVet.getLastName());
    }

    @Test
    public void testDeleteVet() {

        String FIRST_NAME = "Robert";
        String LAST_NAME = "Brown";

        // Crear
        Vet vet = new Vet(FIRST_NAME, LAST_NAME);
        vet = this.vetService.create(vet);
        log.info("" + vet);

        // Eliminar
        try {
            this.vetService.delete(vet.getId());
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        // Validar
        try {
            this.vetService.findById(vet.getId());
            fail("Se esperaba una VetNotFoundException");
        } catch (VetNotFoundException e) {
            assertTrue(true);
        }
    }
}
