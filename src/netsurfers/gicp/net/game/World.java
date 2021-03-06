package netsurfers.gicp.net.game;

/**
 * Class world will manage the clock of the game
 * 
 * @author Ziliang Wang E-mail: Lional.King@gmail.com
 */
public class World {
	long mUpdateFrequency;
	long mCurrentTimeMillis;
	long mTimeMillis;
	Maps mMaps;

	public World() {
		mUpdateFrequency = 0;
		mCurrentTimeMillis = 0;
		mTimeMillis = System.currentTimeMillis();
		mMaps = new Maps();
	}

	public Maps getMaps() {
		return mMaps;
	}

	public void onUpdate() {
		mCurrentTimeMillis = Math.abs(System.currentTimeMillis() - mTimeMillis);
		++mUpdateFrequency;
		mMaps.onUpdate();
	}

	public long getUpdateFrequency() {
		return mUpdateFrequency;
	}

	public long currentTimeMillis() {
		return mCurrentTimeMillis;
	}
}
