package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TweetCountActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweetcount);
		
		// Get the length of the tweet array
		int count = LonelyTwitterActivity.tweets.size();
		
		// Show the tweet array count to the user
		TextView tweetCountText = (TextView) findViewById(R.id.textView1);
		tweetCountText.setText("Number of tweets: " + count);
	}
}
