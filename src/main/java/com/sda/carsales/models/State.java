package com.sda.carsales.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class State {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String name;
	private String capital;
    private String code;

	@ManyToOne
	@JoinColumn(name="countryid", insertable=false, updatable=false)
	private Country country;
	private Integer countryid;
	private String details;


}
