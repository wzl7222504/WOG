package netsurfers.gicp.net.provider;

import java.util.HashMap;

import netsurfers.gicp.net.common.Constants;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

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
	
	private static HashMap<String, String> mCharacterProjectionMap;
	private static HashMap<String, String> mCharacterEquipmentSetsProjectionMap;
	private static HashMap<String, String> mCharacterInventoryProjectionMap;
	private static HashMap<String, String> mCharacterQuestProjectionMap;
	private static HashMap<String, String> mCharacterSpellProjectionMap;
	private static HashMap<String, String> mCreatureProjectionMap;
	private static HashMap<String, String> mCreatureAIProjectionMap;
	private static HashMap<String, String> mCreatureLootTemplateProjectionMap;
	private static HashMap<String, String> mCreatureTemplateProjectionMap;
	private static HashMap<String, String> mGameObjectProjectionMap;
	private static HashMap<String, String> mGameObjectQuestRelationProjectionMap;
	private static HashMap<String, String> mGameObjectLootTemplateProjectionMap;
	private static HashMap<String, String> mGameObjectTemplateProjectionMap;
	private static HashMap<String, String> mItemTemplateProjectionMap;
	private static HashMap<String, String> mNPCTrainerProjectionMap;
	private static HashMap<String, String> mNPCVendorProjectionMap;
	private static HashMap<String, String> mPlayerCreateInfoProjectionMap;
	private static HashMap<String, String> mPlayerCreateInfoItemProjectionMap;
	private static HashMap<String, String> mPlayerCreateInfoSpellProjectionMap;
	private static HashMap<String, String> mQuestTemplateProjectionMap;
	private static HashMap<String, String> mSpellChainProjectionMap;
	
	private static final int CHARACTER = 0;
	private static final int CHARACTER_EQUIPMENTSETS = 1;
	private static final int CHARACTER_INVENTORY = 2;
	private static final int CHARACTER_QUEST = 3;
	private static final int CHARACTER_SPELL = 4;
	private static final int CREATURE = 5;
	private static final int CREATURE_AI = 6;
	private static final int CREATURE_LOOT_TEMPLATE = 7;
	private static final int CREATURE_TEMPLATE = 8;
	private static final int GAMEOBJECT = 9;
	private static final int GAMEOBJECT_QUESTRELATION = 10;
	private static final int GAMEOBJECT_LOOT_TEMPLATE = 11;
	private static final int GAMEOBJECT_TEMPLATE = 12;
	private static final int ITEM_TEMPLATE = 13;
	private static final int NPC_TRAINER = 14;
	private static final int NPC_VENDOR = 15;
	private static final int PLAYERCREATEINFO = 16;
	private static final int PLAYERCREATEINFO_ITEM = 17;
	private static final int PLAYERCREATEINFO_SPELL = 18;
	private static final int QUEST_TEMPLATE = 19;
	private static final int SPELL_CHAIN = 20;
	
	private static final UriMatcher sUriMatcher;
	private DatabaseHelper mOpenHelper = null;

	/**
	 * A request to delete one or more rows
	 * 
	 * @see android.content.ContentProvider#delete(android.net.Uri,
	 *      java.lang.String, java.lang.String[])
	 */
	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		int count;
		switch (sUriMatcher.match(uri)) {
		case CHARACTER:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CHARACTER], where, whereArgs);
			break;
		case CHARACTER_EQUIPMENTSETS:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CHARACTER_EQUIPMENTSETS], where, whereArgs);
			break;
		case CHARACTER_INVENTORY:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CHARACTER_INVENTORY], where, whereArgs);
			break;
		case CHARACTER_QUEST:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CHARACTER_QUEST], where, whereArgs);
			break;
		case CHARACTER_SPELL:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CHARACTER_SPELL], where, whereArgs);
			break;
		case CREATURE:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CREATURE], where, whereArgs);
			break;
		case CREATURE_AI:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CREATURE_AI], where, whereArgs);
			break;
		case CREATURE_LOOT_TEMPLATE:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CREATURE_LOOT_TEMPLATE], where, whereArgs);
			break;
		case CREATURE_TEMPLATE:
			count = db.delete(Constants.DATABASE_TABLE_NAME[CREATURE_TEMPLATE], where, whereArgs);
			break;
		case GAMEOBJECT:
			count = db.delete(Constants.DATABASE_TABLE_NAME[GAMEOBJECT], where, whereArgs);
			break;
		case GAMEOBJECT_QUESTRELATION:
			count = db.delete(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_QUESTRELATION], where, whereArgs);
			break;
		case GAMEOBJECT_LOOT_TEMPLATE:
			count = db.delete(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_LOOT_TEMPLATE], where, whereArgs);
			break;
		case GAMEOBJECT_TEMPLATE:
			count = db.delete(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_TEMPLATE], where, whereArgs);
			break;
		case ITEM_TEMPLATE:
			count = db.delete(Constants.DATABASE_TABLE_NAME[ITEM_TEMPLATE], where, whereArgs);
			break;
		case NPC_TRAINER:
			count = db.delete(Constants.DATABASE_TABLE_NAME[NPC_TRAINER], where, whereArgs);
			break;
		case NPC_VENDOR:
			count = db.delete(Constants.DATABASE_TABLE_NAME[NPC_VENDOR], where, whereArgs);
			break;
		case PLAYERCREATEINFO:
			count = db.delete(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO], where, whereArgs);
			break;
		case PLAYERCREATEINFO_ITEM:
			count = db.delete(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO_ITEM], where, whereArgs);
			break;
		case PLAYERCREATEINFO_SPELL:
			count = db.delete(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO_SPELL], where, whereArgs);
			break;
		case QUEST_TEMPLATE:
			count = db.delete(Constants.DATABASE_TABLE_NAME[QUEST_TEMPLATE], where, whereArgs);
			break;
		case SPELL_CHAIN:
			count = db.delete(Constants.DATABASE_TABLE_NAME[SPELL_CHAIN], where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

	/**
	 * Return the MIME type of the data at the given URI
	 * 
	 * @see android.content.ContentProvider#getType(android.net.Uri)
	 */
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (sUriMatcher.match(uri)) {
		case CHARACTER:
			return Constants.DATABASE_CONTENT_TYPE[CHARACTER];
		case CHARACTER_EQUIPMENTSETS:
			return Constants.DATABASE_CONTENT_TYPE[CHARACTER_EQUIPMENTSETS];
		case CHARACTER_INVENTORY:
			return Constants.DATABASE_CONTENT_TYPE[CHARACTER_INVENTORY];
		case CHARACTER_QUEST:
			return Constants.DATABASE_CONTENT_TYPE[CHARACTER_QUEST];
		case CHARACTER_SPELL:
			return Constants.DATABASE_CONTENT_TYPE[CHARACTER_SPELL];
		case CREATURE:
			return Constants.DATABASE_CONTENT_TYPE[CREATURE];
		case CREATURE_AI:
			return Constants.DATABASE_CONTENT_TYPE[CREATURE_AI];
		case CREATURE_LOOT_TEMPLATE:
			return Constants.DATABASE_CONTENT_TYPE[CREATURE_LOOT_TEMPLATE];
		case CREATURE_TEMPLATE:
			return Constants.DATABASE_CONTENT_TYPE[CREATURE_TEMPLATE];
		case GAMEOBJECT:
			return Constants.DATABASE_CONTENT_TYPE[GAMEOBJECT];
		case GAMEOBJECT_QUESTRELATION:
			return Constants.DATABASE_CONTENT_TYPE[GAMEOBJECT_QUESTRELATION];
		case GAMEOBJECT_LOOT_TEMPLATE:
			return Constants.DATABASE_CONTENT_TYPE[GAMEOBJECT_LOOT_TEMPLATE];
		case GAMEOBJECT_TEMPLATE:
			return Constants.DATABASE_CONTENT_TYPE[GAMEOBJECT_TEMPLATE];
		case ITEM_TEMPLATE:
			return Constants.DATABASE_CONTENT_TYPE[ITEM_TEMPLATE];
		case NPC_TRAINER:
			return Constants.DATABASE_CONTENT_TYPE[NPC_TRAINER];
		case NPC_VENDOR:
			return Constants.DATABASE_CONTENT_TYPE[NPC_VENDOR];
		case PLAYERCREATEINFO:
			return Constants.DATABASE_CONTENT_TYPE[PLAYERCREATEINFO];
		case PLAYERCREATEINFO_ITEM:
			return Constants.DATABASE_CONTENT_TYPE[PLAYERCREATEINFO_ITEM];
		case PLAYERCREATEINFO_SPELL:
			return Constants.DATABASE_CONTENT_TYPE[PLAYERCREATEINFO_SPELL];
		case QUEST_TEMPLATE:
			return Constants.DATABASE_CONTENT_TYPE[QUEST_TEMPLATE];
		case SPELL_CHAIN:
			return Constants.DATABASE_CONTENT_TYPE[SPELL_CHAIN];
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
	}
	}

	/**
	 * Implement this to insert a new row
	 * 
	 * @see android.content.ContentProvider#insert(android.net.Uri,
	 *      android.content.ContentValues)
	 */
	@Override
	public Uri insert(Uri uri, ContentValues initialValues) {
		// TODO Auto-generated method stub
		String table="";
		ContentValues values;
        if (initialValues != null) {
            values = new ContentValues(initialValues);
        } else {
            values = new ContentValues();
        }

		// Make sure that the fields are all set
		switch (sUriMatcher.match(uri)) {
		case CHARACTER:
			table = Constants.DATABASE_TABLE_NAME[0];
			for(int i = 0; i < Constants.DATABASE_TABLE00_COLUMN_NAME.length; i++) {
		        if (values.containsKey(Constants.DATABASE_TABLE00_COLUMN_NAME[i]) == false) {
		            values.put(Constants.DATABASE_TABLE00_COLUMN_NAME[i], 0x00);
		        }
			}
			break;
		case CHARACTER_EQUIPMENTSETS:
			table = Constants.DATABASE_TABLE_NAME[1];
			for(int i = 0; i < Constants.DATABASE_TABLE01_COLUMN_NAME.length; i++) {
		        if (values.containsKey(Constants.DATABASE_TABLE01_COLUMN_NAME[i]) == false) {
		            values.put(Constants.DATABASE_TABLE01_COLUMN_NAME[i], 0x00);
		        }
			}
			break;
		case CHARACTER_INVENTORY:
			table = Constants.DATABASE_TABLE_NAME[2];
			for(int i = 0; i < Constants.DATABASE_TABLE02_COLUMN_NAME.length; i++) {
		        if (values.containsKey(Constants.DATABASE_TABLE02_COLUMN_NAME[i]) == false) {
		            values.put(Constants.DATABASE_TABLE02_COLUMN_NAME[i], 0x00);
		        }
			}
			break;
		case CHARACTER_QUEST:
			table = Constants.DATABASE_TABLE_NAME[3];
			for(int i = 0; i < Constants.DATABASE_TABLE03_COLUMN_NAME.length; i++) {
		        if (values.containsKey(Constants.DATABASE_TABLE03_COLUMN_NAME[i]) == false) {
		            values.put(Constants.DATABASE_TABLE03_COLUMN_NAME[i], 0x00);
		        }
			}
			break;
		case CHARACTER_SPELL:
			table = Constants.DATABASE_TABLE_NAME[4];
			for(int i = 0; i < Constants.DATABASE_TABLE04_COLUMN_NAME.length; i++) {
		        if (values.containsKey(Constants.DATABASE_TABLE04_COLUMN_NAME[i]) == false) {
		            values.put(Constants.DATABASE_TABLE04_COLUMN_NAME[i], 0x00);
		        }
			}
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        long rowId = db.insert(table, null, values);
        if (rowId > 0) {
            Uri noteUri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(noteUri, null);
            return noteUri;
        }

        throw new SQLException("Failed to insert row into " + uri);
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
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		switch (sUriMatcher.match(uri)) {
		case CHARACTER:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CHARACTER]);
			qb.setProjectionMap(mCharacterProjectionMap);
			break;
		case CHARACTER_EQUIPMENTSETS:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CHARACTER_EQUIPMENTSETS]);
			qb.setProjectionMap(mCharacterEquipmentSetsProjectionMap);
			break;
		case CHARACTER_INVENTORY:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CHARACTER_INVENTORY]);
			qb.setProjectionMap(mCharacterInventoryProjectionMap);
			break;
		case CHARACTER_QUEST:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CHARACTER_QUEST]);
			qb.setProjectionMap(mCharacterQuestProjectionMap);
			break;
		case CHARACTER_SPELL:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CHARACTER_SPELL]);
			qb.setProjectionMap(mCharacterSpellProjectionMap);
			break;
		case CREATURE:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CREATURE]);
			qb.setProjectionMap(mCreatureProjectionMap);
			break;
		case CREATURE_AI:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CREATURE_AI]);
			qb.setProjectionMap(mCreatureAIProjectionMap);
			break;
		case CREATURE_LOOT_TEMPLATE:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CREATURE_LOOT_TEMPLATE]);
			qb.setProjectionMap(mCreatureLootTemplateProjectionMap);
			break;
		case CREATURE_TEMPLATE:
			qb.setTables(Constants.DATABASE_TABLE_NAME[CREATURE_TEMPLATE]);
			qb.setProjectionMap(mCreatureTemplateProjectionMap);
			break;
		case GAMEOBJECT:
			qb.setTables(Constants.DATABASE_TABLE_NAME[GAMEOBJECT]);
			qb.setProjectionMap(mGameObjectProjectionMap);
			break;
		case GAMEOBJECT_QUESTRELATION:
			qb.setTables(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_QUESTRELATION]);
			qb.setProjectionMap(mGameObjectQuestRelationProjectionMap);
			break;
		case GAMEOBJECT_LOOT_TEMPLATE:
			qb.setTables(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_LOOT_TEMPLATE]);
			qb.setProjectionMap(mGameObjectLootTemplateProjectionMap);
			break;
		case GAMEOBJECT_TEMPLATE:
			qb.setTables(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_TEMPLATE]);
			qb.setProjectionMap(mGameObjectTemplateProjectionMap);
			break;
		case ITEM_TEMPLATE:
			qb.setTables(Constants.DATABASE_TABLE_NAME[ITEM_TEMPLATE]);
			qb.setProjectionMap(mItemTemplateProjectionMap);
			break;
		case NPC_TRAINER:
			qb.setTables(Constants.DATABASE_TABLE_NAME[NPC_TRAINER]);
			qb.setProjectionMap(mNPCTrainerProjectionMap);
			break;
		case NPC_VENDOR:
			qb.setTables(Constants.DATABASE_TABLE_NAME[NPC_VENDOR]);
			qb.setProjectionMap(mNPCVendorProjectionMap);
			break;
		case PLAYERCREATEINFO:
			qb.setTables(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO]);
			qb.setProjectionMap(mPlayerCreateInfoProjectionMap);
			break;
		case PLAYERCREATEINFO_ITEM:
			qb.setTables(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO_ITEM]);
			qb.setProjectionMap(mPlayerCreateInfoItemProjectionMap);
			break;
		case PLAYERCREATEINFO_SPELL:
			qb.setTables(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO_SPELL]);
			qb.setProjectionMap(mPlayerCreateInfoSpellProjectionMap);
			break;
		case QUEST_TEMPLATE:
			qb.setTables(Constants.DATABASE_TABLE_NAME[QUEST_TEMPLATE]);
			qb.setProjectionMap(mQuestTemplateProjectionMap);
			break;
		case SPELL_CHAIN:
			qb.setTables(Constants.DATABASE_TABLE_NAME[SPELL_CHAIN]);
			qb.setProjectionMap(mSpellChainProjectionMap);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		
		// If no sort order is specified use the default
        String orderBy;
        if (TextUtils.isEmpty(sortOrder)) {
            orderBy = "";
        } else {
            orderBy = sortOrder;
        }

        // Get the database and run the query
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, orderBy);

        // Tell the cursor what uri to watch, so it knows when its source data changes
        c.setNotificationUri(getContext().getContentResolver(), uri);
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
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count;
		switch (sUriMatcher.match(uri)) {
		case CHARACTER:
			count = db.update(Constants.DATABASE_TABLE_NAME[CHARACTER], values, selection, selectionArgs);
			break;
		case CHARACTER_EQUIPMENTSETS:
			count = db.update(Constants.DATABASE_TABLE_NAME[CHARACTER_EQUIPMENTSETS], values, selection, selectionArgs);
			break;
		case CHARACTER_INVENTORY:
			count = db.update(Constants.DATABASE_TABLE_NAME[CHARACTER_INVENTORY], values, selection, selectionArgs);
			break;
		case CHARACTER_QUEST:
			count = db.update(Constants.DATABASE_TABLE_NAME[CHARACTER_QUEST], values, selection, selectionArgs);
			break;
		case CHARACTER_SPELL:
			count = db.update(Constants.DATABASE_TABLE_NAME[CHARACTER_SPELL], values, selection, selectionArgs);
			break;
		case CREATURE:
			count = db.update(Constants.DATABASE_TABLE_NAME[CREATURE], values, selection, selectionArgs);
			break;
		case CREATURE_AI:
			count = db.update(Constants.DATABASE_TABLE_NAME[CREATURE_AI], values, selection, selectionArgs);
			break;
		case CREATURE_LOOT_TEMPLATE:
			count = db.update(Constants.DATABASE_TABLE_NAME[CREATURE_LOOT_TEMPLATE], values, selection, selectionArgs);
			break;
		case CREATURE_TEMPLATE:
			count = db.update(Constants.DATABASE_TABLE_NAME[CREATURE_TEMPLATE], values, selection, selectionArgs);
			break;
		case GAMEOBJECT:
			count = db.update(Constants.DATABASE_TABLE_NAME[GAMEOBJECT], values, selection, selectionArgs);
			break;
		case GAMEOBJECT_QUESTRELATION:
			count = db.update(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_QUESTRELATION], values, selection, selectionArgs);
			break;
		case GAMEOBJECT_LOOT_TEMPLATE:
			count = db.update(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_LOOT_TEMPLATE], values, selection, selectionArgs);
			break;
		case GAMEOBJECT_TEMPLATE:
			count = db.update(Constants.DATABASE_TABLE_NAME[GAMEOBJECT_TEMPLATE], values, selection, selectionArgs);
			break;
		case ITEM_TEMPLATE:
			count = db.update(Constants.DATABASE_TABLE_NAME[ITEM_TEMPLATE], values, selection, selectionArgs);
			break;
		case NPC_TRAINER:
			count = db.update(Constants.DATABASE_TABLE_NAME[NPC_TRAINER], values, selection, selectionArgs);
			break;
		case NPC_VENDOR:
			count = db.update(Constants.DATABASE_TABLE_NAME[NPC_VENDOR], values, selection, selectionArgs);
			break;
		case PLAYERCREATEINFO:
			count = db.update(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO], values, selection, selectionArgs);
			break;
		case PLAYERCREATEINFO_ITEM:
			count = db.update(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO_ITEM], values, selection, selectionArgs);
			break;
		case PLAYERCREATEINFO_SPELL:
			count = db.update(Constants.DATABASE_TABLE_NAME[PLAYERCREATEINFO_SPELL], values, selection, selectionArgs);
			break;
		case QUEST_TEMPLATE:
			count = db.update(Constants.DATABASE_TABLE_NAME[QUEST_TEMPLATE], values, selection, selectionArgs);
			break;
		case SPELL_CHAIN:
			count = db.update(Constants.DATABASE_TABLE_NAME[SPELL_CHAIN], values, selection, selectionArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
        return count;
	}

	static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[0], CHARACTER);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[1], CHARACTER_EQUIPMENTSETS);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[2], CHARACTER_INVENTORY);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[3], CHARACTER_QUEST);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[4], CHARACTER_SPELL);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[5], CREATURE);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[6], CREATURE_AI);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[7], CREATURE_LOOT_TEMPLATE);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[8], CREATURE_TEMPLATE);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[9], GAMEOBJECT);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[10], GAMEOBJECT_QUESTRELATION);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[11], GAMEOBJECT_LOOT_TEMPLATE);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[12], GAMEOBJECT_TEMPLATE);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[13], ITEM_TEMPLATE);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[14], NPC_TRAINER);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[15], NPC_VENDOR);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[16], PLAYERCREATEINFO);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[17], PLAYERCREATEINFO_ITEM);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[18], PLAYERCREATEINFO_SPELL);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[19], QUEST_TEMPLATE);
        sUriMatcher.addURI(AUTHORRITIES, Constants.DATABASE_TABLE_NAME[20], SPELL_CHAIN);

        mCharacterProjectionMap = new HashMap<String, String>();
        for(int i = 0; i < Constants.DATABASE_TABLE00_COLUMN_NAME.length; i++) {
        	mCharacterProjectionMap.put(Constants.DATABASE_TABLE00_COLUMN_NAME[i], Constants.DATABASE_TABLE00_COLUMN_NAME[i]);
        }
    	mCharacterEquipmentSetsProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE01_COLUMN_NAME.length; i++) {
        	mCharacterEquipmentSetsProjectionMap.put(Constants.DATABASE_TABLE01_COLUMN_NAME[i], Constants.DATABASE_TABLE01_COLUMN_NAME[i]);
        }
    	mCharacterInventoryProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE02_COLUMN_NAME.length; i++) {
    		mCharacterInventoryProjectionMap.put(Constants.DATABASE_TABLE02_COLUMN_NAME[i], Constants.DATABASE_TABLE02_COLUMN_NAME[i]);
        }
    	mCharacterQuestProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE03_COLUMN_NAME.length; i++) {
    		mCharacterQuestProjectionMap.put(Constants.DATABASE_TABLE03_COLUMN_NAME[i], Constants.DATABASE_TABLE03_COLUMN_NAME[i]);
        }
    	mCharacterSpellProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE04_COLUMN_NAME.length; i++) {
    		mCharacterSpellProjectionMap.put(Constants.DATABASE_TABLE04_COLUMN_NAME[i], Constants.DATABASE_TABLE04_COLUMN_NAME[i]);
        }
    	mCreatureProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE05_COLUMN_NAME.length; i++) {
    		mCreatureProjectionMap.put(Constants.DATABASE_TABLE05_COLUMN_NAME[i], Constants.DATABASE_TABLE05_COLUMN_NAME[i]);
        }
    	mCreatureAIProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE06_COLUMN_NAME.length; i++) {
    		mCreatureAIProjectionMap.put(Constants.DATABASE_TABLE06_COLUMN_NAME[i], Constants.DATABASE_TABLE06_COLUMN_NAME[i]);
        }
    	mCreatureLootTemplateProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE07_COLUMN_NAME.length; i++) {
    		mCreatureLootTemplateProjectionMap.put(Constants.DATABASE_TABLE07_COLUMN_NAME[i], Constants.DATABASE_TABLE07_COLUMN_NAME[i]);
        }
    	mCreatureTemplateProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE08_COLUMN_NAME.length; i++) {
    		mCreatureTemplateProjectionMap.put(Constants.DATABASE_TABLE08_COLUMN_NAME[i], Constants.DATABASE_TABLE08_COLUMN_NAME[i]);
        }
    	mGameObjectProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE09_COLUMN_NAME.length; i++) {
    		mGameObjectProjectionMap.put(Constants.DATABASE_TABLE09_COLUMN_NAME[i], Constants.DATABASE_TABLE09_COLUMN_NAME[i]);
        }
    	mGameObjectQuestRelationProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE10_COLUMN_NAME.length; i++) {
    		mGameObjectQuestRelationProjectionMap.put(Constants.DATABASE_TABLE10_COLUMN_NAME[i], Constants.DATABASE_TABLE10_COLUMN_NAME[i]);
        }
    	mGameObjectLootTemplateProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE11_COLUMN_NAME.length; i++) {
    		mGameObjectLootTemplateProjectionMap.put(Constants.DATABASE_TABLE11_COLUMN_NAME[i], Constants.DATABASE_TABLE11_COLUMN_NAME[i]);
        }
    	mGameObjectTemplateProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE12_COLUMN_NAME.length; i++) {
    		mGameObjectTemplateProjectionMap.put(Constants.DATABASE_TABLE12_COLUMN_NAME[i], Constants.DATABASE_TABLE12_COLUMN_NAME[i]);
        }
    	mItemTemplateProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE13_COLUMN_NAME.length; i++) {
    		mItemTemplateProjectionMap.put(Constants.DATABASE_TABLE13_COLUMN_NAME[i], Constants.DATABASE_TABLE13_COLUMN_NAME[i]);
        }
    	mNPCTrainerProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE14_COLUMN_NAME.length; i++) {
    		mNPCTrainerProjectionMap.put(Constants.DATABASE_TABLE14_COLUMN_NAME[i], Constants.DATABASE_TABLE14_COLUMN_NAME[i]);
        }
    	mNPCVendorProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE15_COLUMN_NAME.length; i++) {
    		mNPCVendorProjectionMap.put(Constants.DATABASE_TABLE15_COLUMN_NAME[i], Constants.DATABASE_TABLE15_COLUMN_NAME[i]);
        }
    	mPlayerCreateInfoProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE16_COLUMN_NAME.length; i++) {
    		mPlayerCreateInfoProjectionMap.put(Constants.DATABASE_TABLE16_COLUMN_NAME[i], Constants.DATABASE_TABLE16_COLUMN_NAME[i]);
        }
    	mPlayerCreateInfoItemProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE17_COLUMN_NAME.length; i++) {
    		mPlayerCreateInfoItemProjectionMap.put(Constants.DATABASE_TABLE17_COLUMN_NAME[i], Constants.DATABASE_TABLE17_COLUMN_NAME[i]);
        }
    	mPlayerCreateInfoSpellProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE18_COLUMN_NAME.length; i++) {
    		mPlayerCreateInfoSpellProjectionMap.put(Constants.DATABASE_TABLE18_COLUMN_NAME[i], Constants.DATABASE_TABLE18_COLUMN_NAME[i]);
        }
    	mQuestTemplateProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE19_COLUMN_NAME.length; i++) {
    		mQuestTemplateProjectionMap.put(Constants.DATABASE_TABLE19_COLUMN_NAME[i], Constants.DATABASE_TABLE19_COLUMN_NAME[i]);
        }
    	mSpellChainProjectionMap = new HashMap<String, String>();
    	for(int i = 0; i < Constants.DATABASE_TABLE20_COLUMN_NAME.length; i++) {
    		mSpellChainProjectionMap.put(Constants.DATABASE_TABLE20_COLUMN_NAME[i], Constants.DATABASE_TABLE20_COLUMN_NAME[i]);
        }
	}
}
