package com.cg.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cafedetails")
@SequenceGenerator(name = "cafeseq", sequenceName = "cafedetails_seq", initialValue = 100, allocationSize = 1)
public class CafeDetails implements Serializable {

	@Id
	@GeneratedValue(generator = "cafeseq")
	@Column(name="cafeId")
	private int cafeId;
	
	@Column(name="cafeLocation")
	private String cafeLocation;
	private int rating;
	
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "detailandmenu", 
			joinColumns = @JoinColumn(referencedColumnName = "cafeId"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "itemId"))
	Set<CafeMenu> menus;

	public int getCafeId() {
		return cafeId;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public String getCafeLocation() {
		return cafeLocation;
	}

	public void setCafeLocation(String cafeLocation) {
		this.cafeLocation = cafeLocation;
	}

	
}
