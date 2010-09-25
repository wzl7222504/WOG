package netsurfers.gicp.net.provider;

import netsurfers.gicp.net.common.Constants;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * DatabaseProvider extend from {@link android.content.ContentProvider} which
 * can query, insert, update, delete the data
 * 
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class DatabaseProvider extends ContentProvider {

	private static final String AUTHORRITIES = "netsurfers.gicp.net.provider";
	public static final Uri CONTENT_URI = Uri
			.parse("content://" + AUTHORRITIES);

	private static final String DATABASE_NAME = "wog.db";
	private static final int DATABASE_VERSION = 2;

	private DatabaseHelper mOpenHelper = null;

	/**
	 * A request to delete one or more rows
	 * 
	 * @see android.content.ContentProvider#delete(android.net.Uri,
	 *      java.lang.String, java.lang.String[])
	 */
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Return the MIME type of the data at the given URI
	 * 
	 * @see android.content.ContentProvider#getType(android.net.Uri)
	 */
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Implement this to insert a new row
	 * 
	 * @see android.content.ContentProvider#insert(android.net.Uri,
	 *      android.content.ContentValues)
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Called when the provider is being started
	 * 
	 * @see android.content.ContentProvider#onCreate()
	 */
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		mOpenHelper = new DatabaseHelper(getContext(), DATABASE_NAME, null,
				DATABASE_VERSION);
		return mOpenHelper != null;
	}

	/**
	 * Receives a query request from a client in a local process, and returns a
	 * Cursor
	 * 
	 * @see android.content.ContentProvider#query(android.net.Uri,
	 *      java.lang.String[], java.lang.String, java.lang.String[],
	 *      java.lang.String)
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		Cursor c = db.query(Constants.DATABASE_TABLE_NAME[0], projection, null,
				null, null, null, null);
		return c;
	}

	/**
	 * Update a content URI
	 * 
	 * @see android.content.ContentProvider#update(android.net.Uri,
	 *      android.content.ContentValues, java.lang.String, java.lang.String[])
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
