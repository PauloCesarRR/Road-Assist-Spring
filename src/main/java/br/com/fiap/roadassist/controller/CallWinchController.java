package br.com.fiap.roadassist.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.CallModel;
import br.com.fiap.roadassist.service.callWinch.ICallWinchService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/call")
public class CallWinchController {
    
    @Autowired
    private ICallWinchService service;

    @PostMapping("/")
    public ResponseEntity<?> create(HttpServletRequest request, @RequestBody CallModel callModel){
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
    public ResponseEntity<?> update(HttpServletRequest request, @RequestBody CallModel callModel, @PathVariable Integer id){
        try {
            CallModel call = service.update(callModel, id);

            if(call == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este chamado não está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body(call);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(HttpServletRequest request, @PathVariable Integer id){
        try {
            CallModel call = service.getById(id);

            if(call == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este chamado não existe");
            }

            return ResponseEntity.status(HttpStatus.OK).body(call);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(HttpServletRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(HttpServletRequest request, @PathVariable Integer id){
        try {
            boolean vehicleExists = service.delete(id);
            if(vehicleExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chamado não encontrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body("Chamado Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
