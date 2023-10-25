package br.com.fiap.roadassist.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.CallModel;
import br.com.fiap.roadassist.service.callWinch.ICallWinchService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/call")
public class CallWinchController {
    
    @Autowired
    private ICallWinchService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CallModel callModel){
        try {
            CallModel call = service.create(callModel);

            if(call == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Veículo já está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(call);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CallModel callModel, @PathVariable UUID id){
        try {
            CallModel call = service.update(callModel, id);

            if(call == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este chamado não está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(call);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id){
        try {
            CallModel call = service.getById(id);

            if(call == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este chamado não existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(call);
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
            boolean vehicleExists = service.delete(id);
            if(vehicleExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chamado não encontrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Chamado Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}