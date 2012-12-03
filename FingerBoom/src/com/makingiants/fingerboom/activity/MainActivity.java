package com.makingiants.fingerboom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.makingiants.fingerboom.R;

public class MainActivity extends Activity {
	
	// --------------------------------
	// Activity overides
	// --------------------------------
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	// --------------------------------
	// View Events
	// --------------------------------
	
	public void startGameOnClick(View view) {
		final Intent newActivity = new Intent(this, GameActivity.class);
		startActivity(newActivity);
		
	}
}
