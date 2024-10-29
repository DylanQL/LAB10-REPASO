package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;

/**
 *
 * @author [Tu Nombre]
 *
 */
@Service
public class VetServiceImpl implements VetService {

    @Autowired
    private VetRepository vetRepository;

    @Override
    public Vet create(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Vet update(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Integer id) throws VetNotFoundException {
        Vet vet = findById(id);
        vetRepository.delete(vet);
    }

    @Override
    public Vet findById(Integer id) throws VetNotFoundException {
        Optional<Vet> optionalVet = vetRepository.findById(id);
        if (optionalVet.isPresent()) {
            return optionalVet.get();
        } else {
            throw new VetNotFoundException("Veterinario no encontrado con ID: " + id);
        }
    }

    @Override
    public List<Vet> findByFirstName(String firstName) {
        return vetRepository.findByFirstName(firstName);
    }

    @Override
    public List<Vet> findByLastName(String lastName) {
        return vetRepository.findByLastName(lastName);
    }

    @Override
    public List<Vet> findAll() {
        return vetRepository.findAll();
    }
}
