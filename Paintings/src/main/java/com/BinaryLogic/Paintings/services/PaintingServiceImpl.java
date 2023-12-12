
package com.BinaryLogic.Paintings.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BinaryLogic.Paintings.models.Painting;
import com.BinaryLogic.Paintings.repositories.PaintingRepository;

@Service
public class PaintingServiceImpl implements PaintingService {
	@Autowired
	private PaintingRepository paintingRepository;

	@Override
	public Painting createPainting(Painting painting) {
		return this.paintingRepository.save(painting);
	}

	@Override
	public List<Painting> getAllPaintings() {
		return this.paintingRepository.findAll();
	}

	@Override
	public Optional<Painting> getPaintingById(int paintingId) {
		return this.paintingRepository.findById(paintingId);
	}

	@Override
	public Painting updatePaintingById(int paintingId, Painting painting) {
		painting.setId(paintingId);
		return this.paintingRepository.save(painting);
	}

	@Override
	public ResponseEntity<?> deletePaintingById(int paintingId) {
		Optional<Painting> painting = this.getPaintingById(paintingId);
		if (painting.isPresent()) {
			this.paintingRepository.deleteById(paintingId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public List<Painting> getPaintingByDate(LocalDate date) {
		return this.paintingRepository.findAllByDate(date);
	}
}
