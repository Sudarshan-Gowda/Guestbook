package com.guestbook.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS")
public class Posts implements Serializable {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = -7166679539822935248L;

	// Attributes
	////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_ID")
	private Long postId;

	@Column(name = "POST_TYPE")
	private String postType;

	@Column(name = "POST_DESCRIPTION")
	private String postDescription;

	@Column(name = "IMAGE_NAME")
	private String imageName;

	@Lob
	@Column(name = "IMAGE", length = 2000)
	private byte[] image;

	@Column(name = "IS_APPROVED")
	private Boolean isApproved;

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	// Properties
	////////////////
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

}
