package org.springframework.samples.petclinic.model;

import org.springframework.samples.petclinic.vet.model.VetDTO;

import java.util.Collection;

public class ResponseData{
    public ResponseData() {}
    public ResponseData(Collection<VetDTO> vets) {
        this.vets = vets;
    }

    public Collection<VetDTO> getVets() {
        return vets;
    }

    public void setVets(Collection<VetDTO> vets) {
        this.vets = vets;
    }

    private Collection<VetDTO> vets;
}
