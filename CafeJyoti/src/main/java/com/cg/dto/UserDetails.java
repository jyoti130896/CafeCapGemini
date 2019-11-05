package com.cg.dto;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="user_details")
@SequenceGenerator(name = "userseq", sequenceName = "cafemenu_seq", initialValue = 500, allocationSize = 1)
public class UserDetails {
@Id
@GeneratedValue(generator = "userseq")
@Column(name="userId")
private int userId;

@Column(name="NAME", nullable=false)
private String name; 
private String password;

//@OneToMany(mappedBy="user",orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//private Set<ReviewsAndRatings> reviews_and_ratings;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public void setPassword(String password) {
	this.password = password;
}

public UserDetails(int userId, String name, String password, ReviewsAndRatings reviewsandratings) {
	super();
	this.userId = userId;
	this.name = name;
	this.password = password;
}
public UserDetails() {
	
}


//public Set<ReviewsAndRatings> getReviews_and_ratings() {
//	return reviews_and_ratings;
//}
//
//public void setReviews_and_ratings(Set<ReviewsAndRatings> reviews_and_ratings) {
//	this.reviews_and_ratings = reviews_and_ratings;
//}
}