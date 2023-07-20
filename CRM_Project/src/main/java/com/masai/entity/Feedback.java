package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 300, nullable = false)
	private String message;
	
	@Column(nullable = true)
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "issue_id")
	private Issues issue;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(String message, int rating, Issues issue) {
		super();
		this.message = message;
		this.rating = rating;
		this.issue = issue;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the issue
	 */
	public Issues getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(Issues issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", message=" + message + ", rating=" + rating + ", issue=" + issue + "]";
	}
	
	
	
	
}
