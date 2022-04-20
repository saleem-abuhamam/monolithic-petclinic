package org.springframework.samples.petclinic.vet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.vet.model.VetDTO;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VetServiceTests {
    @Autowired
    VetServiceInterface vetService;

    @Test
    void shouldFindVets() {
        Collection<VetDTO> vets = vetService.allVets();

        assertThat(vets)
                .filteredOn(vet -> "Douglas".equals(vet.getLastName()))
                .hasSize(1)
                .first()
                .hasFieldOrPropertyWithValue("lastName", "Douglas")
                .hasFieldOrPropertyWithValue("nrOfSpecialties", 2)
                .extracting(VetDTO::getSpecialties).asList()
//                .extracting("name")
                .containsExactly("dentistry", "surgery");
    }
}
