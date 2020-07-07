package com.feedback.demo.service;

import java.util.List;

import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;

public interface FeedbackService {
	public Feedback generateFeedback(Feedback feedback) throws BusinessException ;
	public Feedback getFeedbackById(int id) throws BusinessException;
	public Feedback updateFeedback(Feedback feedback) throws BusinessException;
	public void deleteFeedback(int id) throws BusinessException;
	public List<Feedback> getAllFeedbacks();
	public List<Feedback> getFeedbackByRecommendation(String recommendation);

}
