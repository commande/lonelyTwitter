package ca.ualberta.cs.lonelytwitter;

public class CustomNormalTweetItem extends CustomTweetItem {
	
	private String prefix = "Normal Tweet: ";

	public CustomNormalTweetItem(String text, String author) {
		super(text, author);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.prefix + this.getText();
	}

}
