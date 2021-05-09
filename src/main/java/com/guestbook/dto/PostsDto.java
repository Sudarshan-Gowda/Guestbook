package com.guestbook.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class PostsDto implements Serializable {

	// Static Attributes
	///////////////////////
	private static final long serialVersionUID = 6133562775414714112L;

	// Attributes
	/////////////////
	private Long postId;

	private String postType;

	private String postDescription;

	private MultipartFile image;

	private String imageName;

	private String imageBytesInstr;

	private Boolean isApproved;

	// Properties
	///////////////
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

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageBytesInstr() {
		return imageBytesInstr;
	}

	public void setImageBytesInstr(String imageBytesInstr) {
		this.imageBytesInstr = imageBytesInstr;
	}

}
