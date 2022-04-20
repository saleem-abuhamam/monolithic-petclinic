package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.samples.petclinic.vet.model.VetDTO;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloWorldController.class)
public class MockMvcDemoTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void receive_hello_world() throws Exception {
        mockMvc.perform(get("/api"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("hello world"));
    }
}

@RestController
class HelloWorldController {

    /**
     * responds with the json:
     *
     * { "message": "hello world" }
     */
    @GetMapping("/api")
    public List<VetDTO> getAllVets() {
        return this.getAllVets();
    }

    private static class ResponseData {
        private final String message;

        public ResponseData(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
