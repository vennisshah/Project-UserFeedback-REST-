package com.feedback.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
// rating parameters on a scale of 1-5
	private int product_quality;
	private int delivery;
	private int value_of_money;
	private int shopping_experience;
	private int after_sales_service;
	private int overall_ratings;
	private String recommendation;
	private String suggestions;
	public Feedback() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProduct_quality() {
		return product_quality;
	}
	public void setProduct_quality(int product_quality) {
		this.product_quality = product_quality;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public int getValue_of_money() {
		return value_of_money;
	}
	public void setValue_of_money(int value_of_money) {
		this.value_of_money = value_of_money;
	}
	public int getShopping_experience() {
		return shopping_experience;
	}
	public void setShopping_experience(int shopping_experience) {
		this.shopping_experience = shopping_experience;
	}
	public int getAfter_sales_service() {
		return after_sales_service;
	}
	public void setAfter_sales_service(int after_sale_service) {
		this.after_sales_service = after_sale_service;
	}
	public int getOverall_ratings() {
		return overall_ratings;
	}
	public void setOverall_ratings(int overall_ratings) {
		this.overall_ratings = overall_ratings;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	

}
