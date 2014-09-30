package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetListModel {
	
	private ArrayList<LonelyTweetModel> tweets;
	
	public TweetListModel() {
		super();
		this.tweets = new ArrayList<LonelyTweetModel>();
	}

	public void addTweet(LonelyTweetModel tweet) throws IllegalArgumentException {
		// throws IllegalArgumentException if a duplicate tweet is added.
		if (tweets.contains(tweet)) {
			throw new IllegalArgumentException();
		} else {
			tweets.add(tweet);
		}
	}

	public boolean hasTweet(LonelyTweetModel tweet) {
		// returns whether tweet array has a similar tweet
		return tweets.contains(tweet);
	}

	public void removeTweet(LonelyTweetModel tweet) {
		tweets.remove(tweet);
		
	}

	public int getCount() {
		return tweets.size();
	}

	public ArrayList<LonelyTweetModel> getTweets() {
		ArrayList<LonelyTweetModel> sortTweets = tweets;
		// http://stackoverflow.com/questions/18441846/how-sort-a-arraylist-in-java
		// User Prabhakaran, Referenced on Sept 30, 2014
		Collections.sort(sortTweets, new Comparator<LonelyTweetModel>() {

	        public int compare(LonelyTweetModel tweet1, LonelyTweetModel tweet2)
	        {

	            return  tweet1.getTimestamp().compareTo(tweet2.getTimestamp());
	        }
	    });
		
		return sortTweets;
	}
	
}
