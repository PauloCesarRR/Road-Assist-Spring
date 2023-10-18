package br.com.fiap.roadassist.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.WinchDriverModel;
import br.com.fiap.roadassist.service.WinchDriverServiceImpl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/winchDriver/")
public class WinchDriverController {
    
    @Autowired
    private WinchDriverServiceImpl service;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody WinchDriverModel winchDriverModel){
        try {
            WinchDriverModel winchDriver = service.create(winchDriverModel);

            if(winchDriver == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Motorista de Caminhão já existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(winchDriver);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updata(@RequestBody WinchDriverModel winchDriverModel, @PathVariable UUID id){
        try {
            WinchDriverModel winchDriver = service.update(winchDriverModel, id);

            if(winchDriver == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Motorista de Caminhão já existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(winchDriver);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    
}
