package br.com.fiap.roadassist.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.DriverModel;
import br.com.fiap.roadassist.service.IDriverService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/driver")
public class DriverController {
    
    @Autowired
    private IDriverService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody DriverModel driverModel){
        try {
            DriverModel driver = service.create(driverModel);

            if(driver == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Usuário já existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(driver);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DriverModel driverModel, @PathVariable UUID id){
        try {
            DriverModel driver = service.update(driverModel, id);

            if(driver == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Usuário já existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(driver);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id){
        try {
            DriverModel driver = service.getById(id);

            if(driver == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este Usuário não existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(driver);
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
            boolean driverExists = service.delete(id);
            if(driverExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
