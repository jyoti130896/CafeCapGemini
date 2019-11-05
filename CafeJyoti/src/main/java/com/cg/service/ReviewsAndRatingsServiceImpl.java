package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CafeDetails;
import com.cg.dto.CafeMenu;
import com.cg.dto.RatingMaster;
import com.cg.dto.ReviewsAndRatings;
import com.cg.dto.UserDetails;
import com.cg.exception.CafeNotFound;
import com.cg.exception.FeedbackNotFound;
import com.cg.exception.InvalidRating;
import com.cg.exception.ItemNotFound;
import com.cg.exception.UserNotFound;
import com.cg.repo.ReviewsAndRatingsRepo;

@Service
@Transactional
public class ReviewsAndRatingsServiceImpl implements ReviewsAndRatingsService {
	@Autowired
	ReviewsAndRatingsRepo repo;
	
	@Autowired
	CafeMenuService menuService;
	
	@Autowired
	UserDetailService userService;
	
	@Autowired
	RatingMasterService masterService;
	
	@Autowired
	CafeDetailsService cafeService;

	@Override
	public boolean giveReviewToItem(int userId, String itemName,String type,String review)throws UserNotFound,ItemNotFound {
		ReviewsAndRatings reviewsandratings=new ReviewsAndRatings();
		try {
		UserDetails user=userService.getById(userId);
		reviewsandratings.setUsers(user);
		}
		catch(Exception e) {
			throw new UserNotFound("User does not exist");
		}
		try {
		CafeMenu menu=menuService.getByItemName(itemName);
		
		reviewsandratings.setItem(menu);
		reviewsandratings.setReview(review);
		reviewsandratings.setTypes(type);
		reviewsandratings=repo.save(reviewsandratings);
		}
		catch(Exception e) {
			throw new ItemNotFound("Item does not exist");
		}
		
		RatingMaster master=new RatingMaster();
		master.setReview(review);
		master.setType(type);
		master.setReviewsandratings(reviewsandratings);
		masterService.addRatingMaster(master);
		
		return true;
			
		
	}

	@Override
	public boolean giveRatingToItem(int userId, String itemName,String type, int rating) throws UserNotFound,ItemNotFound{
		ReviewsAndRatings reviewsandratings=new ReviewsAndRatings();			
		
		try{
			UserDetails user=userService.getById(userId);
		reviewsandratings.setUsers(user);
		}
		catch(Exception e) {
			throw new UserNotFound("User does not exist");
		}
		try {
		CafeMenu menu=menuService.getByItemName(itemName);
		menu.setRating(rating);
		reviewsandratings.setItem(menu);
		reviewsandratings.setRating(rating);
		reviewsandratings.setTypes(type);
		reviewsandratings=repo.save(reviewsandratings);
		}
		catch(Exception e) {
			throw new ItemNotFound("Item does not exist");
		}
		RatingMaster master=new RatingMaster();
		master.setRating(rating);
		master.setType(type);
		master.setReviewsandratings(reviewsandratings);
		masterService.addRatingMaster(master);
		return true;
		
	}
	@Override
	public boolean giveRatingToCafe(int userId, String cafeLocation,String type,int rating) throws UserNotFound, CafeNotFound {
		
		ReviewsAndRatings reviewsandratings=new ReviewsAndRatings();
		try {
		UserDetails user=userService.getById(userId);
		reviewsandratings.setUsers(user);
		}
		catch(Exception e) {
			throw new UserNotFound("User does not exist");
		}
		try {
		CafeDetails cafe=cafeService.getByCafeLocation(cafeLocation);
		cafe.setRating(rating);
		reviewsandratings.setCafe(cafe);
		reviewsandratings.setRating(rating);
		reviewsandratings.setTypes(type);
		reviewsandratings=repo.save(reviewsandratings);
		}
		catch(Exception e) {
			throw new CafeNotFound("Cafe does not exist");
		}
		
		RatingMaster master=new RatingMaster();
		master.setRating(rating);
		master.setType(type);
		master.setReviewsandratings(reviewsandratings);
		masterService.addRatingMaster(master);
		return true;
		
	}

	@Override
	public boolean giveReviewToCafe(int userId, String cafeLocation, String type, String review)throws CafeNotFound,UserNotFound {
		ReviewsAndRatings reviewsandratings=new ReviewsAndRatings();
		try{
		UserDetails user=userService.getById(userId);
		reviewsandratings.setUsers(user);
		}
		catch(Exception e)
		{
			throw new UserNotFound("User does not exist");
		}
		try {
		CafeDetails cafe=cafeService.getByCafeLocation(cafeLocation);
		reviewsandratings.setCafe(cafe);
		reviewsandratings.setReview(review);
		reviewsandratings.setTypes(type);
		reviewsandratings=repo.save(reviewsandratings);
		}
		catch(Exception e) {
			throw new CafeNotFound("Cafe does not exist");
		}
		RatingMaster master=new RatingMaster();
		master.setReview(review);
		master.setType(type);
		master.setReviewsandratings(reviewsandratings);
		masterService.addRatingMaster(master);
		return true;
		
	}

	@Override
	public boolean deleteFeedback(int ratingId)throws InvalidRating {
		try {
		repo.deleteById(ratingId);
		return true;
		}
		catch(Exception e) {
			throw new InvalidRating("No Review or Rating exists with provided Id");
		}
	}

	@Override
	public List<ReviewsAndRatings> fetchByItemName(String itemName)throws ItemNotFound {
		try {
		CafeMenu cafe;
		cafe=menuService.getByItemName(itemName);
		return repo.getByItemName(cafe);
		}
		catch(Exception e) {
			throw new ItemNotFound("No such item exists");
		}
	}

	@Override
	public List<ReviewsAndRatings> fetchall() throws FeedbackNotFound{
		try {
		return repo.findAll();
		}
		catch(Exception e) {
			throw new FeedbackNotFound("No Feedback exists at the moment");
		}
	}
	@Override
	public List<ReviewsAndRatings> fetchByCafeLocation(String cafeLocation) throws CafeNotFound{
		try{
			CafeDetails cafe;
		cafe=cafeService.getByCafeLocation(cafeLocation);
		return repo.getByCafeLocation(cafe);
		}
		catch(Exception e) {
			throw new CafeNotFound("No Cafe Exists at specified Location");
		}
	}

	@Override
	public double getItemAverageRating(String itemName) throws ItemNotFound{
		try {
		CafeMenu menu;
		menu=menuService.getByItemName(itemName);
		return repo.getItemAverageRating(menu);
		}
		catch(Exception e) {
			throw new ItemNotFound("Item does not exist");
		}
	}
	@Override
	public double getCafeAverageRating(String cafeLocation) throws CafeNotFound {
		try {
		CafeDetails cafe;
		cafe=cafeService.getByCafeLocation(cafeLocation);
		return repo.getCafeAverageRating(cafe);
		}
		catch(Exception e) {
			throw new CafeNotFound("Cafe Location does not exist");
		}
		
	}
}
