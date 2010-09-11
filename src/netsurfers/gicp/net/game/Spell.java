package  netsurfers.gicp.net.game;

public class Spell {
	int mID;
	int mDisplayID[] = new int[2];
	String mName;
	int mPrevSpell;
	int mFirstSpell;
	int mReqSpell;
	int mDamage;
	int mClass;
	int mType;
	int mCost;
	int mReqLevel;
	int mAudioID;
	
	public Spell(int spell_id) {
		
	}
	
	public int getSpellID() {
		return mID;
	}
	
	public int getDisplayID(int i) {
		return mDisplayID[i];
	}
	
	public String getName() {
		return mName;
	}
	
	public int getDamage() {
		return mDamage;
	}
}
