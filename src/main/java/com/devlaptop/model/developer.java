package com.devlaptop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class developer{
	
	@Id
	private int developerId;
	private String developerName;
	private String developerRole;
	private String developerPhone;
	@OneToMany
	@JoinColumn(name="developerId")
	private List<laptop> devlaptop;
	
}
