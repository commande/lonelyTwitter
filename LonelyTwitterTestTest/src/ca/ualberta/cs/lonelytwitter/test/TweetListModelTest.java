package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;
import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;

public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
//	public void testFail() {
//		fail("We should have never played god!");
//	}
	
	public void testFiveIsFive() {
		assertEquals(5, 5);
	}
	
	public void testTweetListModel() {
		TweetListModel tlm = new TweetListModel();
		assertNotNull(tlm);
	}
	
	public void testAddTweet() {
		boolean caughtException = false;
		TweetListModel tlm = new TweetListModel();
		
		LonelyTweetModel tweet1 = new LonelyTweetModel("Hello");
		LonelyTweetModel tweet2 = new LonelyTweetModel("Hello");
		
		try {
			tlm.addTweet(tweet1);
		} catch (IllegalArgumentException e) {
			fail("Unexpected duplicate tweet");
		}
		
		try {
			tlm.addTweet(tweet2);
		} catch (IllegalArgumentException e) {
			caughtException = true;
		}
		
		assertTrue(tlm.hasTweet(tweet1));
		assertTrue(caughtException);
	}
	
	public void testGetTweets() {
		// tests that all tweets are returned in chronological order
		TweetListModel tweets = new TweetListModel();
		LonelyTweetModel tweet1 = new LonelyTweetModel("Hello", new Date(1230000000L * 1000));
		tweets.addTweet(tweet1);
		LonelyTweetModel tweet2 = new LonelyTweetModel("Goodbye", new Date(1220000000L * 1000));
		tweets.addTweet(tweet2);
		LonelyTweetModel tweet3 = new LonelyTweetModel("Yes", new Date(1210000000L * 1000));
		tweets.addTweet(tweet3);
		LonelyTweetModel tweet4 = new LonelyTweetModel("No", new Date(1240000000L * 1000));
		tweets.addTweet(tweet4);
		
		ArrayList<LonelyTweetModel> gotTweets = tweets.getTweets();
		assertNotNull(gotTweets);
		
		assertEquals(gotTweets.get(0), tweet3);
		assertEquals(gotTweets.get(1), tweet2);
		assertEquals(gotTweets.get(2), tweet1);
		assertEquals(gotTweets.get(3), tweet4);

	}
	
	public void testHasTweet() {
		TweetListModel tweets = new TweetListModel();
		LonelyTweetModel tweet1 = new LonelyTweetModel("Hello");
		LonelyTweetModel tweet2 = new LonelyTweetModel("Hello");
		// Add tweet 1, but check for tweet 2 to test equality
		tweets.addTweet(tweet1);
		assertTrue(tweets.hasTweet(tweet2));
	}
	
	public void testRemoveTweet() {
		TweetListModel tweets = new TweetListModel();
		LonelyTweetModel tweet1 = new LonelyTweetModel("Hello");
		tweets.addTweet(tweet1);
		assertTrue(tweets.hasTweet(tweet1));
		
		tweets.removeTweet(tweet1);
		assertTrue(!tweets.hasTweet(tweet1));
	}
	
	public void testGetCount() {
		TweetListModel tweets = new TweetListModel();
		tweets.addTweet(new LonelyTweetModel("Hello"));
		tweets.addTweet(new LonelyTweetModel("Goodbye"));
		tweets.addTweet(new LonelyTweetModel("Yes"));
		tweets.addTweet(new LonelyTweetModel("No"));
		
		assertEquals(tweets.getCount(), 4);
	}
}
