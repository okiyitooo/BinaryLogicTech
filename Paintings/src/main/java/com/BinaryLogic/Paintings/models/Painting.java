package com.BinaryLogic.Paintings.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paintings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Painting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "painting_id")
	private int id;

	@Column(name = "title",unique=true, nullable = false)
	private String title;
	
	private String artist;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private LocalDate date;
}
 