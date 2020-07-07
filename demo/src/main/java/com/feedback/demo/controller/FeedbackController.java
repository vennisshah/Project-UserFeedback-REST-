package com.feedback.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;
import com.feedback.demo.service.FeedbackService;


@RestController
public class FeedbackController {
	@Autowired
	private FeedbackService service;
	private MultiValueMap<String, String> map;
	
	@GetMapping("/feedback")
	public String sayWelcome() {
		return "Welcome to Feedback Page \n"
				+ "For Ratings: 1- Highly dissatisfied  2- somewhat dissatisfied 3- neutral 4-somewhat satisfied 5- Very satisfied \n"
				+ "Please use the ratings for fields product_quality,delivery,value_of_money,shopping_experience,after_sales_service and overall_ratings";
	
	}
	@PostMapping("/feedback")
	public ResponseEntity<Feedback> generateFeedback(@RequestBody Feedback feedback) {
		
		try {
			
			return new ResponseEntity<Feedback>(service.generateFeedback(feedback),HttpStatus.OK);
			
		} catch (BusinessException e) {
			
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_ACCEPTABLE);
		}
	
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping("/feedbacks/recommendation/{recommendation}")
	public List<Feedback> findByRecommendation(@PathVariable("recommendation") String recommendation){
		
		return service.getFeedbackByRecommendation(recommendation);
	}

	@PutMapping("/feedback")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) {
		try {
			return new ResponseEntity<Feedback>(service.updateFeedback(feedback),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/feedback/{id}")
	public void deleteFeedback(@PathVariable("id") int id) throws BusinessException {
		
			service.deleteFeedback(id);

		
	}

	@GetMapping("/feedbacks")
	public List<Feedback> getAllFeedbacks() {
		
		return service.getAllFeedbacks();
	}



}
