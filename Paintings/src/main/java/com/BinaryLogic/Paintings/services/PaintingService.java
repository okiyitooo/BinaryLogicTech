package com.BinaryLogic.Paintings.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.BinaryLogic.Paintings.models.Painting;

public interface PaintingService {

	Painting createPainting(Painting painting);
	
	List<Painting> getAllPaintings();

	Optional<Painting> getPaintingById(int paintingId);

	Painting updatePaintingById(int paintingId, Painting painting);

	ResponseEntity<?> deletePaintingById(int paintingId);

	List<Painting> getPaintingByDate(LocalDate date);
}
