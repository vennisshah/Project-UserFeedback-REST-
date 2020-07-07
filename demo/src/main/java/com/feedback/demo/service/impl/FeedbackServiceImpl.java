package com.feedback.demo.service.impl;



import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feedback.demo.dao.FeedbackDAO;
import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;
import com.feedback.demo.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
@Autowired
private FeedbackDAO dao;

	@Override
	public Feedback generateFeedback(Feedback feedback) throws BusinessException {
		if (!isValidName(feedback.getName())) {
			throw new BusinessException("Entered name " + feedback.getName() + " is invalid");
		}
		if (!isValidEmail(feedback.getEmail())) {
			throw new BusinessException("Entered email-id " + feedback.getEmail() + " is invalid");
		}
		if (!isValidRate(feedback.getAfter_sales_service())) {
			throw new BusinessException("Entered rating value " + feedback.getAfter_sales_service() + " is invalid");
		}
		
		if (!isValidRate(feedback.getDelivery())) {
			throw new BusinessException("Entered rating value " + feedback.getDelivery() + " is invalid");
		}
		if (!isValidRate(feedback.getOverall_ratings())) {
			throw new BusinessException("Entered rating value " + feedback.getOverall_ratings() + " is invalid");
		}
		if (!isValidRate(feedback.getProduct_quality())) {
			throw new BusinessException("Entered rating value " + feedback.getProduct_quality() + " is invalid");
		}
		if (!isValidRate(feedback.getShopping_experience())) {
			throw new BusinessException("Entered rating value " + feedback.getShopping_experience() + " is invalid");
		}
		if (!isValidRate(feedback.getValue_of_money())) {
			throw new BusinessException("Entered rating value " + feedback.getValue_of_money() + " is invalid");
		}
		if (!isVaidRecommendation(feedback.getRecommendation())) {
			throw new BusinessException("Please enter recommendation as Yes or No only");
		}
		
		return dao.save(feedback);
	}	

	@Override
	public Feedback getFeedbackById(int id) throws BusinessException {
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Feedback feedback=null;
		try {
			feedback=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for id "+id);
		}
		return feedback;
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) throws BusinessException {
		if (!isValidId(feedback.getId())) {
			throw new BusinessException("Entered id  " + feedback.getId() + " is invalid...cannot update");
		}
		return dao.save(feedback);
	}

	@Override
	public void deleteFeedback(int id) throws BusinessException {
		if (!isValidId(id)) {
			throw new BusinessException("Entered id " + id + " is invalid");
		}
		try {
			dao.deleteById(id);
		}catch(NoSuchElementException e) {
			throw new BusinessException("Cannot delete feedback found for id as id doesnot exist "+id);
		}
		
		
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

	@Override
	public List<Feedback> getFeedbackByRecommendation(String recommendation) {
		return dao.findByRecommendation(recommendation);
	}
	
	
	private boolean isValidRate(int rate) {
		boolean b = false;
		if (rate > 0 && rate <= 5) {
			b = true;
		}
		return b;
	}
	private boolean isValidId(int id) {
		boolean b = false;
		if (id>0) {
			b = true;
		}
		return b;
	}
	private boolean isValidEmail(String email) {
		boolean b = false;

		if (email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			b = true;
		}
		return b;
	}
	private boolean isValidName(String name) {
		boolean b = false;
		if (name.matches("[a-zA-Z]{3,30}")) {
			b = true;
		}
		return b;
	}
	private boolean isVaidRecommendation(String recom) {
		boolean b = false;
		if (recom.matches("^[Yes|No|yes|no]+$") ) {
			b = true;
		}
		return b;
	}
	}
