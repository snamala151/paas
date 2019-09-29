package com.jhansun.sampleapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhansun.sampleapp.model.Message;
import com.jhansun.sampleapp.model.ProductCategory;
import com.jhansun.sampleapp.repository.ProductRespository;

@RequestMapping("/api/products")
@RestController
public class ProductCategoryResource {

	@Autowired
	ProductRespository productRepository;

	@RequestMapping(value = "/", method = RequestMethod.POST)
    public  ResponseEntity<Message> addProductCategory(@RequestBody ProductCategory productCategory) {
    	ProductCategory createdOne = productRepository.save(productCategory);
    	Message msg = null;
    	if(createdOne.getId()>0){
    		msg = new Message("SUCCESS", "Product added successfully");
    		return new ResponseEntity<Message>(msg, HttpStatus.OK);
    	}
    	msg = new Message("ERROR", "There was an error while adding a product");
    	return new ResponseEntity<Message>(msg, HttpStatus.SERVICE_UNAVAILABLE);
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProductCategory> getAllProducts() {
    	return productRepository.findAll();
    }   

}
