package netsurfers.gicp.net.common;

import netsurfers.gicp.net.R;

import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * This class manager all the bitmap source.
 * @author Ziliang Wang
 * E-mail: Lional.King@gmail.com
 */
public class BitmapMgr {

	public final int [] BITMAP = {
			R.drawable.statebars,
			R.drawable.healthbar,
			R.drawable.manabar,
			R.drawable.menubar,
			R.drawable.actionbar,
			R.drawable.bagboard,
			R.drawable.characterboard,
			R.drawable.mapboard,
			R.drawable.spellboard,
			R.drawable.systemboard,
			R.drawable.questboard,
			R.drawable.dialogueboard,
	};
	
	public final int STATEBARS = 0;
	public final int HEALTHBAR = 1;
	public final int MANABAR = 2;
	public final int MENUBAR = 3;
	public final int ACTIONBAR = 4;
	public final int BAGBOARD = 5;
	public final int CHARACTERBOARD = 6;
	public final int MAPBOARD = 7;
	public final int SPELLBOARD = 8;
	public final int SYSTEMBOARD = 9;
	public final int QUESTBOARD = 10;
	public final int DIALOGUEBOARD = 11;
	
	public final int [] PLAYER = {
		R.drawable.player_000,
		R.drawable.player_001,
	};
	
	public static final int [] CREATURE = {
		R.drawable.creature_000,
	};
	
	public static final int [] GAMEOBJECT = {
		R.drawable.gameobject_000,
		R.drawable.gameobject_001,
		R.drawable.gameobject_002,
		R.drawable.gameobject_003,
	};
	
	public static final int [] ITEM = {
		R.drawable.item_000,
		R.drawable.item_001
	};
	
	public static final int [] SPELL = {
		R.drawable.spell_000,
		R.drawable.spell_001
	};
	
	private Map<Integer,Bitmap> mBitmaps = new HashMap<Integer,Bitmap>();
	private Map<Integer,Bitmap> mPlayers = new HashMap<Integer,Bitmap>();
	private Map<Integer,Bitmap> mCreatures = new HashMap<Integer,Bitmap>();
	private Map<Integer,Bitmap> mGameObjects = new HashMap<Integer,Bitmap>();
	private Map<Integer,Bitmap> mItems = new HashMap<Integer,Bitmap>();
	private Map<Integer,Bitmap> mSpells = new HashMap<Integer,Bitmap>();
	
	private Resources mResources;
	
	/**
	 * Constructor function of bitmap manager.
	 * @param res
	 * Resources is from the application program
	 * @see android.app.Activity#getResources()
	 */
	public BitmapMgr(Resources res) {
		mResources = res;
		onInitialize();
	}
	
	/**
	 * Initialize this class when construct it.
	 */
	private void onInitialize(){
		for(int i = 0; i < BITMAP.length; ++i)
			if(null != mBitmaps.get(BITMAP[i]))
				mBitmaps.remove(BITMAP[i]);
		for(int i = 0; i < PLAYER.length; ++i)
			if(null != mPlayers.get(PLAYER[i]))
				mPlayers.remove(PLAYER[i]);
		for(int i = 0; i < CREATURE.length; ++i)
			if(null != mCreatures.get(CREATURE[i]))
				mCreatures.remove(CREATURE[i]);
		for(int i = 0; i < GAMEOBJECT.length; ++i)
			if(null != mGameObjects.get(GAMEOBJECT[i]))
				mGameObjects.remove(GAMEOBJECT[i]);
		for(int i = 0; i < ITEM.length; ++i)
			if(null != mItems.get(ITEM[i]))
				mItems.remove(ITEM[i]);
		for(int i = 0; i < SPELL.length; ++i)
			if(null != mSpells.get(SPELL[i]))
				mSpells.remove(SPELL[i]);
	}
	
	/**
	 * You can set bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public Bitmap setBitmap(int id){
		return BitmapFactory.decodeResource(mResources,id);
	}
	
	/**
	 * You can get bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public Bitmap getBitmap(int id){
		if(false == mBitmaps.containsKey(id)){
			mBitmaps.put(id, setBitmap(id));
		}
		return mBitmaps.get(id);
	}
	
	/**
	 * You can release bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public void releaseBitmap(int id){
		if(false != mBitmaps.containsKey(id)){
			mBitmaps.remove(id);
		}
	}
	
	/**
	 * You can get player bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public Bitmap getPlayerBitmap(int id){
		if(false == mPlayers.containsKey(id)){
			mPlayers.put(id, setBitmap(id));
		}
		return mPlayers.get(id);
	}
	
	/**
	 * You can release player bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public void releasePlayerBitmap(int id){
		if(false != mPlayers.containsKey(id)){
			mPlayers.remove(id);
		}
	}
	
	/**
	 * You can get creature bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public Bitmap getCreatureBitmap(int id){
		if(false == mCreatures.containsKey(id)){
			mCreatures.put(id, setBitmap(id));
		}
		return mCreatures.get(id);
	}
	
	/**
	 * You can release creature bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public void releaseCreatureBitmap(int id){
		if(false != mCreatures.containsKey(id)){
			mCreatures.remove(id);
		}
	}
	
	/**
	 * You can get game object bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public Bitmap getGameObjectBitmap(int id){
		if(false == mGameObjects.containsKey(id)){
			mGameObjects.put(id, setBitmap(id));
		}
		return mGameObjects.get(id);
	}
	
	/**
	 * You can release game object bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public void releaseGameObjectBitmap(int id){
		if(false != mGameObjects.containsKey(id)){
			mGameObjects.remove(id);
		}
	}
	
	/**
	 * You can get item bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public Bitmap getItemBitmap(int id){
		if(false == mItems.containsKey(id)){
			mItems.put(id, setBitmap(id));
		}
		return mItems.get(id);
	}
	
	/**
	 * You can release item bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public void releaseItemBitmap(int id){
		if(false != mItems.containsKey(id)){
			mItems.remove(id);
		}
	}
	
	/**
	 * You can get spell bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public Bitmap getSpellBitmap(int id){
		if(false == mSpells.containsKey(id)){
			mSpells.put(id, setBitmap(id));
		}
		return mSpells.get(id);
	}
	
	/**
	 * You can release spell bitmap by resources id.
	 * @param id
	 * Res is the resources id in {@link R}}
	 */
	public void releaseSpellBitmap(int id){
		if(false != mSpells.containsKey(id)){
			mSpells.remove(id);
		}
	}
	
	/**
	 * You can release all of the bitmap.
	 */
	public void release(){
		for(int i = 0; i < BITMAP.length; ++i)
			if(null != mBitmaps.get(BITMAP[i]))
				mBitmaps.remove(BITMAP[i]);
		for(int i = 0; i < PLAYER.length; ++i)
			if(null != mPlayers.get(PLAYER[i]))
				mPlayers.remove(PLAYER[i]);
		for(int i = 0; i < CREATURE.length; ++i)
			if(null != mCreatures.get(CREATURE[i]))
				mCreatures.remove(CREATURE[i]);
		for(int i = 0; i < GAMEOBJECT.length; ++i)
			if(null != mGameObjects.get(GAMEOBJECT[i]))
				mGameObjects.remove(GAMEOBJECT[i]);
		for(int i = 0; i < ITEM.length; ++i)
			if(null != mItems.get(ITEM[i]))
				mItems.remove(ITEM[i]);
		for(int i = 0; i < SPELL.length; ++i)
			if(null != mSpells.get(SPELL[i]))
				mSpells.remove(SPELL[i]);
	}
}
