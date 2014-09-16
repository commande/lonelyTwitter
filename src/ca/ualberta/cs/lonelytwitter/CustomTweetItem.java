package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class CustomTweetItem implements CustomTweetInterface {
	
	private String text;
	private String author;
	private Date creationDate;
	
	public CustomTweetItem(String text, String author) {
		this.text = text;
		this.author = author;
		this.creationDate = new Date();
	}

	public String getText() {
		return this.text;
	}

	public String getAuthor() {
		return this.author;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}
	
	public abstract String toString();

}
