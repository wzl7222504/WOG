package netsurfers.gicp.net;

import netsurfers.gicp.net.common.Constants;
import netsurfers.gicp.net.common.Tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
	private boolean mGameRuning;
	private Context mContext;
	
	Button mBtnNewGame;
	Button mBtnLoadGame;
	Button mBtnSetting;
	Button mBtnInstruction;
	Button mBtnExitGame;
	private OnClickListener mLsnNewGame = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			setContentView(R.layout.create_character);
			Button btnDone=(Button)findViewById(R.id.btn_done);
			Button btnRevert=(Button)findViewById(R.id.btn_revert);
			btnDone.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Bundle bundle = new Bundle();
					bundle.putInt("stopGameKey", 0);
					Intent Intent = new Intent();
					Intent.putExtras(bundle);
					setResult(Constants.RESULT_OK, Intent);
					finish();
				}
			});
			btnRevert.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Bundle bundle = new Bundle();
					bundle.putInt("stopGameKey", 0);
					Intent Intent = new Intent();
					Intent.putExtras(bundle);
					setResult(Constants.RESULT_CANCELED, Intent);
					finish();
				}
			});
		}
	};
	private OnClickListener mLsnNewGame2 = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Bundle bundle = new Bundle();
			bundle.putInt("stopGameKey", 0);
			Intent Intent = new Intent();
			Intent.putExtras(bundle);
			setResult(Constants.RESULT_CANCELED, Intent);
			finish();
		}
		
	};
	private OnClickListener mLsnExitGame = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(mGameRuning) {
				Tools.AlertDialog(mContext, "warning", "You'll lost the character when you don't save game!");
				mGameRuning = false;
				initialize();
			}
			else {
				Bundle bundle = new Bundle();
				bundle.putInt("stopGameKey", 1);
				Intent Intent = new Intent();
				Intent.putExtras(bundle);
				setResult(Constants.RESULT_STOP, Intent);
				finish();
			}
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
		setContentView(R.layout.main_menu);
		mContext = this;
		Bundle bundle = getIntent().getExtras();
		mGameRuning = bundle.getBoolean("GameRuningKey");
		
		initialize();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void initialize() {
		mBtnNewGame = (Button) this.findViewById(R.id.btn_new_game);
		mBtnLoadGame = (Button) this.findViewById(R.id.btn_load_game);
		mBtnSetting = (Button) this.findViewById(R.id.btn_setting);
		mBtnInstruction = (Button) this.findViewById(R.id.btn_instruction);
		mBtnExitGame = (Button) this.findViewById(R.id.btn_exit_game);
		
		if(mGameRuning) {
			mBtnNewGame.setText(R.string.btn_new_game2);
			mBtnExitGame.setText(R.string.btn_exit_game2);
			mBtnNewGame.setOnClickListener(mLsnNewGame2);
		}
		else {
			mBtnNewGame.setText(R.string.btn_new_game);
			mBtnExitGame.setText(R.string.btn_exit_game);
			mBtnNewGame.setOnClickListener(mLsnNewGame);
		}
		
		mBtnExitGame.setOnClickListener(mLsnExitGame);
	}
}
