package com.makingiants.fingerboom.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.makingiants.fingerboom.R;

public class Top10Activity extends Activity {
	
	public static final String EXTRA_COUNTS = "extra_counts";
	
	// --------------------------------
	// Activity overides
	// --------------------------------
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top10);
		
		//Make die sound
		int idSoundToMake = R.raw.laugth;
		
		int counts = getIntent().getExtras().getInt(EXTRA_COUNTS);
		TextView textInfo = ((TextView) findViewById(R.id.top10_text_info));
		
		if (counts < 10) {
			textInfo.setText("Look at yourself in a mirror and say: I can do it!");
			idSoundToMake = R.raw.wawawa;
		} else if (counts >= 10 && counts < 20) {
			textInfo.setText("Hey, Are you kidding me? Try harder!");
			idSoundToMake = R.raw.cof;
		} else if (counts >= 20 && counts < 40) {
			textInfo.setText("What's wrong with your fingers???");
			idSoundToMake = R.raw.pain;
		} else if (counts >= 40 && counts < 50) {
			textInfo.setText("Oh! Yeah! thats the way!! play again!!");
			idSoundToMake = R.raw.pitty;
		} else if (counts >= 50 && counts < 70) {
			textInfo.setText("Now your fingers can move!! Congratulations!");
			idSoundToMake = R.raw.surprised2;
		} else if (counts >= 70 && counts < 80) {
			textInfo.setText("You are going crazy!!!");
			idSoundToMake = R.raw.laugth;
		} else if (counts >= 80 && counts < 100) {
			textInfo.setText("You're the god of fingers!!!!!");
			idSoundToMake = R.raw.applause_ligth;
		} else if (counts >= 100 && counts < 110) {
			textInfo.setText("You are the man!!!!!");
			idSoundToMake = R.raw.surprised;
		} else if (counts >= 110 && counts < 120) {
			textInfo.setText("Do you really exist?? we can't believe you!");
			idSoundToMake = R.raw.applause;
		} else if (counts >= 120 && counts < 130) {
			textInfo.setText("We kneel in front of you, you are the master!");
			idSoundToMake = R.raw.applause_big;
		} else {
			idSoundToMake = R.raw.dream;
			textInfo.setText("Master! teach your friends how to play!");
		}
		
		((TextView) findViewById(R.id.top10_text_number)).setText("" + counts);
		
		MediaPlayer.create(this, idSoundToMake).start();
	}
	
	// --------------------------------
	// View Events
	// --------------------------------
	
	public void closeOnClick(View view) {
		final Intent newActivity = new Intent(this, GameActivity.class);
		startActivity(newActivity);
	}
}
