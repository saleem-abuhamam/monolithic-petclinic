/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.vet.controller;

import org.springframework.samples.petclinic.vet.model.VetDTO;
import org.springframework.samples.petclinic.vet.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@RestController
class VetController {

    private final VetService service;

    public VetController(VetService vetService) {
        this.service = vetService;
    }

    @GetMapping("/api")
    public ResponseData getAllVets() {
        return new ResponseData(this.service.allVets());
    }

    public class ResponseData{
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
}
