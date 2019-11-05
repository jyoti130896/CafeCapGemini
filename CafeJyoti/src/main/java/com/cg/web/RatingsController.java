package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CafeMenu;
import com.cg.dto.ReviewsAndRatings;
import com.cg.exception.CafeNotFound;
import com.cg.exception.FeedbackNotFound;
import com.cg.exception.InvalidRating;
import com.cg.exception.ItemNotFound;
import com.cg.exception.UserNotFound;
import com.cg.service.ReviewsAndRatingsService;

@RestController
@RequestMapping(value = "/feedback")
public class RatingsController {
@Autowired
private ReviewsAndRatingsService service;
@PostMapping(value = "/addItemReview/{userId}/{itemName}/{type}/{review}", produces = "application/json")
public boolean giveReviewToItem(@PathVariable("userId") int userId,@PathVariable("itemName") String itemName,@PathVariable("type") String type,@PathVariable("review") String review) throws ItemNotFound, UserNotFound {
	return service.giveReviewToItem(userId, itemName, type, review);
}
@PostMapping(value = "/addItemRating/{userId}/{itemName}/{type}/{rating}", produces = "application/json")
public boolean giveRatingToItem(@PathVariable("userId") int userId,@PathVariable("itemName") String itemName ,@PathVariable("type") String type,@PathVariable("rating") int rating) throws ItemNotFound, UserNotFound {
	return service.giveRatingToItem(userId, itemName, type, rating);
}
@PostMapping(value = "/addCafeRating/{userId}/{cafeName}/{type}/{rating}", produces = "application/json")
public boolean giveRatingToCafe(@PathVariable("userId") int userId,@PathVariable("cafeName") String cafeName,@PathVariable("type") String type,@PathVariable("rating") int rating) throws CafeNotFound, UserNotFound {
	return service.giveRatingToCafe(userId, cafeName, type, rating);
}
@PostMapping(value = "/addCafeReview/{userId}/{cafeName}/{type}/{review}", produces = "application/json")
public boolean giveReviewToCafe(@PathVariable("userId") int userId,@PathVariable("cafeName") String cafeName,@PathVariable("type") String type,@PathVariable("review") String review) throws CafeNotFound, UserNotFound {
	return service.giveReviewToCafe(userId, cafeName, type, review);
}
@DeleteMapping(value = "/deleteFeedback/{ratingId}", produces = "application/json")
public boolean deleteFeedback(@PathVariable("ratingId") int ratingId) throws InvalidRating {
	return service.deleteFeedback(ratingId);
}
@GetMapping(value = "/getAll",produces = "application/json")
public List<ReviewsAndRatings> fetchAll() throws FeedbackNotFound {
	return service.fetchall();
}
@GetMapping(value = "/getFeedbackByItemName/{itemName}",produces = "application/json")
 public List<ReviewsAndRatings> fetchByItemName(@PathVariable  String itemName) throws ItemNotFound {
	return service.fetchByItemName(itemName);
}	
@GetMapping(value="/getFeedbackByCafeLocation/{cafeLocation}",produces="application/json")
public List<ReviewsAndRatings> fetchByCafeLocation(@PathVariable String cafeLocation) throws CafeNotFound{
	return service.fetchByCafeLocation(cafeLocation);
}
@GetMapping(value="/getItemAverageRating/{itemName}",produces="application/json")
public double fetchItemAverageRating(@PathVariable String itemName) throws ItemNotFound{
	return service.getItemAverageRating(itemName);
}
@GetMapping(value="/getCafeAverageRating/{cafeLocation}",produces="application/json")
public double fetechCafeAverageRating(@PathVariable String cafeLocation) throws CafeNotFound {
	return service.getCafeAverageRating(cafeLocation);
}
}

