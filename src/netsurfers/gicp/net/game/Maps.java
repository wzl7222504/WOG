package  netsurfers.gicp.net.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Class maps will manage the background.
 * @author Ziliang Wang
 * E-mail: Lional.King@gmail.com
 */
public class Maps {
	static final int mCacheColumn = 5;
	static final int mCacheRow = 6;
	static final int mFrequency = 200;
	
	int mID;
	int mHeight;
	int mWidth;
	boolean mChangeMap;
	Player mPlayer;
	List<GameObject> mGameObjects = new ArrayList<GameObject>();
	List<Creature> mCreatures = new ArrayList<Creature>();
	
	public Maps() {
		mChangeMap = false;
		mPlayer = new Player();
		onInitialize();
		onFresh(mPlayer.getCurrentX(), mPlayer.getCurrentY());
	}
	
	public void setCurrentPlayer(int guid){
		if(null != mPlayer) {
			mPlayer.release();
			mPlayer = null;
		}
		mPlayer = new Player(guid);
		onInitialize();
		onFresh(mPlayer.getCurrentX(), mPlayer.getCurrentY());
		onUpdate();
	}
	
	private void onInitialize() {
		// TODO Auto-generated method stub
		mID = mPlayer.getMapID();
		if(!mGameObjects.isEmpty())
			mGameObjects.clear();
		if(!mCreatures.isEmpty())
			mCreatures.clear();
	}

	public Player getPlayer() {
		return mPlayer;
	}
	
	public int getMapID() {
		return mID;
	}
	
	public boolean getChangeMap() {
		return mChangeMap;
	}
	
	public int getCreaturesSize() {
		return mCreatures.size();
	}
	
	public int getGameObjectsSize() {
		return mGameObjects.size();
	}
	
	public Creature getCreatures(int location) {
		return mCreatures.get(location);
	}
	
	public GameObject getGameObjects(int location) {
		return mGameObjects.get(location);
	}
	
	private void onFresh(float x, float y) {
		
	}
	
	public void onUpdate() {
		mPlayer.onUpdate();
		//if(0 == GameInterface.self.getWorld().getUpdateFrequency()%mFrequency)
		//	onFresh(mPlayer.getCurrentX(), mPlayer.getCurrentY());
	}
}
