package com.cg.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cafemenu")
@SequenceGenerator(name = "menuseq", sequenceName = "cafemenu_seq", initialValue = 1, allocationSize = 1)
public class CafeMenu implements Serializable{

	@Id
	@GeneratedValue(generator = "menuseq")
	@Column(name="itemId")
	private int itemId;
	@Column(name="itemName")
	private String itemName;
	private String itemType;
	private double itemPrice;
	private int rating;
	
	
	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

	public CafeMenu() {
		// TODO Auto-generated constructor stub
	}
	
	
//	@OneToOne(mappedBy = "menu",fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
//	private ReviewsAndRatings reviews_and_ratings; 
	
	//@OneToMany(mappedBy="menu",orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	//private Set<ReviewsAndRatings> reviews_and_ratings;
	
	
	


	public CafeMenu(int itemId, String itemName, String itemType, double itemPrice, int rating,
		Set<CafeDetails> details, ReviewsAndRatings reviewsandratings) {
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.itemType = itemType;
	this.itemPrice = itemPrice;
	this.rating = rating;
	this.details = details;
	
}

	

	@ManyToMany(mappedBy = "menus", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<CafeDetails> details;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
}
