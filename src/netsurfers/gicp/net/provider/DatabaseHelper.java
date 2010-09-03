package netsurfers.gicp.net.provider;

import netsurfers.gicp.net.util.Constants;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String TAG = "DatabaseHelper";

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + Constants.DATABASE_TABLE_NAME[0] + " ("
                + Constants.DATABASE_TABLE00_COLUMN_NAME[0] + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + Constants.DATABASE_TABLE00_COLUMN_NAME[1] + " VARCHAR NOT NULL DEFAULT '' "
                + ");");
		db.execSQL("insert into "+  Constants.DATABASE_TABLE_NAME[0] + "("
				+ Constants.DATABASE_TABLE00_COLUMN_NAME[0] + ", "
                + Constants.DATABASE_TABLE00_COLUMN_NAME[1] + ") "
                + "values(2, 'hello');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + Constants.DATABASE_TABLE_NAME[0]);
        onCreate(db);
	}

}
