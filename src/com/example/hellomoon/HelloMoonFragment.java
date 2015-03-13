package com.example.hellomoon;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HelloMoonFragment extends Fragment {
	
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mPlayButton;
	private Button mPauseButton;
	private Button mStopButton;
	
	//Key to store
	
	/*************************************************************/
	/*                  Override Methods                         */
	/*************************************************************/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Retain the instance of the fragment. So don't destroy it
		//and recreate it on a rotation
		setRetainInstance(true);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
		
		//Create Play button
		mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
		
		//Play Audio file when button pushed
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.play(getActivity());
				
			}
		});
		
		//Create Pause Button
		mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
		
		//Puase Audio file when button pushed
		mPauseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.pause();
                setPauseButtonText();
				
			}
		});
		//Create Stop Button
		mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
		
		//Stop Audio file when button pushed
		mStopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.stop();
				
			}
		});
		
        //Set the Pause Button text again in case we had a rotation
		setPauseButtonText();
		
		return v;
	}
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();

	}
	
	/************************************************************************/
	/*                          Private Methods                             */
	/************************************************************************/
	private void setPauseButtonText()
	{
		if(mPlayer.isPaused())
			mPauseButton.setText(getString(R.string.hellomoon_resume));
		else
			mPauseButton.setText(getString(R.string.hellomoon_pause));
	}
	

}
