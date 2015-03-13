package com.example.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;


public class AudioPlayer {
	
	/***********************************************************/
	/*                      Local Data                         */
	/***********************************************************/
	private MediaPlayer mPlayer;
    private boolean isPaused = false;	
	/***********************************************************/
	/*                    Public Methods                       */
	/***********************************************************/
	public void stop() {
		if(mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void play(Context c) {
		//Make sure Media player is not running first sore there
		//is not multiple instances of the MediaPlayer
		stop();
		mPlayer = MediaPlayer.create(c,R.raw.one_small_step);
		
		
		//Called when audio file has finished playing
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				//release MediaPlayer when done
				stop();
				
			}
		});
		mPlayer.start();
	}

	public void pause() {
		if(isPaused) {
			mPlayer.start();
			isPaused = false;
		}
		else {
		mPlayer.pause();
		isPaused = true;
		}
	}

	public boolean isPaused() {
		return isPaused;
	}



}
