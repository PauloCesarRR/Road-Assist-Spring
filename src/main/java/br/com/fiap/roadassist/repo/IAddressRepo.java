package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.AddressModel;

public interface IAddressRepo extends JpaRepository<AddressModel, UUID>{

}
