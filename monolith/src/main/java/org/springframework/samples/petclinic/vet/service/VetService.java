package org.springframework.samples.petclinic.vet.service;

import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.samples.petclinic.vet.model.Specialty;
import org.springframework.samples.petclinic.vet.model.Vet;
import org.springframework.samples.petclinic.vet.model.VetDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;


public class VetService implements VetServiceInterface {

    private final VetRepository vets;

    public VetService(VetRepository vets) {
        this.vets = vets;
    }

    @Override
    public Collection<VetDTO> allVets() {
        return mapToDto(this.vets.findAll());
    }

    private Collection<VetDTO> mapToDto(Collection<Vet> vets) {
        Collection<VetDTO> collection = new LinkedList<>();
        for (Vet vet : vets) {
            VetDTO dto = new VetDTO();
            dto.setFirstName(vet.getFirstName());
            dto.setLastName(vet.getLastName());
            dto.setSpecialties(vet.getSpecialties().stream().map(Specialty::getName).collect(Collectors.toList()));
            dto.setNrOfSpecialties(vet.getNrOfSpecialties());
            collection.add(dto);
        }
        return collection;
    }
}
