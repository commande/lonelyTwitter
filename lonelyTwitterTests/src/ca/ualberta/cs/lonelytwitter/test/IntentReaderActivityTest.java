package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;

public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}
	
	public void testSendText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("test string ", activity.getText());
	}
	
	public void testDoubleText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("test string test string ", activity.getText());
	}
	
	public void testDisplayText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("test string ", widget.getText());
	}
	
	public void testDisplayTextDirect() throws Throwable {
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				IntentReaderActivity activity = (IntentReaderActivity) getActivity();
				TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
				
				widget.setText("test string ");
				
			}
		});
		
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("test string ", widget.getText());
	}
	
	public void testReverseText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals(" gnirts tset", activity.getText());
	}
	
	public void testDefaultMessage() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "");
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("No text was entered.", widget.getText());
	}
	
	public void testVisibleTextView() {
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		View decorview = activity.getWindow().getDecorView();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		ViewAsserts.assertOnScreen(decorview, widget);
	}
	
}
