package br.com.fiap.roadassist.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.StateModel;
import br.com.fiap.roadassist.service.state.IStateService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/state")
public class StateController {
    
    @Autowired
    private IStateService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody StateModel stateModel){
        try {
            if(stateModel.getName().toCharArray().length > 2){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A Sigla de um estado não pode ter mais que 2 caracteres");
            }

            StateModel state = service.create(stateModel);

            if(state == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Estado já está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(state);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody StateModel stateModel, @PathVariable UUID id){
        try {
            StateModel state = service.update(stateModel, id);

            if(state == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Estado não está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(state);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id){
        try {
            StateModel state = service.getById(id);

            if(state == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este Estado não existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(state);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try {
            boolean stateExists = service.delete(id);
            if(stateExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não encontrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Estado Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
