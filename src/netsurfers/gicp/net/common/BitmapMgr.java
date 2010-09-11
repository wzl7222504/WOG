package netsurfers.gicp.net.common;

import netsurfers.gicp.net.R;

import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapMgr {

	public final int [] PLAYER = {
		R.drawable.character_000,
	};
	
	private Map<Integer,Bitmap> mPlayers = new HashMap<Integer,Bitmap>();
	
	private Resources mResources;
	
	public BitmapMgr(Resources res) {
		mResources = res;
		onInitialize();
	}
	
	private void onInitialize(){
		for(int i = 0; i < PLAYER.length; ++i)
			if(null != mPlayers.get(PLAYER[i]))
				mPlayers.remove(PLAYER[i]);
	}
	
	public Bitmap setBitmap(int id){
		return BitmapFactory.decodeResource(mResources,id);
	}
	
	public Bitmap getPlayerBitmap(int id){
		if(false == mPlayers.containsKey(id)){
			mPlayers.put(id, setBitmap(id));
		}
		return mPlayers.get(id);
	}
	
	public void releasePlayerBitmap(int id){
		if(false != mPlayers.containsKey(id)){
			mPlayers.remove(id);
		}
	}
	
	public void release(){
		for(int i = 0; i < PLAYER.length; ++i)
			if(null != mPlayers.get(PLAYER[i]))
				mPlayers.remove(PLAYER[i]);
	}
}
