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
import com.jhansun.sampleapp.model.Kids;
import com.jhansun.sampleapp.model.Message;
import com.jhansun.sampleapp.repository.KidsRepository;

@RequestMapping("/api/kids")
@RestController
public class KidsResource {

	@Autowired
	KidsRepository kidsRepository;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Message> addKids(@RequestBody Kids kidsItem) {
		Kids createdOne = kidsRepository.save(kidsItem);
		Message msg = null;
		if (createdOne.getId() > 0) {
			msg = new Message("SUCCESS", "Kids added successfully");
			return new ResponseEntity<Message>(msg, HttpStatus.OK);
		}
		msg = new Message("ERROR", "There was an error while adding a Kids");
		return new ResponseEntity<Message>(msg, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Kids> getAllKids() {
		return kidsRepository.findAll();
	}

	@RequestMapping(value = "/{kidsId}", method = RequestMethod.DELETE)
	public List<Kids> deleteProduct(@PathVariable("kidsId") Integer kidsId) {
		kidsRepository.delete(kidsId);
		return kidsRepository.findAll();
	}
	
	@RequestMapping(value = "/{kidsId}", method = RequestMethod.GET)
	public Kids getKids(@PathVariable("kidsId") Integer kidsId) {
		return kidsRepository.findOne(kidsId);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateKids(@RequestBody Kids kidsItem) {
		Kids createdOne = kidsRepository.save(kidsItem);
		Message msg = null;
		if (createdOne.getId() > 0) {
			msg = new Message("SUCCESS", "Kids updated successfully");
			return new ResponseEntity<Message>(msg, HttpStatus.OK);
		}
		msg = new Message("ERROR", "There was an error while adding a Kids");
		return new ResponseEntity<Message>(msg, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
