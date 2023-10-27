package br.com.fiap.roadassist.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.TypeVehicleModel;
import br.com.fiap.roadassist.service.typeVehicle.ITypeVehicleService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/typeVehicle")
public class TypeVehicleController {
    
    @Autowired
    private ITypeVehicleService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody TypeVehicleModel typeVehicleModel, HttpServletRequest request){
        try {
            TypeVehicleModel typeVehicle = service.create(typeVehicleModel);

            if(typeVehicle == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Tipo de Veículo já está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(typeVehicle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TypeVehicleModel typeVehicleModel, @PathVariable UUID id, HttpServletRequest request){
        try {
            TypeVehicleModel typeVehicle = service.update(typeVehicleModel, id);

            if(typeVehicle == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Tipo de Veículo não está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(typeVehicle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id, HttpServletRequest request){
        try {
            TypeVehicleModel typeVehicle = service.getById(id);

            if(typeVehicle == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este Tipo de Veículo não existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(typeVehicle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(HttpServletRequest request){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id, HttpServletRequest request){
        try {
            boolean typeVehicleExists = service.delete(id);
            if(typeVehicleExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Veículo não encontrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Tipo de Veículo Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
