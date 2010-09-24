package netsurfers.gicp.net.common;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/**
 * AudioClip will control the music in the game
 */
public class AudioClip {
	
	private MediaPlayer mPlayer;
	private String name;
	
	private boolean mPlaying = false;
	private boolean mLoop = false;
	
	private OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener(){

		@Override
		public void onCompletion(MediaPlayer mp) {
			mPlaying = false;
			if ( mLoop) {
				System.out.println("AudioClip loop " + name);
				mp.start();
			}
		}
		
	};
	/**
	 * Constructor function of audio clip
	 * @param ctx
	 * This parameter use to create the media palyer
	 * @param resID
	 * The id of the resource
	 * @see MediaPlayer#create(Context, int)
	 */
	public AudioClip(Context ctx, int resID) {
		name = ctx.getResources().getResourceName(resID);
		
		mPlayer = MediaPlayer.create(ctx, resID);
		mPlayer.setVolume(1000, 1000);
		mPlayer.setOnCompletionListener(mCompletionListener);
	}
	
	/**
	 * Start to play music
	 */
	public synchronized void play () {
		if ( mPlaying) 
			return;
		
		if (mPlayer != null ) {
			mPlaying = true;
			mPlayer.start();
		}
	}
	
	/**
	 * Stop this media player
	 */
	public synchronized void stop() {
		try {
			mLoop = false;
			if ( mPlaying ) { 
				mPlaying = false;
				mPlayer.pause();
			}
			
		} catch (Exception e) {
			System.err.println("AduioClip::stop " + name + " " + e.toString());
		}
	}
	
	/**
	 * Start and loop this media player
	 */
	public synchronized void loop () {
		mLoop = true;
		mPlaying = true;
		mPlayer.start();		
		
	}
	
	/**
	 * Release the resource of this media player
	 */
	public void release () {
		if (mPlayer != null) { 
			mPlayer.release();
			mPlayer = null;
		}
	}
}
