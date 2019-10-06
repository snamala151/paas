package com.jhansun.sampleapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhansun.sampleapp.model.Furniture;
import com.jhansun.sampleapp.model.Message;
import com.jhansun.sampleapp.repository.FurnitureRespository;

@RequestMapping("/api/furnitures")
@RestController
public class FurnitureResource {

	@Autowired
	FurnitureRespository furnitureRepository;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Message> addFurniture(@RequestBody Furniture funrnitureItem) {
		Furniture createdOne = furnitureRepository.save(funrnitureItem);
		Message msg = null;
		if (createdOne.getId() > 0) {
			msg = new Message("SUCCESS", "Furniture added successfully");
			return new ResponseEntity<Message>(msg, HttpStatus.OK);
		}
		msg = new Message("ERROR", "There was an error while adding a Furniture");
		return new ResponseEntity<Message>(msg, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Furniture> getAllFurniture() {
		return furnitureRepository.findAll();
	}

	@RequestMapping(value = "/{furnitureId}", method = RequestMethod.DELETE)
	public List<Furniture> deleteProduct(@PathVariable("furnitureId") Integer furnitureId) {
		furnitureRepository.delete(furnitureId);
		return furnitureRepository.findAll();
	}
	
	@RequestMapping(value = "/{furnitureId}", method = RequestMethod.GET)
	public Furniture getFurniture(@PathVariable("furnitureId") Integer furnitureId) {
		return furnitureRepository.findOne(furnitureId);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateFurniture(@RequestBody Furniture funrnitureItem) {
		Furniture createdOne = furnitureRepository.save(funrnitureItem);
		Message msg = null;
		if (createdOne.getId() > 0) {
			msg = new Message("SUCCESS", "Furniture updated successfully");
			return new ResponseEntity<Message>(msg, HttpStatus.OK);
		}
		msg = new Message("ERROR", "There was an error while adding a Furniture");
		return new ResponseEntity<Message>(msg, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
