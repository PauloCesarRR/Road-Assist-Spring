package br.com.fiap.roadassist.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.AddressModel;
import br.com.fiap.roadassist.service.address.IAddressService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/address")
public class AddressController {
    
    @Autowired
    private IAddressService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody AddressModel addressModel, HttpServletRequest request){
        try {
            AddressModel address = service.create(addressModel);

            return ResponseEntity.status(HttpStatus.CREATED).body(address);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AddressModel AddressModel, HttpServletRequest request, @PathVariable UUID id){
        try {
            AddressModel address = service.update(AddressModel, id);

            if(address == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este endereço não está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(address);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(HttpServletRequest request, @PathVariable UUID id){
        try {
            AddressModel address = service.getById(id);

            if(address == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este endereço não existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(address);
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
    public ResponseEntity<?> delete(HttpServletRequest request, @PathVariable UUID id){
        try {
            boolean addressExists = service.delete(id);
            if(addressExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Endereço deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
