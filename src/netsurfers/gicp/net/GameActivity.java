package netsurfers.gicp.net;

import netsurfers.gicp.net.common.AudioClip;
import netsurfers.gicp.net.common.Constants;
import netsurfers.gicp.net.common.BitmapMgr;
import netsurfers.gicp.net.game.World;
import netsurfers.gicp.net.ui.GameView;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

/**
 * GameActivity is the main activity of the game. Extends
 * {@link android.app.Activity} and implements {@link java.lang.Runnable} .This
 * Thread is the game life circle
 * 
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class GameActivity extends Activity implements Runnable {

	/**
	 * Called when the activity is first created
	 */
	private boolean mGameRuning = false;
	private World mWorld;
	private Thread mThread;
	private GameView mGameView;
	private AudioClip mAudioClip;

	/**
	 * Called when the activity is being started
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Constants.SCREEM_WIDTH_DEFAULT = this.getWindow().getWindowManager()
				.getDefaultDisplay().getWidth();
		Constants.SCREEM_HEIGHT_DEFAULT = this.getWindow().getWindowManager()
				.getDefaultDisplay().getHeight();
		Constants.SCREEM_HALF_WIDTH = Constants.SCREEM_WIDTH_DEFAULT / 2;
		Constants.SCREEM_HALF_HEIGHT = Constants.SCREEM_HEIGHT_DEFAULT / 2;

		mGameView = new GameView(this);
		mGameView.setGameActivity(this);
		mGameView.setBitmapMgr(new BitmapMgr(this.getResources()));
		setContentView(mGameView);
		mGameView.setFocusable(true);
		mGameView.setFocusableInTouchMode(true);

		mWorld = new World();
		if (null == mThread) {
			mThread = new Thread(this);
		}
		mThread.start();

		Cursor c = getContentResolver().query(Uri.parse("content://netsurfers.gicp.net.provider/item_template"),
						null, null, null, null);
		if (c != null) {
			Log.i("WOG database","column count : "+c.getColumnCount());
			if (c.moveToFirst())
				Log.i("WOG database","record count : "+c.getCount());
		}
		c.close();
	}

	/**
	 * Called when the screen orientation change
	 * 
	 * @see android.app.Activity#onConfigurationChanged(android.content.res.Configuration)
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Constants.SCREEM_WIDTH_DEFAULT = this.getWindow().getWindowManager()
				.getDefaultDisplay().getWidth();
		Constants.SCREEM_HEIGHT_DEFAULT = this.getWindow().getWindowManager()
				.getDefaultDisplay().getHeight();
		Constants.SCREEM_HALF_WIDTH = Constants.SCREEM_WIDTH_DEFAULT / 2;
		Constants.SCREEM_HALF_HEIGHT = Constants.SCREEM_HEIGHT_DEFAULT / 2;
	}

	/**
	 * The game life circle
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long frameElapse, frameTick;
		try {
			frameTick = System.currentTimeMillis();
			while (true) {
				frameElapse = System.currentTimeMillis() - frameTick;
				if (frameElapse < Constants.FRAME_INTERVAL) {
					Thread.sleep((Constants.FRAME_INTERVAL - frameElapse));
				}
				onUpdate();
				frameTick = System.currentTimeMillis();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("ERROR GameActivity-run: ", e.toString());
		}
	}

	/**
	 * Update the game world
	 */
	private void onUpdate() {
		mWorld.onUpdate();
	}

	/**
	 * Called when the activity resume
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (mAudioClip != null) {
			mAudioClip.stop();
			mAudioClip.release();
		}
		mAudioClip = new AudioClip(this, R.raw.background_001);
		mAudioClip.loop();

		if (!mGameRuning) {
			startMenuActivity();
		}
	}

	/**
	 * Called when the activity destroy
	 * 
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mThread.stop();
		while (true)
			try {
				mThread.join();
				break;
			} catch (Exception e) {
				e.printStackTrace();
				Log.e("ERROR GameActivity-destroyed: ", e.toString());
			}
	}

	/**
	 * Get the result from menu activity
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(resultCode == Constants.RESULT_STOP)
			stopGame();
		if(resultCode == Constants.RESULT_NEW_OK) {
			
		}else if(resultCode == Constants.RESULT_LOAD_OK){
			
		}else if(resultCode == Constants.RESULT_OK){
			if(mWorld.getMaps().getPlayer().getID() == -1) {
				getContentResolver().insert(Constants.DATABASE_CONTENT_URI[0], mWorld.getMaps().getPlayer().getCharacterContentValues());
			}
			else {
				getContentResolver().update(Constants.DATABASE_CONTENT_URI[0], mWorld.getMaps().getPlayer().getCharacterContentValues(), "_id="+mWorld.getMaps().getPlayer().getID(), null);
			}
		}
	}
	
	/**
	 * Start the menu activity
	 */
	public void startMenuActivity() {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://netsurfers.gicp.net.provider.MenuActivity"));
		Bundle bundle = new Bundle();
		bundle.putBoolean("GameRuningKey", mGameRuning);
		mGameRuning = true;
		intent.putExtras(bundle);
		startActivityForResult(intent, 0);
		if (mAudioClip != null) {
			mAudioClip.stop();
			mAudioClip.release();
		}
		mAudioClip = new AudioClip(this, R.raw.login);
		mAudioClip.play();
	}
	
	/**
	 * Quit this game
	 */
	public void stopGame() {
		System.exit(0);
	}
	
	/**
	 * (non-Javadoc)
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * (non-Javadoc)
	 * @see android.app.Activity#onKeyLongPress(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * (non-Javadoc)
	 * @see android.app.Activity#onKeyUp(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
