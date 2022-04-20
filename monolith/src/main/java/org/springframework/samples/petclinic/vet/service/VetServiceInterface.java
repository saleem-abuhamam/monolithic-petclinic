package org.springframework.samples.petclinic.vet.service;

import org.springframework.samples.petclinic.vet.model.VetDTO;

import java.util.Collection;

public interface VetServiceInterface {
    Collection<VetDTO> allVets();
}
