package org.springframework.samples.petclinic.vet.service;

import org.springframework.samples.petclinic.model.ResponseData;
import org.springframework.samples.petclinic.vet.model.VetDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
@Service
public class VetClient implements VetServiceInterface{
    @Override
    public Collection<VetDTO> allVets() {
        ResponseData result = new RestTemplate().getForObject("http://localhost:8080/api", ResponseData.class);
        return  result.getVets();
    }
}
