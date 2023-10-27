package br.com.fiap.roadassist.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.WinchModel;
import br.com.fiap.roadassist.service.winch.IWinchService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/winch")
public class WinchController {
    
    @Autowired
    private IWinchService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody WinchModel winchModel, HttpServletRequest request){
        try {
            WinchModel vehicle = service.create(winchModel);

            if(vehicle == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Veículo já está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody WinchModel WinchModel, @PathVariable Integer id, HttpServletRequest request){
        try {
            WinchModel vehicle = service.update(WinchModel, id);

            if(vehicle == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Veículo não está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id, HttpServletRequest request){
        try {
            WinchModel vehicle = service.getById(id);

            if(vehicle == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este Veículo não existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
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
    public ResponseEntity<?> delete(@PathVariable Integer id, HttpServletRequest request){
        try {
            boolean vehicleExists = service.delete(id);
            if(vehicleExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Veículo Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
