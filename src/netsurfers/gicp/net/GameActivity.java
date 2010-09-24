package netsurfers.gicp.net;

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
import android.view.Window;
import android.view.WindowManager;

/**
 * GameActivity is the main activity of the game. Extends {@link android.app.Activity}
 * and implements {@link java.lang.Runnable} .This Thread is the game life circle
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class GameActivity extends Activity implements Runnable {
	
	/**
	 * Called when the activity is first created
	 */
	private World mWorld = null;
	private Thread mThread = null;
	private GameView mGameView = null;
	
	/**
	 * Called when the activity is being started
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
		Constants.SCREEM_WIDTH_DEFAULT = this.getWindow().getWindowManager().getDefaultDisplay().getWidth();
		Constants.SCREEM_HEIGHT_DEFAULT = this.getWindow().getWindowManager().getDefaultDisplay().getHeight();
		Constants.SCREEM_HALF_WIDTH = Constants.SCREEM_WIDTH_DEFAULT/2;
		Constants.SCREEM_HALF_HEIGHT = Constants.SCREEM_HEIGHT_DEFAULT/2;
		
		mGameView = new GameView(this);
		mGameView.setBitmapMgr(new BitmapMgr(this.getResources()));
		setContentView(mGameView);
		mGameView.setFocusable(true);
		mGameView.setFocusableInTouchMode(true);
		
		mWorld = new World();
		if(null == mThread) {
	        mThread = new Thread(this);
        }
        mThread.start();
        
        Cursor c = getContentResolver().query(Uri.parse("content://netsurfers.gicp.net.provider/item_template"), null, null, null, null);
        if(c != null) {
        	if(c.moveToFirst())
        		c.getCount();
        }
        c.close();
        
        startMenuActivity();
	}
	
	/**
	 * Called when the screen orientation change
	 * @see android.app.Activity#onConfigurationChanged(android.content.res.Configuration)
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Constants.SCREEM_WIDTH_DEFAULT = this.getWindow().getWindowManager().getDefaultDisplay().getWidth();
		Constants.SCREEM_HEIGHT_DEFAULT = this.getWindow().getWindowManager().getDefaultDisplay().getHeight();
		Constants.SCREEM_HALF_WIDTH = Constants.SCREEM_WIDTH_DEFAULT/2;
		Constants.SCREEM_HALF_HEIGHT = Constants.SCREEM_HEIGHT_DEFAULT/2;
	}
	
	/**
	 * The game life circle
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long frameElapse, frameTick;
        try {
            frameTick = System.currentTimeMillis();
            while ( true ) {
                    frameElapse = System.currentTimeMillis() - frameTick;
                    if ( frameElapse < Constants.FRAME_INTERVAL ) {
                        Thread.sleep( ( Constants.FRAME_INTERVAL - frameElapse ) );
                    }
                    onUpdate();
                    frameTick = System.currentTimeMillis();
                }
        } catch ( Exception e ) {
        	e.printStackTrace();
        	Log.e("ERROR GameActivity-run: ", e.toString());
        }
	}
	
	/**
	 * Update the game world
	 */
	private void onUpdate(){
//		mWorld.getMaps().getPlayer().setCurrentX(mGameView.getCurrentX());
//		mWorld.getMaps().getPlayer().setCurrentY(mGameView.getCurrentY());
//		mWorld.getMaps().getPlayer().setPlayerState(mGameView.getPlayerState());
		mWorld.onUpdate();
	}
	
	/**
	 * Called when the activity destroy
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mThread.stop();
		while (true) try {
            mThread.join();
            break ;
       } catch(Exception e) {
    	   e.printStackTrace();
    	   Log.e("ERROR GameActivity-destroyed: ", e.toString());
       }
	}
	
	/**
	 * Start the menu activity
	 */
	protected void startMenuActivity() {
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://netsurfers.gicp.net.provider.MenuActivity")));
	}
}
