package netsurfers.gicp.net;

import android.app.Activity;
import android.os.Bundle;

/**
 * MenuActivity is the menu activity of the game. Extends {@link Activity}.
 * This layout may be change when player select the option. Then you can see
 * the different screen.
 * @author Ziliang Wang
 * E-mail: Lional.King@gmail.com
 */
public class MenuActivity extends Activity {
	
	/**
	 * Called when the activity is first created. 
	 */
	
	/**
	 * Called when the activity create. 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menulayout);
	}
}
