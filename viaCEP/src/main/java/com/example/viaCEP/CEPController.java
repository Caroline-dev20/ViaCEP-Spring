package com.example.viaCEP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CEPController {
	
	@Autowired
	private CEPRepository repository;
	
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CEP> getCEP(@PathVariable("cep") String cep) {
		CEP cepObj = repository.findByCep(cep);
		return new ResponseEntity<CEP>(cepObj, HttpStatus.OK);
	}

}
