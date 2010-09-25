package netsurfers.gicp.net.provider;

import netsurfers.gicp.net.common.Constants;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

/**
 * DatabaseHelper extend from {@link android.database.sqlite.SQLiteOpenHelper}
 * which can manager the database with SQLite
 * 
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String TAG = "DatabaseHelper";

	/**
	 * Constructor function of
	 * {@link netsurfers.gicp.net.provider.DatabaseHelper}
	 * 
	 * @param context
	 *            To use to open or create the database
	 * @param name
	 *            Of the database file, or null for an in-memory database
	 * @param factory
	 *            To use for creating cursor objects, or null for the default
	 * @param version
	 *            Number of the database (starting at 1); if the database is
	 *            older, onUpgrade(android.database.sqlite.SQLiteDatabase, int,
	 *            int) will be used to upgrade the database
	 * @see android.database.sqlite.SQLiteOpenHelper#SQLiteOpenHelper
	 */
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param db
	 */
	private void onCreateTables(SQLiteDatabase db) {
		try {
			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s VARCHAR NOT NULL DEFAULT '', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[0],
									Constants.DATABASE_TABLE00_COLUMN_NAME[0],
									Constants.DATABASE_TABLE00_COLUMN_NAME[1],
									Constants.DATABASE_TABLE00_COLUMN_NAME[2],
									Constants.DATABASE_TABLE00_COLUMN_NAME[3],
									Constants.DATABASE_TABLE00_COLUMN_NAME[4],
									Constants.DATABASE_TABLE00_COLUMN_NAME[5],
									Constants.DATABASE_TABLE00_COLUMN_NAME[6],
									Constants.DATABASE_TABLE00_COLUMN_NAME[7],
									Constants.DATABASE_TABLE00_COLUMN_NAME[8],
									Constants.DATABASE_TABLE00_COLUMN_NAME[9],
									Constants.DATABASE_TABLE00_COLUMN_NAME[10],
									Constants.DATABASE_TABLE00_COLUMN_NAME[11],
									Constants.DATABASE_TABLE00_COLUMN_NAME[12],
									Constants.DATABASE_TABLE00_COLUMN_NAME[13],
									Constants.DATABASE_TABLE00_COLUMN_NAME[14],
									Constants.DATABASE_TABLE00_COLUMN_NAME[15],
									Constants.DATABASE_TABLE00_COLUMN_NAME[16],
									Constants.DATABASE_TABLE00_COLUMN_NAME[17]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[1],
									Constants.DATABASE_TABLE01_COLUMN_NAME[0],
									Constants.DATABASE_TABLE01_COLUMN_NAME[1],
									Constants.DATABASE_TABLE01_COLUMN_NAME[2],
									Constants.DATABASE_TABLE01_COLUMN_NAME[3],
									Constants.DATABASE_TABLE01_COLUMN_NAME[4],
									Constants.DATABASE_TABLE01_COLUMN_NAME[5],
									Constants.DATABASE_TABLE01_COLUMN_NAME[6],
									Constants.DATABASE_TABLE01_COLUMN_NAME[7],
									Constants.DATABASE_TABLE01_COLUMN_NAME[8],
									Constants.DATABASE_TABLE01_COLUMN_NAME[9],
									Constants.DATABASE_TABLE01_COLUMN_NAME[10]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[2],
									Constants.DATABASE_TABLE02_COLUMN_NAME[0],
									Constants.DATABASE_TABLE02_COLUMN_NAME[1],
									Constants.DATABASE_TABLE02_COLUMN_NAME[2],
									Constants.DATABASE_TABLE02_COLUMN_NAME[3],
									Constants.DATABASE_TABLE02_COLUMN_NAME[4]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "PRIMARY KEY (`%s`,`%s`));",
									Constants.DATABASE_TABLE_NAME[3],
									Constants.DATABASE_TABLE03_COLUMN_NAME[0],
									Constants.DATABASE_TABLE03_COLUMN_NAME[1],
									Constants.DATABASE_TABLE03_COLUMN_NAME[2],
									Constants.DATABASE_TABLE03_COLUMN_NAME[0],
									Constants.DATABASE_TABLE03_COLUMN_NAME[1]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "PRIMARY KEY (`%s`,`%s`));",
									Constants.DATABASE_TABLE_NAME[4],
									Constants.DATABASE_TABLE04_COLUMN_NAME[0],
									Constants.DATABASE_TABLE04_COLUMN_NAME[1],
									Constants.DATABASE_TABLE04_COLUMN_NAME[2],
									Constants.DATABASE_TABLE04_COLUMN_NAME[0],
									Constants.DATABASE_TABLE04_COLUMN_NAME[1]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[5],
									Constants.DATABASE_TABLE05_COLUMN_NAME[0],
									Constants.DATABASE_TABLE05_COLUMN_NAME[1],
									Constants.DATABASE_TABLE05_COLUMN_NAME[2],
									Constants.DATABASE_TABLE05_COLUMN_NAME[3],
									Constants.DATABASE_TABLE05_COLUMN_NAME[4],
									Constants.DATABASE_TABLE05_COLUMN_NAME[5],
									Constants.DATABASE_TABLE05_COLUMN_NAME[6],
									Constants.DATABASE_TABLE05_COLUMN_NAME[7]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s TEXT NOT NULL DEFAULT '');",
									Constants.DATABASE_TABLE_NAME[6],
									Constants.DATABASE_TABLE06_COLUMN_NAME[0],
									Constants.DATABASE_TABLE06_COLUMN_NAME[1],
									Constants.DATABASE_TABLE06_COLUMN_NAME[2],
									Constants.DATABASE_TABLE06_COLUMN_NAME[3],
									Constants.DATABASE_TABLE06_COLUMN_NAME[4]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "PRIMARY KEY (`%s`,`%s`));",
									Constants.DATABASE_TABLE_NAME[7],
									Constants.DATABASE_TABLE07_COLUMN_NAME[0],
									Constants.DATABASE_TABLE07_COLUMN_NAME[1],
									Constants.DATABASE_TABLE07_COLUMN_NAME[2],
									Constants.DATABASE_TABLE07_COLUMN_NAME[0],
									Constants.DATABASE_TABLE07_COLUMN_NAME[1]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s VARCHAR NOT NULL DEFAULT '', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[8],
									Constants.DATABASE_TABLE08_COLUMN_NAME[0],
									Constants.DATABASE_TABLE08_COLUMN_NAME[1],
									Constants.DATABASE_TABLE08_COLUMN_NAME[2],
									Constants.DATABASE_TABLE08_COLUMN_NAME[3],
									Constants.DATABASE_TABLE08_COLUMN_NAME[4],
									Constants.DATABASE_TABLE08_COLUMN_NAME[5],
									Constants.DATABASE_TABLE08_COLUMN_NAME[6],
									Constants.DATABASE_TABLE08_COLUMN_NAME[7],
									Constants.DATABASE_TABLE08_COLUMN_NAME[8],
									Constants.DATABASE_TABLE08_COLUMN_NAME[9],
									Constants.DATABASE_TABLE08_COLUMN_NAME[10],
									Constants.DATABASE_TABLE08_COLUMN_NAME[11],
									Constants.DATABASE_TABLE08_COLUMN_NAME[12],
									Constants.DATABASE_TABLE08_COLUMN_NAME[13],
									Constants.DATABASE_TABLE08_COLUMN_NAME[14],
									Constants.DATABASE_TABLE08_COLUMN_NAME[15]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[9],
									Constants.DATABASE_TABLE09_COLUMN_NAME[0],
									Constants.DATABASE_TABLE09_COLUMN_NAME[1],
									Constants.DATABASE_TABLE09_COLUMN_NAME[2],
									Constants.DATABASE_TABLE09_COLUMN_NAME[3],
									Constants.DATABASE_TABLE09_COLUMN_NAME[4],
									Constants.DATABASE_TABLE09_COLUMN_NAME[5],
									Constants.DATABASE_TABLE09_COLUMN_NAME[6]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', PRIMARY KEY (`%s`,`%s`));",
									Constants.DATABASE_TABLE_NAME[10],
									Constants.DATABASE_TABLE10_COLUMN_NAME[0],
									Constants.DATABASE_TABLE10_COLUMN_NAME[1],
									Constants.DATABASE_TABLE10_COLUMN_NAME[0],
									Constants.DATABASE_TABLE10_COLUMN_NAME[1]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "PRIMARY KEY (`%s`,`%s`));",
									Constants.DATABASE_TABLE_NAME[11],
									Constants.DATABASE_TABLE11_COLUMN_NAME[0],
									Constants.DATABASE_TABLE11_COLUMN_NAME[1],
									Constants.DATABASE_TABLE11_COLUMN_NAME[2],
									Constants.DATABASE_TABLE11_COLUMN_NAME[0],
									Constants.DATABASE_TABLE11_COLUMN_NAME[1]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s VARCHAR NOT NULL DEFAULT '', %s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[12],
									Constants.DATABASE_TABLE12_COLUMN_NAME[0],
									Constants.DATABASE_TABLE12_COLUMN_NAME[1],
									Constants.DATABASE_TABLE12_COLUMN_NAME[2],
									Constants.DATABASE_TABLE12_COLUMN_NAME[3],
									Constants.DATABASE_TABLE12_COLUMN_NAME[4]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s VARCHAR NOT NULL DEFAULT '', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[13],
									Constants.DATABASE_TABLE13_COLUMN_NAME[0],
									Constants.DATABASE_TABLE13_COLUMN_NAME[1],
									Constants.DATABASE_TABLE13_COLUMN_NAME[2],
									Constants.DATABASE_TABLE13_COLUMN_NAME[3],
									Constants.DATABASE_TABLE13_COLUMN_NAME[4],
									Constants.DATABASE_TABLE13_COLUMN_NAME[5],
									Constants.DATABASE_TABLE13_COLUMN_NAME[6],
									Constants.DATABASE_TABLE13_COLUMN_NAME[7],
									Constants.DATABASE_TABLE13_COLUMN_NAME[8],
									Constants.DATABASE_TABLE13_COLUMN_NAME[9],
									Constants.DATABASE_TABLE13_COLUMN_NAME[10],
									Constants.DATABASE_TABLE13_COLUMN_NAME[11],
									Constants.DATABASE_TABLE13_COLUMN_NAME[12],
									Constants.DATABASE_TABLE13_COLUMN_NAME[13]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', PRIMARY KEY (`%s`,`%s`));",
									Constants.DATABASE_TABLE_NAME[14],
									Constants.DATABASE_TABLE14_COLUMN_NAME[0],
									Constants.DATABASE_TABLE14_COLUMN_NAME[1],
									Constants.DATABASE_TABLE14_COLUMN_NAME[0],
									Constants.DATABASE_TABLE14_COLUMN_NAME[1]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', PRIMARY KEY (`%s`,`%s`));",
									Constants.DATABASE_TABLE_NAME[15],
									Constants.DATABASE_TABLE15_COLUMN_NAME[0],
									Constants.DATABASE_TABLE15_COLUMN_NAME[1],
									Constants.DATABASE_TABLE15_COLUMN_NAME[0],
									Constants.DATABASE_TABLE15_COLUMN_NAME[1]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY, %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[16],
									Constants.DATABASE_TABLE16_COLUMN_NAME[0],
									Constants.DATABASE_TABLE16_COLUMN_NAME[1],
									Constants.DATABASE_TABLE16_COLUMN_NAME[2],
									Constants.DATABASE_TABLE16_COLUMN_NAME[3]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[17],
									Constants.DATABASE_TABLE17_COLUMN_NAME[0],
									Constants.DATABASE_TABLE17_COLUMN_NAME[1],
									Constants.DATABASE_TABLE17_COLUMN_NAME[2]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', PRIMARY KEY (`%s`,`%s`));",
									Constants.DATABASE_TABLE_NAME[18],
									Constants.DATABASE_TABLE18_COLUMN_NAME[0],
									Constants.DATABASE_TABLE18_COLUMN_NAME[1],
									Constants.DATABASE_TABLE18_COLUMN_NAME[0],
									Constants.DATABASE_TABLE18_COLUMN_NAME[1]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s VARCHAR NOT NULL DEFAULT '', %s TEXT NOT NULL DEFAULT '', "
											+ "%s TEXT NOT NULL DEFAULT '', %s TEXT NOT NULL DEFAULT '', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[19],
									Constants.DATABASE_TABLE19_COLUMN_NAME[0],
									Constants.DATABASE_TABLE19_COLUMN_NAME[1],
									Constants.DATABASE_TABLE19_COLUMN_NAME[2],
									Constants.DATABASE_TABLE19_COLUMN_NAME[3],
									Constants.DATABASE_TABLE19_COLUMN_NAME[4],
									Constants.DATABASE_TABLE19_COLUMN_NAME[5],
									Constants.DATABASE_TABLE19_COLUMN_NAME[6],
									Constants.DATABASE_TABLE19_COLUMN_NAME[7],
									Constants.DATABASE_TABLE19_COLUMN_NAME[8],
									Constants.DATABASE_TABLE19_COLUMN_NAME[9],
									Constants.DATABASE_TABLE19_COLUMN_NAME[10],
									Constants.DATABASE_TABLE19_COLUMN_NAME[11],
									Constants.DATABASE_TABLE19_COLUMN_NAME[12],
									Constants.DATABASE_TABLE19_COLUMN_NAME[13],
									Constants.DATABASE_TABLE19_COLUMN_NAME[14],
									Constants.DATABASE_TABLE19_COLUMN_NAME[15],
									Constants.DATABASE_TABLE19_COLUMN_NAME[16],
									Constants.DATABASE_TABLE19_COLUMN_NAME[17],
									Constants.DATABASE_TABLE19_COLUMN_NAME[18],
									Constants.DATABASE_TABLE19_COLUMN_NAME[19],
									Constants.DATABASE_TABLE19_COLUMN_NAME[20],
									Constants.DATABASE_TABLE19_COLUMN_NAME[21],
									Constants.DATABASE_TABLE19_COLUMN_NAME[22],
									Constants.DATABASE_TABLE19_COLUMN_NAME[23],
									Constants.DATABASE_TABLE19_COLUMN_NAME[24],
									Constants.DATABASE_TABLE19_COLUMN_NAME[25],
									Constants.DATABASE_TABLE19_COLUMN_NAME[26],
									Constants.DATABASE_TABLE19_COLUMN_NAME[27],
									Constants.DATABASE_TABLE19_COLUMN_NAME[28],
									Constants.DATABASE_TABLE19_COLUMN_NAME[29]));

			db
					.execSQL(String
							.format(
									"CREATE TABLE IF NOT EXISTS %s(%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT '0', %s VARCHAR NOT NULL DEFAULT '', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', %s INTEGER NOT NULL DEFAULT '0', "
											+ "%s INTEGER NOT NULL DEFAULT '0');",
									Constants.DATABASE_TABLE_NAME[20],
									Constants.DATABASE_TABLE20_COLUMN_NAME[0],
									Constants.DATABASE_TABLE20_COLUMN_NAME[1],
									Constants.DATABASE_TABLE20_COLUMN_NAME[2],
									Constants.DATABASE_TABLE20_COLUMN_NAME[3],
									Constants.DATABASE_TABLE20_COLUMN_NAME[4],
									Constants.DATABASE_TABLE20_COLUMN_NAME[5],
									Constants.DATABASE_TABLE20_COLUMN_NAME[6],
									Constants.DATABASE_TABLE20_COLUMN_NAME[7],
									Constants.DATABASE_TABLE20_COLUMN_NAME[8],
									Constants.DATABASE_TABLE20_COLUMN_NAME[9],
									Constants.DATABASE_TABLE20_COLUMN_NAME[10],
									Constants.DATABASE_TABLE20_COLUMN_NAME[11]));
		} catch (SQLException e) {
			Log.e("ERROR Database-CreateTables: ", e.toString());
		}
	}

	/**
	 * 
	 * @param db
	 */
	private void onDropTables(SQLiteDatabase db) {
		try {
			for (int i = 0; i < Constants.DATABASE_TABLE_NAME.length; ++i)
				db.execSQL("DROP TABLE IF EXISTS "
						+ Constants.DATABASE_TABLE_NAME[i] + ";");
		} catch (SQLException e) {
			Log.e("ERROR Database-DropTables: ", e.toString());
		}
	}

	/**
	 * Called when the database is being started
	 * 
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		onCreateTables(db);
	}

	/**
	 * Called when the database upgrade
	 * 
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase,
	 *      int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");
		onDropTables(db);
		onCreate(db);
	}
}
