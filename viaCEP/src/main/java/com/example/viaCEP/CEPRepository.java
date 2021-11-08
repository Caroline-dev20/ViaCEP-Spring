package com.example.viaCEP;

import org.springframework.data.repository.CrudRepository;

public interface CEPRepository extends CrudRepository<CEP, Long>{
	
	CEP findByCep(String cep);

}
