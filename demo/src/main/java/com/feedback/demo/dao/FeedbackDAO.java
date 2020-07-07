package com.feedback.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedback.demo.model.Feedback;


@Repository
public interface FeedbackDAO extends JpaRepository<Feedback,Integer>{

	public List<Feedback> findByRecommendation(String recommendation);
	
}
