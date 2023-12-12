package com.BinaryLogic.Paintings.controllers;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BinaryLogic.Paintings.models.Painting;
import com.BinaryLogic.Paintings.services.PaintingService;

@RestController
@RequestMapping("/paintings")
public class PaintingsController {
	@Autowired
	private PaintingService paintingService;
	
	@PostMapping
	public ResponseEntity<Painting> createPainting(@RequestBody Painting painting) {
		try {
			this.paintingService.createPainting(painting);
			return new ResponseEntity<>(painting, HttpStatus.OK);
		} catch (Exception ex){
			return new ResponseEntity<>(painting, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Painting>> getAllPaintings() {
		List<Painting> paintings = this.paintingService.getAllPaintings();
		if (paintings!=null && !paintings.isEmpty()) {
			
			return new ResponseEntity<>(paintings,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping("/id/{paintingId}")
	public ResponseEntity<Painting> getPaintingById(@PathVariable int paintingId) {
		Optional<Painting> painting = paintingService.getPaintingById(paintingId);
		if (painting.isPresent())
			return new ResponseEntity<>(painting.get(),HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/id/{paintingId}")
	public ResponseEntity<Painting> updatePaintingById(@PathVariable int paintingId, @RequestBody Painting painting) {
		Optional<Painting> optionalPainting = this.paintingService.getPaintingById(paintingId);
		if (!optionalPainting.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try {
			this.paintingService.updatePaintingById(paintingId, painting);
			return new ResponseEntity<>(painting, HttpStatus.OK);
		} catch (Exception ex){
			return new ResponseEntity<>(painting, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/id/{paintingId}")
	public ResponseEntity<Painting> deletePaintingById(@PathVariable int paintingId) {
		Optional<Painting> painting = paintingService.getPaintingById(paintingId);
		if (painting.isPresent()) {
			this.paintingService.deletePaintingById(paintingId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/date/{date}")
	public List<Painting> getPaintingsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return this.paintingService.getPaintingByDate(date);
	}
}
