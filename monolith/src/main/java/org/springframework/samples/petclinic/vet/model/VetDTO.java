package org.springframework.samples.petclinic.vet.model;

import java.util.List;

public class VetDTO {

    private String firstName;
    private String lastName;
    private Integer nrOfSpecialties;
    private List<String> specialties;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNrOfSpecialties() {
        return nrOfSpecialties;
    }

    public void setNrOfSpecialties(Integer nrOfSpecialties) {
        this.nrOfSpecialties = nrOfSpecialties;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }
}
