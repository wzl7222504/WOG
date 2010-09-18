package  netsurfers.gicp.net.game;

import netsurfers.gicp.net.common.Constants.ORIENTATION;
import netsurfers.gicp.net.common.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Class player.
 * @author Ziliang Wang
 * E-mail: Lional.King@gmail.com
 */
public class Player {
	final int mSpeed = 4;
	boolean mMoving;
	int mBitmapFrame;
	ORIENTATION mPlayerCurState;
	int mGuid;				// 0 存档ID
	String mName;			// 1 存档名字
	int mClass;				// 2 存档帮派
	int mLevel;				// 3 当前等级
	int mXP;				// 4 当前拥有的经验值
	int mMoney;				// 5 当前拥有的银两
	int mPotential;			// 6 当前剩余的潜能点
	int mCurrentHealth;		// 7 当前生命值
	int mCurrentMana;		// 8 当前内力值
	int mPower;				// 9 力量点数
	int mStamina;			//10 耐力点数
	int mEnergy;			//11 活力点数
	int mAgile;				//12 敏捷点数
	int mIntellect;			//13 智力点数
	float mCurrentX;			//14
	float mCurrentY;			//15
	ORIENTATION mOrientation;//16
	int mMapID;				//17 所在地图id
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
	
	public List<Item> mEquipments = new ArrayList<Item>();
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
		for(int i = 0; i < 9; ++i)
			mEquipments.add(new Item(0));
		for(int i = 0; i < 16; ++i)
			mSpells.add(new Spell(0));
		for(int i = 0; i < 7; ++i) {
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
		for(int i = 0; i < 9; ++i)
			mEquipments.add(new Item(0));
		for(int i = 0; i < 16; ++i)
			mSpells.add(new Spell(0));
		for(int i = 0; i < 7; ++i) {
			mQuickSlot[0][i] = -1;
			mQuickSlot[1][i] = -1;
		}
		onInitialize();
		onUpprop();
		onUpdate();
	}
	
	private void onCreateNewPlayer() {
		mName = Tools.mRandomName[Tools.getRandom(10)][0] + Tools.mRandomName[Tools.getRandom(10)][1];
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
		mCurrentHealth = 7*(mPower+3*mStamina+mEnergy);
		mCurrentMana = 5*(mEnergy+mAgile+5*mIntellect);
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
	
	public int getMapID() {
		return mMapID;
	}
	
	public void onMove(ORIENTATION orient) {
		if(getAttack()) return;
		if(true)
			switch(orient) {
			case UP:
				mCurrentY -= mSpeed/2;
				break;
			case DOWN:
				mCurrentY += mSpeed/2;
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
	
	public void release(){
		
	}

	private void onUpprop() {

		mMaxHealth = 7*(mPower+3*mStamina+mEnergy);
		mMaxMana = 5*(mEnergy+mAgile+5*mIntellect);
		mAttackpower = 3*mPower+mStamina;
		mDefencepower = mStamina/2+2*mEnergy+mAgile/3;
		mAttackodds = 100*(mIntellect/2+mAgile+mEnergy/5+mPower/3+mStamina/2)/(mIntellect/2+mAgile+mEnergy/5+mPower+mStamina);
		for(int i = 0; i < 9; ++i) {
			if(0 != mEquipments.get(i).getItemID()) {
				mMaxHealth += mEquipments.get(i).getHealth();
				mMaxMana += mEquipments.get(i).getMana();
				mAttackpower += mEquipments.get(i).getAttack();
				mDefencepower += mEquipments.get(i).getDefence();
				mAttackodds += mEquipments.get(i).getAttackodds();
			}
		}
	}
	
	public void onUpdate() {
		if(!getAttack()) {
			switch(mPlayerCurState) {
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
