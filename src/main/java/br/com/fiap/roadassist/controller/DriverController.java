package br.com.fiap.roadassist.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.DriverModel;
import br.com.fiap.roadassist.service.driver.IDriverService;
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
@RequestMapping("/driver")
public class DriverController {
    
    @Autowired
    private IDriverService service;

    @PostMapping("/")
    public ResponseEntity<?> create(HttpServletRequest request, @RequestBody DriverModel driverModel){
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
    public ResponseEntity<?> update(HttpServletRequest request, @RequestBody DriverModel driverModel, @PathVariable Integer id){
        try {
            DriverModel driver = service.update(driverModel, id);

            if(driver == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Usuário já existe");
            }

            return ResponseEntity.status(HttpStatus.OK).body(driver);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(HttpServletRequest request, @PathVariable Integer id){
        try {
            DriverModel driver = service.getById(id);

            if(driver == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este Usuário não existe");
            }

            return ResponseEntity.status(HttpStatus.OK).body(driver);
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
            boolean driverExists = service.delete(id);
            if(driverExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body("Usuário Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
