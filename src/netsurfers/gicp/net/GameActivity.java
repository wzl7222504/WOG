package netsurfers.gicp.net;

import netsurfers.gicp.net.common.Constants;
import netsurfers.gicp.net.provider.DatabaseProvider;
import netsurfers.gicp.net.ui.GameView;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity implements Runnable {
	/** Called when the activity is first created. */
	GameView mGameView;
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
		setContentView(mGameView);
		mGameView.setFocusable(true);
		mGameView.setFocusableInTouchMode(true);
		ContentResolver cr = getContentResolver();
		Cursor cursor = cr.query(DatabaseProvider.CONTENT_URI, null, null, null, null);
		cursor.moveToFirst();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Constants.SCREEM_WIDTH_DEFAULT = this.getWindow().getWindowManager().getDefaultDisplay().getWidth();
		Constants.SCREEM_HEIGHT_DEFAULT = this.getWindow().getWindowManager().getDefaultDisplay().getHeight();
		Constants.SCREEM_HALF_WIDTH = Constants.SCREEM_WIDTH_DEFAULT/2;
		Constants.SCREEM_HALF_HEIGHT = Constants.SCREEM_HEIGHT_DEFAULT/2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}
