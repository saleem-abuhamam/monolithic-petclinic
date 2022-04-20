package org.springframework.samples.petclinic;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.ResponseData;
import org.springframework.samples.petclinic.vet.model.VetDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

public class WiremockDemoTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8089));

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void how_to_stub_a_server_with_wiremock() {
        wireMock.stubFor(get(urlEqualTo("/api"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody("{\"vets\":[{\"firstName\":\"James\",\"lastName\":\"Carter\",\"nrOfSpecialties\":0,\"specialties\":[]},{\"firstName\":\"Helen\",\"lastName\":\"Leary\",\"nrOfSpecialties\":1,\"specialties\":[\"radiology\"]},{\"firstName\":\"Linda\",\"lastName\":\"Douglas\",\"nrOfSpecialties\":2,\"specialties\":[\"dentistry\",\"surgery\"]},{\"firstName\":\"Rafael\",\"lastName\":\"Ortega\",\"nrOfSpecialties\":1,\"specialties\":[\"surgery\"]},{\"firstName\":\"Henry\",\"lastName\":\"Stevens\",\"nrOfSpecialties\":1,\"specialties\":[\"radiology\"]},{\"firstName\":\"Sharon\",\"lastName\":\"Jenkins\",\"nrOfSpecialties\":0,\"specialties\":[]}]}")));


        ResponseData result = new RestTemplate().getForObject("http://localhost:8089/api", ResponseData.class);

        assertThat(result.getVets()).hasSize(6);
    }
}
