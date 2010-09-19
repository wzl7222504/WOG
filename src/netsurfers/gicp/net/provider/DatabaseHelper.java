package netsurfers.gicp.net.provider;

import netsurfers.gicp.net.common.Constants;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

/**
 * DatabaseHelper extend from {@link android.database.sqlite.SQLiteOpenHelper} which can manager
 * the database with SQLite
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String TAG = "DatabaseHelper";

	/**
	 * Constructor function of {@link netsurfers.gicp.net.provider.DatabaseHelper}
	 * @param context
	 * To use to open or create the database
	 * @param name
	 * Of the database file, or null for an in-memory database 
	 * @param factory
	 * To use for creating cursor objects, or null for the default 
	 * @param version
	 * Number of the database (starting at 1); if the database is older, onUpgrade(android.database.sqlite.SQLiteDatabase, int, int) will be used to upgrade the database 
	 * @see android.database.sqlite.SQLiteOpenHelper#SQLiteOpenHelper
	 */
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Called when the database is being started
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
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

	/**
	 * Called when the database upgrade
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + Constants.DATABASE_TABLE_NAME[0]);
        onCreate(db);
	}

}
