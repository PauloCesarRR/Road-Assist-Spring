package br.com.fiap.roadassist.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.WinchDriverModel;
import br.com.fiap.roadassist.service.winchDriver.IWinchDriverService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/winchDriver")
public class WinchDriverController {
    
    @Autowired
    private IWinchDriverService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody WinchDriverModel winchDriverModel, HttpServletRequest request){
        try {
            WinchDriverModel winchDriver = this.service.create(winchDriverModel);

            if(winchDriver == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Motorista de Guincho já existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(winchDriver);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody WinchDriverModel winchDriverModel, @PathVariable Integer id, HttpServletRequest request){
        try {
            WinchDriverModel winchDriver = service.update(winchDriverModel, id);

            if(winchDriver == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Motorista de Guincho já existe");
            }

            return ResponseEntity.status(HttpStatus.OK).body(winchDriver);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id, HttpServletRequest request){
        try {
            WinchDriverModel winchDriver = service.getById(id);

            if(winchDriver == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este Motorista de Guincho não existe");
            }

            return ResponseEntity.status(HttpStatus.OK).body(winchDriver);
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
    public ResponseEntity<?> delete(@PathVariable Integer id, HttpServletRequest request){
        try {
            boolean winchDriverExists = service.delete(id);
            if(winchDriverExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista de Guincho não encontrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body("Motorista de Guincho deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
