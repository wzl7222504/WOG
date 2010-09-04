package netsurfers.gicp.net;

import netsurfers.gicp.net.provider.DatabaseProvider;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;

public class GameActivity extends Activity implements Runnable {
	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamelayout);
		ContentResolver cr = getContentResolver();
		Cursor cursor = cr.query(DatabaseProvider.CONTENT_URI, null, null, null, null);
		cursor.moveToFirst();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
