package com.sda.carsales.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Employee extends Person {
		
	@ManyToOne
	@JoinColumn(name="employeetypeid", insertable=false, updatable=false)
	private EmployeeType employeeType;
	private Integer employeetypeid;
	private String photo;
	private String username;
	
	@ManyToOne
	@JoinColumn(name="jobtitleid", insertable=false, updatable=false)
	private JobTitle jobTitle;
	private Integer jobtitleid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date hireDate;
}
