package  netsurfers.gicp.net.game;

/**
 * Class item is the equipment of the player
 * @author Ziliang Wang
 * E-mail: Lional.King@gmail.com
 */
public class Item {
	int mID;
	int mType;
	int mDisplayID[] = new int[2];
	String mName;
	int mQuality;
	int mBuyPrice;
	int mSellPrice;
	int mRequiredLevel;
	int mCurCount;
	int mMaxCount;
	int mHealth;
	int mMana;
	int mAttack;
	int mDefence;
	int mAttackodds;
	
	public Item(int entry) {
		
	}
	
	public int getItemID() {
		return mID;
	}
	
	public int getType() {
		return mType;
	}
	
	public int getDisplayID(int i) {
		return mDisplayID[i];
	}
	
	public boolean addCount() {
		if(getCanAddCount()) {
			++mCurCount;
			return true;
		}
		else
			return false;
	}
	
	public boolean getCanAddCount() {
		if(mCurCount < mMaxCount)
			return true;
		else
			return false;
	}
	
	public boolean minusCount() {
		if(getCanMinusCount()) {
			--mCurCount;
			return true;
		}
		else
			return false;
	}
	
	public boolean getCanMinusCount() {
		if(1 < mCurCount)
			return true;
		else
			return false;
	}
	
	public int getCurCount() {
		return mCurCount;
	}
	
	public int getHealth() {
		return mHealth;
	}
	
	public int getMana() {
		return mMana;
	}
	
	public int getAttack() {
		return mAttack;
	}
	
	public int getDefence() {
		return mDefence;
	}
	
	public int getAttackodds() {
		return mAttackodds;
	}
	
	public String getName() {
		return mName;
	}
	
	public int getBuyPrice() {
		return mBuyPrice;
	}
	
	public int getSellPrice() {
		return mSellPrice;
	}
}
