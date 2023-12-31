package br.com.fiap.roadassist.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.roadassist.model.TypeWinchModel;
import br.com.fiap.roadassist.service.typeWinch.ITypeWinchService;
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
@RequestMapping("/typeWinch")
public class TypeWinchController {
    
    @Autowired
    private ITypeWinchService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody TypeWinchModel typeWinchModel, HttpServletRequest request){
        try {
            TypeWinchModel typeWinch = service.create(typeWinchModel);

            if(typeWinch == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Tipo de Guincho já está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(typeWinch);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TypeWinchModel typeWinchModel, @PathVariable Integer id, HttpServletRequest request){
        try {
            TypeWinchModel typeWinch = service.update(typeWinchModel, id);

            if(typeWinch == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Tipo de Guincho não está cadastrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body(typeWinch);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id, HttpServletRequest request){
        try {
            TypeWinchModel typeWinch = service.getById((Integer) id);

            if(typeWinch == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este Tipo de Guincho não existe");
            }

            return ResponseEntity.status(HttpStatus.OK).body(typeWinch);
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
            boolean typeWinchExists = service.delete(id);
            if(typeWinchExists == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Guincho não encontrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body("Tipo de Guincho Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + e.getStackTrace());
        }
    }


}
