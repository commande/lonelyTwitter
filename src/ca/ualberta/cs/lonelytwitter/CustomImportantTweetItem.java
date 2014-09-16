package ca.ualberta.cs.lonelytwitter;

public class CustomImportantTweetItem extends CustomTweetItem {
	
	private String prefix = "Important Tweet: ";

	public CustomImportantTweetItem(String text, String author) {
		super(text, author);
	}
	
	@Override
	public String toString() {
		return this.prefix + this.getText();
	}


}
