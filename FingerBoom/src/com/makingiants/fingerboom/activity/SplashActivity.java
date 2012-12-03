package com.makingiants.fingerboom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.makingiants.fingerboom.R;

/**
 * {@link http://stackoverflow.com/a/5486970}
 */
public class SplashActivity extends Activity {
	
	private final int SPLASH_DISPLAY_LENGHT = 1000;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.splash_screen);
		final SplashActivity me = this;
		
		/* New Handler to start the Menu-Activity 
		 * and close this Splash-Screen after some seconds.*/
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				/* Create an Intent that will start the Menu-Activity. */
				Intent mainIntent = new Intent(me, MainActivity.class);
				startActivity(mainIntent);
				
			}
		}, SPLASH_DISPLAY_LENGHT);
	}
}