package com.BinaryLogic.Paintings.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BinaryLogic.Paintings.models.Painting;

public interface PaintingRepository extends JpaRepository<Painting, Integer>{
	List<Painting> findAllByDate(LocalDate date);
}
