package com.cg.dto;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ReviewsAndRatings")
@SequenceGenerator(name = "r_seq", sequenceName = "r_seq", initialValue = 500, allocationSize = 1)
//@NamedQuery(name = "fetchByName" ,query = "SELECT r FROM ReviewsAndRatings r WHERE r.item_name=:name")
//@NamedQuery(name = "deleteByName" ,query = "DELETE r FROM ReviewsAndRatings r where r.firstName =:name")
public class ReviewsAndRatings {
@Id
@GeneratedValue(generator = "r_seq")
private int ratingId;

private Date date;

//@ManyToOne
//@JoinColumn(name="user_id",referencedColumnName="userId")
//private UserDetails user;

@OneToOne
@JoinColumn(name = "user_id", referencedColumnName = "userId")
private UserDetails users;

@OneToMany(mappedBy = "reviewsandratings",cascade = CascadeType.ALL)
private Set<RatingMaster> ratings;

@OneToMany(mappedBy = "reviewsandratings",cascade = CascadeType.ALL)
private Set<RatingMaster> reviews;

@OneToMany(mappedBy = "reviewsandratings")
private Set<RatingMaster> type;

@OneToOne
@JoinColumn(name = "item_id", referencedColumnName = "itemId")
@JoinColumn(name = "itemName", referencedColumnName = "itemName")
private CafeMenu item;


@OneToOne
@JoinColumn(name = "cafe_id", referencedColumnName = "cafeId")
@JoinColumn(name = "cafeLocation", referencedColumnName = "cafeLocation")
private CafeDetails cafe;

@Column(length = 100)
private String review;

@Column(length = 100)
private int rating;

@Column(length = 100)
private String types;


public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}

public ReviewsAndRatings() {
		this.date = new Date(new java.util.Date().getTime());
	}
public ReviewsAndRatings(int ratingId, Date date,String review,int rating,String types, Set<RatingMaster> ratings, Set<RatingMaster> reviews,Set<RatingMaster> type) {
	super();
	this.ratingId = ratingId;
	this.type = type;
	this.date = date;
	this.review=review;
	this.rating=rating;
	this.ratings = ratings;
	this.reviews = reviews;
	this.types=types;
}

public String getTypes() {
	return types;
}
public void setTypes(String types) {
	this.types = types;
}
public int getRatingId() {
	return ratingId;
}
public void setRatingId(int ratingId) {
	this.ratingId = ratingId;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public UserDetails getUsers() {
	return users;
}
public void setUsers(UserDetails users) {
	this.users = users;
}
public CafeDetails getCafe() {
	return cafe;
}
public void setCafe(CafeDetails cafe) {
	this.cafe = cafe;
}
public void setItem(CafeMenu item) {
	this.item = item;
}

}
//@ManyToOne
//@JoinColumn(name="item_id",referencedColumnName="itemId")
//@JoinColumn(name="item_name",referencedColumnName="itemId")
//private CafeMenu menu;


//@OneToOne(fetch = FetchType.LAZY, optional = false)
//@JoinColumn(name = "item_id", nullable = false)
//private CafeMenu menu;



