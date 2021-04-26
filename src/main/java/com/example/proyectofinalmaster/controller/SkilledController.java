package com.example.proyectofinalmaster.controller;

import com.example.proyectofinalmaster.model.Skilled;
import com.example.proyectofinalmaster.service.SkilledService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SkilledController {

    private final SkilledService skilledService;

    public SkilledController(SkilledService skilledService) {
        this.skilledService = skilledService;
    }

    /**
     * RETRIEVE - Find all skilled with multiple parameters
     * @param size The name by which it will be filtered
     * @param pagination  pagination - The name by which it will be filtered
     * @param name  name - The name by which it will be filtered
     * @param modality  modality - The name by which it will be filtered
     * @param state state - The name by which it will be filtered
     * @return ResponseEntity
     */
    @GetMapping("/skilled")
    public ResponseEntity<List<Skilled>> findAllSkilled (@RequestParam(name = "size", required = false, defaultValue = "10") int size,
                                                        @RequestParam(name = "pagination", required = false, defaultValue = "0") int pagination,
                                                        @RequestParam(name = "name", required = false) String name,
                                                        @RequestParam(name = "modality", required = false) String modality,
                                                        @RequestParam(name = "state", required = false) String state,
                                                         @RequestParam(name = "score", required = false) String score) {

        if (name != null) { //Consulta de nam pasandole el limite y la paginación
////////////
            List<Skilled> skilledsName = skilledService.findByName(name, size, pagination);
            if (!skilledsName.isEmpty())
            return ResponseEntity.ok().body(skilledsName);

/////////////
        }else if (modality != null) {  //Consulta de mod pasandole el limite y la paginación

            List<Skilled> skilledsModal = skilledService.findByModality(modality, size, pagination);
            if (!skilledsModal.isEmpty())
            return ResponseEntity.ok().body(skilledsModal);

/////////////
        } else if (state != null) {  //Consulta de st pasandole el limite y la paginación
/////////////
            List<Skilled> skilledsState = skilledService.findByState(state, size, pagination);
            if (!skilledsState.isEmpty())
            return ResponseEntity.ok().body(skilledsState);

        } else if (score != null) {  //Consulta de st pasandole el limite y la paginación
/////////////
            List<Skilled> skilledsScore = skilledService.findByScore(score, size, pagination);
            if (!skilledsScore.isEmpty())
                return ResponseEntity.ok().body(skilledsScore);
/////////////
        }
            return ResponseEntity.ok().body(skilledService.findAllSkilled(size,pagination));
    }

    /**
     * RETRIEVE - Find skilled by id
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from SkilledService
     */
    @GetMapping("/skilled_id")
    public Skilled findSkilledById(@RequestParam Long id) {
        return skilledService.findSkilledId(id);
    }

    /**
     * CREATE - Create skilled in Postman
     *
     * @param skilleddata The name by which it will be filtered
     * @return The call from SkilledService
     */
    @PostMapping("/create_skilled")
    public Skilled createSkilled(@RequestBody Skilled skilleddata) {
        return skilledService.createSkilled(skilleddata);
    }

    /**
     * UPDATE - Update an skilled by id in Postman
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from SkilledService
     */
    @PutMapping("/update_skilled")
    public Skilled updateSkilledById(@RequestParam Long id, @RequestBody Skilled skilleddata) {
        Skilled skilled = skilledService.findSkilledId(id);
        skilleddata.setId(skilled.getId());
        return skilledService.updateSkilled(skilleddata);
    }

    /**
     * DELETE - Delete an skilled by id in Postman
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from TagService
     */
    @DeleteMapping("/delete_skilled")
    public Skilled deleteSkilled(@RequestParam Long id) {
        return skilledService.deleteSkilled(id);
    }
}



