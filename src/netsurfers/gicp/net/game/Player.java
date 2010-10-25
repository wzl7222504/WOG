package netsurfers.gicp.net.game;

import netsurfers.gicp.net.common.Constants.ORIENTATION;
import netsurfers.gicp.net.common.Tools;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;

/**
 * Class player
 * 
 * @author Ziliang Wang E-mail: Lional.King@gmail.com
 */
public class Player {
	final int mSpeed = 4;
	boolean mMoving;
	int mBitmapFrame;
	ORIENTATION mPlayerCurState;
	long mGuid; // 0 player ID
	String mName; // 1 name of player
	int mSex; // 2 sex of player
	int mClass; // 3 class of player
	int mLevel; // 4 level of player
	int mXP; // 5 player XP
	int mMoney; // 6 money
	int mPotential; // 7 remain potential of player
	int mCurrentHealth; // 8 current health
	int mCurrentMana; // 9 current mana
	int mPower; // 10 power point of player
	int mStamina; // 11 stamina point of player
	int mEnergy; // 12 energy point of player
	int mAgile; // 13 agile point of player
	int mIntellect; // 14 intellect point of player
	float mCurrentX; // 15 x coordinate of the map where the player in
	float mCurrentY; // 16 y coordinate of the map where the player in
	ORIENTATION mOrientation;// 17 current orientation of the player
	int mMapID; // 18 map ID
	int mModelID;
	int mMaxHealth;
	int mMaxMana;
	int mAttackpower;
	int mDefencepower;
	int mAttackodds;
	int mSelectCreature;
	boolean mFighting;
	long mFightingTime;
	boolean mAttacking;

	public List<Items> mEquipments = new ArrayList<Items>();
	public Bag mBag;
	public List<Quest> mQuests = new ArrayList<Quest>();
	public List<Spell> mSpells = new ArrayList<Spell>();

	public int mQuickSlot[][] = new int[2][7];

	public Player() {
		mModelID = 0;
		mMoving = false;
		mBitmapFrame = 0;
		mSelectCreature = -1;
		mFighting = false;
		mFightingTime = 0;
		mAttacking = false;
		mGuid = 1;
		mBag = new Bag();
		for (int i = 0; i < 9; ++i)
			mEquipments.add(new Items(0));
		for (int i = 0; i < 16; ++i)
			mSpells.add(new Spell(0));
		for (int i = 0; i < 7; ++i) {
			mQuickSlot[0][i] = -1;
			mQuickSlot[1][i] = -1;
		}
		onCreateNewPlayer();
		onUpprop();
		onUpdate();
	}

	public Player(int guid) {
		mMoving = false;
		mBitmapFrame = 0;
		mSelectCreature = -1;
		mGuid = guid;
		mBag = new Bag();
		for (int i = 0; i < 9; ++i)
			mEquipments.add(new Items(0));
		for (int i = 0; i < 16; ++i)
			mSpells.add(new Spell(0));
		for (int i = 0; i < 7; ++i) {
			mQuickSlot[0][i] = -1;
			mQuickSlot[1][i] = -1;
		}
		onInitialize();
		onUpprop();
		onUpdate();
	}

	private void onCreateNewPlayer() {
		mName = Tools.mRandomName[Tools.getRandom(10)][0]
				+ Tools.mRandomName[Tools.getRandom(10)][1];
		mClass = Tools.getRandom(5);
		mLevel = 1;
		mXP = 0;
		mMoney = 0;
		mPower = 5 + Tools.getRandom(6);
		mStamina = 5 + Tools.getRandom(6);
		mEnergy = 5 + Tools.getRandom(6);
		mAgile = 5 + Tools.getRandom(6);
		mIntellect = 5 + Tools.getRandom(6);
		mPotential = 50 - (mPower + mStamina + mEnergy + mAgile + mIntellect);
		mOrientation = ORIENTATION.DEFAULT;
		mCurrentHealth = 7 * (mPower + 3 * mStamina + mEnergy);
		mCurrentMana = 5 * (mEnergy + mAgile + 5 * mIntellect);
		mPlayerCurState = ORIENTATION.DEFAULT;
	}

	private void onInitialize() {

	}

	public boolean getAttack() {
		return mAttacking;
	}

	public int getSpeed() {
		return mSpeed;
	}

	public float getCurrentX() {
		return mCurrentX;
	}

	public void setCurrentX(float x) {
		mCurrentX = x;
	}

	public float getCurrentY() {
		return mCurrentY;
	}

	public void setCurrentY(float y) {
		mCurrentY = y;
	}

	public ORIENTATION getPlayerState() {
		return mPlayerCurState;
	}

	public void setPlayerState(ORIENTATION orient) {
		mPlayerCurState = orient;
	}

	public long getID() {
		return mGuid;
	}
	public void setID(long id) {
		mGuid = id;
	}
	
	public int getMapID() {
		return mMapID;
	}

	public void onMove(ORIENTATION orient) {
		if (getAttack())
			return;
		if (true)
			switch (orient) {
			case UP:
				mCurrentY -= mSpeed / 2;
				break;
			case DOWN:
				mCurrentY += mSpeed / 2;
				break;
			case LEFT:
				mCurrentX -= mSpeed;
				break;
			case RIGHT:
				mCurrentX += mSpeed;
				break;
			}
		mOrientation = orient;
	}

	public void setMoveing(boolean moving) {
		mMoving = moving;
	}

	public void release() {

	}
	
	/**
	 * Get the character content values when save the game
	 * @return current character of player content values
	 */
	public ContentValues getCharacterContentValues(){
		ContentValues cvcharacter = new ContentValues();
		if(mGuid != -1)
			cvcharacter.put("_id", mGuid);
		cvcharacter.put("name", mName);
		cvcharacter.put("sex", mSex);
		cvcharacter.put("class", mClass);
		cvcharacter.put("level", mLevel);
		cvcharacter.put("xp", mXP);
		cvcharacter.put("money", mMoney);
		cvcharacter.put("potential", mPotential);
		cvcharacter.put("health", mCurrentHealth);
		cvcharacter.put("mana", mCurrentMana);
		cvcharacter.put("power", mPower);
		cvcharacter.put("stamina", mStamina);
		cvcharacter.put("energy", mEnergy);
		cvcharacter.put("agile", mAgile);
		cvcharacter.put("intellect", mIntellect);
		cvcharacter.put("position_x", mCurrentX);
		cvcharacter.put("position_y", mCurrentY);
		int orient=0;
		switch(mOrientation) {
		case UP:
			orient=1;
			break;
		case DOWN:
			orient=2;
			break;
		case LEFT:
			orient=3;
			break;
		case RIGHT:
			orient=4;
			break;
		default:
			orient=0;
			break;
		}
		cvcharacter.put("orientation", orient);
		cvcharacter.put("map", mMapID);
		return cvcharacter;
	}
	
	/**
	 * Get the equipment sets content values when save the game
	 * @return current equipment sets of player content values
	 */
	public ContentValues getEquipmentsetsContentValues(){
		ContentValues cvequipmentsets = new ContentValues();
		cvequipmentsets.put("guid", mGuid);
		cvequipmentsets.put("item0", mEquipments.get(0).getItemID());
		cvequipmentsets.put("item1", mEquipments.get(1).getItemID());
		cvequipmentsets.put("item2", mEquipments.get(2).getItemID());
		cvequipmentsets.put("item3", mEquipments.get(3).getItemID());
		cvequipmentsets.put("item4", mEquipments.get(4).getItemID());
		cvequipmentsets.put("item5", mEquipments.get(5).getItemID());
		cvequipmentsets.put("item6", mEquipments.get(6).getItemID());
		cvequipmentsets.put("item7", mEquipments.get(7).getItemID());
		cvequipmentsets.put("item8", mEquipments.get(8).getItemID());
		return cvequipmentsets;
	}
	
	/**
	 * Get the inventory content values when save the game
	 * @param slot slot of the bag(values 0 - 27)
	 * @return current inventory of player content values
	 */
	public ContentValues getInventoryContentValues(int slot){
		ContentValues cvinventory = new ContentValues();
		cvinventory.put("guid", mGuid);
		if(null == mBag.getItem(slot))
			return null;
		cvinventory.put("bagslot", slot);
		cvinventory.put("item_template", mBag.getItem(slot).getItemID());
		for(int j = 0; j< 7; ++j) {
			if(slot == mQuickSlot[0][j]) {
				cvinventory.put("quickslot", j);
				break;
			}
			else
				cvinventory.put("quickslot", -1);
		}
		return cvinventory;
	}
	
	/**
	 * Get the quest content values when save the game
	 * @param i quest size(values 0 - {@link Player#getSizeOfQuests()})
	 * @return current quest of player content values
	 */
	public ContentValues getQuestContentValues(int i){
		ContentValues cvquest = new ContentValues();
		cvquest.put("guid", mGuid);
		cvquest.put("quest", mQuests.get(i).getQuestID());
		cvquest.put("status", mQuests.get(i).getQuestStatus());
		return cvquest;
	}
	
	/**
	 * Get the spell content values when save the game
	 * @param i spell size(values 0 - {@link Player#getSizeOfSpells()})
	 * @return current spell of player content values
	 */
	public ContentValues getSpellContentValues(int i){
		ContentValues cvspell = new ContentValues();
		cvspell.put("guid", mGuid);
		if(0 != mSpells.get(i).getSpellID()) {
			cvspell.put("spell", mSpells.get(i).getSpellID());
			for(int j = 0; j< 7; ++j) {
				if((mSpells.get(i).getSpellID()-1)%16 == mQuickSlot[1][j]) {
					cvspell.put("quickslot", j);
					break;
				}
				else
					cvspell.put("quickslot", -1);
			}
		}
		return cvspell;
	}
	
	/**
	 * Get size of list quests
	 * @return the number of quests in this list
	 */
	public int getSizeOfQuests() {
		return mQuests.size();
	}
	
	/**
	 * Get size of list spells
	 * @return the number of spells in this list
	 */
	public int getSizeOfSpells() {
		return mSpells.size();
	}

	private void onUpprop() {

		mMaxHealth = 7 * (mPower + 3 * mStamina + mEnergy);
		mMaxMana = 5 * (mEnergy + mAgile + 5 * mIntellect);
		mAttackpower = 3 * mPower + mStamina;
		mDefencepower = mStamina / 2 + 2 * mEnergy + mAgile / 3;
		mAttackodds = 100
				* (mIntellect / 2 + mAgile + mEnergy / 5 + mPower / 3 + mStamina / 2)
				/ (mIntellect / 2 + mAgile + mEnergy / 5 + mPower + mStamina);
		for (int i = 0; i < 9; ++i) {
			if (0 != mEquipments.get(i).getItemID()) {
				mMaxHealth += mEquipments.get(i).getHealth();
				mMaxMana += mEquipments.get(i).getMana();
				mAttackpower += mEquipments.get(i).getAttack();
				mDefencepower += mEquipments.get(i).getDefence();
				mAttackodds += mEquipments.get(i).getAttackodds();
			}
		}
	}

	public void onUpdate() {
		if (!getAttack()) {
			switch (mPlayerCurState) {
			case DEFAULT:
				setMoveing(false);
				break;
			case UP:
				onMove(ORIENTATION.UP);
				setMoveing(true);
				break;
			case DOWN:
				onMove(ORIENTATION.DOWN);
				setMoveing(true);
				break;
			case LEFT:
				onMove(ORIENTATION.LEFT);
				setMoveing(true);
				break;
			case RIGHT:
				onMove(ORIENTATION.RIGHT);
				setMoveing(true);
				break;
			}
		}
	}
}
