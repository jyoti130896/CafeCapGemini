package com.cg.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RatingMaster")
@SequenceGenerator(name = "ir_seq", sequenceName = "ir_seq")
public class RatingMaster {
	@Id
	@GeneratedValue(generator = "ir_seq")
	private int irId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "rating_id", nullable = false)
	private ReviewsAndRatings reviewsandratings;
	
	@Column(length = 100)
	private String review;
	
	private int rating;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	
	private String type;
	
	public RatingMaster() {
		this.timestamp = new Date();
	}


	public RatingMaster(int irId, String review, int rating, Date timestamp,String type) {
		super();
		this.irId = irId;
		this.review = review;
		this.rating = rating;
		this.timestamp = timestamp;
		this.type=type;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getIrId() {
		return irId;
	}


	public void setIrId(int irId) {
		this.irId = irId;
	}
	
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


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public void setReviewsandratings(ReviewsAndRatings reviewsandratings) {
		this.reviewsandratings = reviewsandratings;
	}

	
}
