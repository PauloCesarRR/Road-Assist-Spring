package br.com.fiap.roadassist.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.roadassist.model.WinchDriverModel;
import br.com.fiap.roadassist.repo.IWinchDriverRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import at.favre.lib.crypto.bcrypt.BCrypt;


@RestController
@RequestMapping("/winchDriver/")
public class WinchDriverController {
    
    @Autowired
    private IWinchDriverRepo repo;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody WinchDriverModel winchDriverModel){
    try {
        
    } catch (Exception e) {
        // TODO: handle exception
    }

        var winchDriver = this.repo.findByEmail(winchDriverModel.getEmail());

        if(winchDriver != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Motorista de Caminhão já existe");
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12,winchDriverModel.getPassword().toCharArray());

        winchDriverModel.setPassword(passwordHashred);

        var winchDriverCreated = this.repo.save(winchDriverModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(winchDriverCreated);
    }
}
