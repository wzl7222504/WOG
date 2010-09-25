package netsurfers.gicp.net;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * MenuActivity is the menu activity of the game. Extends
 * {@link android.app.Activity}. This layout may be change when player select
 * the option. Then you can see the different screen
 * 
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class MenuActivity extends Activity {

	/**
	 * Called when the activity is first created
	 */
	Button mBtnStartGame;
	Button mBtnExitGame;
	private OnClickListener mLsnStartGame = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	};
	private OnClickListener mLsnExitGame = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	};

	/**
	 * Called when the activity is being started
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenulayout);
		mBtnStartGame = (Button) this.findViewById(R.id.btn_startgame);
		mBtnExitGame = (Button) this.findViewById(R.id.btn_exitgame);
		mBtnStartGame.setOnClickListener(mLsnStartGame);
		mBtnExitGame.setOnClickListener(mLsnExitGame);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
