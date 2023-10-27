package br.com.fiap.roadassist.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.CityModel;
import br.com.fiap.roadassist.service.city.ICityService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private ICityService service;

    @PostMapping("/")
    public ResponseEntity<?> create(HttpServletRequest request, @RequestBody CityModel cityModel){
        try {
            CityModel city = service.create(cityModel);

            if(city == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esta cidade já está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(city);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(HttpServletRequest request, @RequestBody CityModel cityModel, @PathVariable UUID id){
        try {
            CityModel city = service.update(cityModel, id);

            if(city == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esta cidade não está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(city);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(HttpServletRequest request, @PathVariable UUID id){
        try {
            CityModel city = service.getById(id);

            if(city == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta cidade não existe");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(city);
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
            boolean cityExists = service.delete(id);
            if(cityExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Cidade deletada com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
