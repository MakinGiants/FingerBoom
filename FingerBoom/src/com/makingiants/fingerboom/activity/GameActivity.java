package com.makingiants.fingerboom.activity;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makingiants.fingerboom.R;

public class GameActivity extends Activity implements OnChronometerTickListener {
	
	public final static String EXTRA_COUNT = "extra";
	public final static int RESULT_COUNT = 1;
	private final static int MAX_TIME = 10;//seconds
	
	// --------------------------------
	// Attributes
	// --------------------------------
	
	private TextView textNumber;
	private RelativeLayout mainLayout;
	
	private Chronometer chronometer;
	private int countTouches = 0;
	
	// --------------------------------
	// Activity overrides
	// --------------------------------
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		countTouches = 0;
		
		textNumber = (TextView) findViewById(R.id.game_text_number);
		mainLayout = (RelativeLayout) findViewById(R.id.game_layout);
		mainLayout.setBackgroundColor(getResources().getColor(R.color.game_background));
		
		/*
		 * {@link http://android-pro.blogspot.com/2010/06/android-chronometer-timer.html}
		 */
		chronometer = (Chronometer) findViewById(R.id.game_chronometer);
		chronometer.setBase(SystemClock.elapsedRealtime());
		chronometer.setOnChronometerTickListener(this);
		chronometer.start();
		
		// Make start sound
		MediaPlayer.create(this, R.raw.start).start();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			countTouches++;
			
			textNumber.setText("" + countTouches);
			
			int color;
			Random rnd = new Random();
			color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
			mainLayout.setBackgroundColor(color);
		}
		
		return super.onTouchEvent(event);
		
	}
	
	@Override
	public void onPause() {
		super.onPause();
		
		if (chronometer != null) {
			chronometer.stop();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		if (chronometer != null) {
			chronometer.start();
		}
	}
	
	// --------------------------------
	// Chronometer Listener overrides
	// --------------------------------
	
	@Override
	public void onChronometerTick(Chronometer chrono) {
		long seconds = ((SystemClock.elapsedRealtime() - chrono.getBase()) / 1000) % 60;
		//long minutes = ((SystemClock.elapsedRealtime() - chrono.getBase()) / 1000) / 60;
		
		if (seconds == MAX_TIME) {
			
			chronometer.stop();
			
			final Intent newActivity = new Intent(this, Top10Activity.class);
			newActivity.putExtra(Top10Activity.EXTRA_COUNTS, countTouches);
			startActivity(newActivity);
			
		}
	}
	
}
