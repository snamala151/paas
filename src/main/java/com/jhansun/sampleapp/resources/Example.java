package com.jhansun.sampleapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jhansun.sampleapp.model.ProductCategory;
import com.jhansun.sampleapp.repository.ProductRespository;

@RestController
public class Example {

	@Autowired
	ProductRespository productRepository;

    @RequestMapping("test")
    public @ResponseBody ResponseEntity<String> example() {
        
    	ProductCategory prod = new ProductCategory();
    	prod.setName("Furniture");
    	prod.setLogo("Logo");
    	prod.setUrl("url");
    	
    	productRepository.save(prod);
    	
        return new ResponseEntity<String>("successful", HttpStatus.OK);
    }

}
