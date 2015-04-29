package com.example.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.space);
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.mario);
		ourSong.start();
		
		Thread timer = new Thread() {
			public void run(){
				try{
					sleep(4000);
					
				} catch(InterruptedException e){
					e.printStackTrace();
				} finally{
					Intent openMainActivity = new Intent("com.example.FirstApp.Menu");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
}
