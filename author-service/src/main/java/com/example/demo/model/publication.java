package com.example.demo.model;

public class publication {
	private Integer publicationId;

	private String publicationName;

	private Integer bookName;

	private String authorName;

	public publication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public publication(Integer publicationId, String publicationName, Integer bookName, String authorName) {
		super();
		this.publicationId = publicationId;
		this.publicationName = publicationName;
		this.bookName = bookName;
		this.authorName = authorName;
	}

	public Integer getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Integer publicationId) {
		this.publicationId = publicationId;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public Integer getBookName() {
		return bookName;
	}

	public void setBookName(Integer bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
}
