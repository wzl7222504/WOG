package netsurfers.gicp.net.provider;

import netsurfers.gicp.net.util.Constants;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DatabaseProvider extends ContentProvider {

	private static final String AUTHORRITIES = "netsurfers.gicp.net.provider.DatabaseProvider";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORRITIES);
	
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;
    
    private DatabaseHelper mOpenHelper;
    
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		mOpenHelper = new DatabaseHelper(this.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
        return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		Cursor c = db.query(Constants.DATABASE_TABLE_NAME[0], projection, null, null, null, null, null);
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
