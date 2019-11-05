package com.cg.service;

import java.util.List;

import com.cg.dto.CafeMenu;
import com.cg.dto.ReviewsAndRatings;
import com.cg.exception.CafeNotFound;
import com.cg.exception.FeedbackNotFound;
import com.cg.exception.InvalidRating;
import com.cg.exception.ItemNotFound;
import com.cg.exception.UserNotFound;



public interface ReviewsAndRatingsService {
	boolean giveReviewToItem(int userId,String itemName,String type,String review) throws UserNotFound,ItemNotFound ;
	boolean giveRatingToItem(int userId, String itemName,String type,int rating) throws UserNotFound,ItemNotFound;
	boolean giveReviewToCafe(int userId,String cafeLocation,String type,String review) throws CafeNotFound,UserNotFound;
	boolean giveRatingToCafe(int userId, String cafeLocation, String type,int rating) throws CafeNotFound,UserNotFound;
	boolean deleteFeedback(int ratingId) throws InvalidRating;
	List<ReviewsAndRatings> fetchByItemName(String itemName) throws ItemNotFound;
	List<ReviewsAndRatings> fetchall() throws FeedbackNotFound;
	List<ReviewsAndRatings> fetchByCafeLocation(String cafeLocation) throws CafeNotFound;
	double getItemAverageRating(String itemName) throws ItemNotFound;
	double getCafeAverageRating(String cafeLocation) throws CafeNotFound;
}
