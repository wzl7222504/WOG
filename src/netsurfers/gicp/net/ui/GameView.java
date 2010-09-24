package netsurfers.gicp.net.ui;

import netsurfers.gicp.net.common.Constants;
import netsurfers.gicp.net.common.BitmapMgr;
import netsurfers.gicp.net.common.Constants.ORIENTATION;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * GameView is the main part to display graphics of the game. Extends {@link ArcadeView}
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class GameView extends ArcadeView {

	public Constants.ORIENTATION mPlayerState;
	
	private float mCurrentX=0;
	private float mCurrentY=0;
	private int mCurrentFrame=0;
	private Context mContext;
	private SurfaceHolder holder;
	private Paint mPaint;
	private Thread mThread;
	private BitmapMgr mBitmapMgr;
	
	/**
	 * 
	 * @param context
	 */
	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext = context;
		holder = this.getHolder();
		holder.addCallback(this);
		mPaint = new Paint();
		this.setFocusable(true);
	}
	
	/**
	 * 
	 * @param context
	 * @param attrs
	 */
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
		holder = this.getHolder();
		holder.addCallback(this);
		mPaint = new Paint();
		this.setFocusable(true);
	}
	
	/**
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		mContext = getContext();
		holder = this.getHolder();
		holder.addCallback(this);
		mPaint = new Paint();
		this.setFocusable(true);
	}

	/*
	 * (non-Javadoc)
	 * @see netsurfers.gicp.net.ui.ArcadeView#initialize()
	 */
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		mPlayerState = Constants.ORIENTATION.DEFAULT;
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.view.SurfaceHolder.Callback#surfaceChanged(android.view.SurfaceHolder, int, int, int)
	 */
	@Override
	public void surfaceChanged(SurfaceHolder surfaceholder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * @see android.view.SurfaceHolder.Callback#surfaceCreated(android.view.SurfaceHolder)
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		initialize();
		mThread = new Thread(this);
		mThread.start();
	}

	/*
	 * (non-Javadoc)
	 * @see android.view.SurfaceHolder.Callback#surfaceDestroyed(android.view.SurfaceHolder)
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mThread.stop();
//		while (true) try {
//            mThread.join();
//            break ;
//       } catch(Exception e) {
//    	   e.printStackTrace();
//    	   Log.e("ERROR GameView-destroyed: ", e.toString());
//       }
	}

	/*
	 * (non-Javadoc)
	 * @see android.view.View#onKeyDown(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch(keyCode) {
			case KeyEvent.KEYCODE_DPAD_DOWN:
				mPlayerState = Constants.ORIENTATION.DOWN;
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT:
				mPlayerState = Constants.ORIENTATION.LEFT;
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				mPlayerState = Constants.ORIENTATION.UP;
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				mPlayerState = Constants.ORIENTATION.RIGHT;
				break;
			case KeyEvent.KEYCODE_Q:
				mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://netsurfers.gicp.net.provider.MenuActivity")));
				break;
			case KeyEvent.KEYCODE_BACK:
				System.exit(0);
				break;
			default:
				break;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.view.View#onKeyUp(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch(keyCode) {
			case KeyEvent.KEYCODE_DPAD_DOWN:
				mPlayerState = Constants.ORIENTATION.DEFAULT;
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT:
				mPlayerState = Constants.ORIENTATION.DEFAULT;
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				mPlayerState = Constants.ORIENTATION.DEFAULT;
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				mPlayerState = Constants.ORIENTATION.DEFAULT;
				break;
			default:
				break;
	}
		return super.onKeyUp(keyCode, event);
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.view.View#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		float x = event.getX();
		float y = event.getY();
		switch(event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if((x-Constants.SCREEM_HALF_WIDTH) > 3F*(y-Constants.SCREEM_HALF_HEIGHT) && (x-Constants.SCREEM_HALF_WIDTH) >= -3*(y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.ORIENTATION.RIGHT;
			else if(-3F*(x-Constants.SCREEM_HALF_WIDTH) > (y-Constants.SCREEM_HALF_HEIGHT) && 3F*(x-Constants.SCREEM_HALF_WIDTH) >= (y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.ORIENTATION.UP;
			else if((x-Constants.SCREEM_HALF_WIDTH) < 3*(y-Constants.SCREEM_HALF_HEIGHT) && (x-Constants.SCREEM_HALF_WIDTH) <= -3F*(y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.ORIENTATION.LEFT;
			else if(-3F*(x-Constants.SCREEM_HALF_WIDTH) < (y-Constants.SCREEM_HALF_HEIGHT) && 3F*(x-Constants.SCREEM_HALF_WIDTH) <= (y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.ORIENTATION.DOWN;
			else 
				mPlayerState = Constants.ORIENTATION.DEFAULT;
			break;
		case MotionEvent.ACTION_MOVE:
			if((x-Constants.SCREEM_HALF_WIDTH) > 3F*(y-Constants.SCREEM_HALF_HEIGHT) && (x-Constants.SCREEM_HALF_WIDTH) >= -3*(y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.ORIENTATION.RIGHT;
			else if(-3F*(x-Constants.SCREEM_HALF_WIDTH) > (y-Constants.SCREEM_HALF_HEIGHT) && 3F*(x-Constants.SCREEM_HALF_WIDTH) >= (y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.ORIENTATION.UP;
			else if((x-Constants.SCREEM_HALF_WIDTH) < 3*(y-Constants.SCREEM_HALF_HEIGHT) && (x-Constants.SCREEM_HALF_WIDTH) <= -3F*(y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.ORIENTATION.LEFT;
			else if(-3F*(x-Constants.SCREEM_HALF_WIDTH) < (y-Constants.SCREEM_HALF_HEIGHT) && 3F*(x-Constants.SCREEM_HALF_WIDTH) <= (y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.ORIENTATION.DOWN;
			else 
				mPlayerState = Constants.ORIENTATION.DEFAULT;
			break;
		case MotionEvent.ACTION_UP:
			mPlayerState = Constants.ORIENTATION.DEFAULT;
			break;
		}
		return super.onTouchEvent(event);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long frameElapse, frameTick;
		Canvas canvas = null;
        try {
            frameTick = System.currentTimeMillis();
            while ( true ) {
                    frameElapse = System.currentTimeMillis() - frameTick;
                    if ( frameElapse < Constants.FRAME_INTERVAL ) {
                        Thread.sleep( ( Constants.FRAME_INTERVAL - frameElapse ) );
                    }
                    synchronized (holder) {
                    	canvas = holder.lockCanvas(null);//»ñÈ¡»­²¼
                    	switch(mPlayerState) {
                    	case UP:
                    		mCurrentY-=1.6;
                    		break;
                    	case DOWN:
                    		mCurrentY+=1.6;
                    		break;
                    	case LEFT:
                    		mCurrentX-=3.2;
                    		break;
                    	case RIGHT:
                    		mCurrentX+=3.2;
                    		break;
                    	}
                    	Draw(canvas);
                    	holder.unlockCanvasAndPost(canvas);
                    }
                    frameTick = System.currentTimeMillis();
                }
        } catch ( Exception e ) {
        	e.printStackTrace();
        	Log.e("ERROR GameView-run: ", e.toString());
        }
	}
	
	/**
	 * 
	 * @param canvas
	 */
	private void Draw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.dispatchDraw(canvas);
		
		// TODO Draw the background
		mPaint.setColor(Color.GREEN);
		float x=(int)mCurrentX%40+(mCurrentX-(int)mCurrentX);
		float y=(int)mCurrentY%40+(mCurrentY-(int)mCurrentY);
		float count = (Constants.SCREEM_HEIGHT_DEFAULT+Constants.SCREEM_WIDTH_DEFAULT+40F)/20;
		for(int i = 0;i<count;++i) {
			canvas.drawLine(-x-40F, -Constants.SCREEM_HALF_WIDTH+(i-2)*20F-y, Constants.SCREEM_WIDTH_DEFAULT-x+40F, i*20F-y, mPaint);
			canvas.drawLine(-x-40F, i*20F-y, Constants.SCREEM_WIDTH_DEFAULT-x+40F, -Constants.SCREEM_HALF_WIDTH+(i-2)*20F-y, mPaint);
		}
		
		// TODO Render the background
		mPaint.setColor(Color.GRAY);
		
		// TODO Draw the game view
		mPaint.setColor(Color.RED);
		drawFrame(mBitmapMgr.getPlayerBitmap(mBitmapMgr.PLAYER[1]),8,8,getCurrentFrame(),Constants.SCREEM_HALF_WIDTH-20F, Constants.SCREEM_HALF_HEIGHT-20F,canvas);
		
		// TODO Draw the boards and bars
		mPaint.setColor(Color.YELLOW);
		drawFrame(mBitmapMgr.getBitmap(mBitmapMgr.BITMAP[mBitmapMgr.STATEBARS]), 1, 2, 1, 0F, 0F, canvas);
		drawImage(mBitmapMgr.getBitmap(mBitmapMgr.BITMAP[mBitmapMgr.HEALTHBAR]), 85, 100, 10, canvas);
		drawImage(mBitmapMgr.getBitmap(mBitmapMgr.BITMAP[mBitmapMgr.MANABAR]), 50, 100, 0, canvas);
		drawImage(mBitmapMgr.getBitmap(mBitmapMgr.BITMAP[mBitmapMgr.MENUBAR]), Constants.SCREEM_WIDTH_DEFAULT-40, Constants.SCREEM_HALF_HEIGHT-120, canvas);
		drawImage(mBitmapMgr.getBitmap(mBitmapMgr.BITMAP[mBitmapMgr.ACTIONBAR]), Constants.SCREEM_HALF_WIDTH-160, Constants.SCREEM_HEIGHT_DEFAULT-80, canvas);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCurrentFrame(){
		switch(mPlayerState) {
		case DEFAULT:
			mCurrentFrame = mCurrentFrame-mCurrentFrame%8;
			break;
		case UP:
			mCurrentFrame = mCurrentFrame%3+1;
			break;
		case DOWN:
			mCurrentFrame = Math.abs(mCurrentFrame-8)%3+9;
			break;
		case LEFT:
			mCurrentFrame = Math.abs(mCurrentFrame-16)%3+17;
			break;
		case RIGHT:
			mCurrentFrame = Math.abs(mCurrentFrame-24)%3+25;
			break;
		}
		return mCurrentFrame;
	}
	
	/**
	 * 
	 * @param bitmap
	 * @param column
	 * @param row
	 * @param currentframe
	 * @param x
	 * @param y
	 * @param cv
	 */
	public void drawFrame(Bitmap bitmap,int column,int row,int currentframe,float x,float y,Canvas cv)
	{
		int width, height;
		width = bitmap.getWidth();
		height = bitmap.getHeight();
		Rect src = new Rect();
		RectF dst = new RectF();
		src.set((currentframe%column)*width/column, (currentframe/column)*height/row,
				width/column+(currentframe%column)*width/column, height/row+(currentframe/column)*height/row);
		dst.set(x, y, width/column+x, height/row+y);
		cv.drawBitmap(bitmap, src, dst, mPaint);
	}
	
	/**
	 * Draw the HP and MP on left top.
	 * @param bitmap
	 * @param cur
	 * @param max
	 * @param dis
	 * @param cv
	 */
	public void drawImage(Bitmap bitmap, int cur, int max, int dis, Canvas cv) {
		Rect current = new Rect();
		current.set(0, 0, 40+(108+dis)*cur/max, 40);
		cv.drawBitmap(bitmap, current, current, mPaint);
	}
	
	/**
	 * 
	 * @param bitmap
	 * @param src
	 * @param dst
	 * @param cv
	 */
	public void drawImage(Bitmap bitmap, Rect src, RectF dst, Canvas cv) {
		cv.drawBitmap(bitmap, src, dst, mPaint);
	}
	
	/**
	 * 
	 * @param bitmap
	 * @param x
	 * @param y
	 * @param cv
	 */
	public void drawImage(Bitmap bitmap, float x, float y, Canvas cv) {
		cv.drawBitmap(bitmap, x, y, mPaint);
	}
	
	/**
	 * 
	 * @param str
	 * @param x
	 * @param y
	 * @param cv
	 */
	public void drawText(String str, float x, float y, Canvas cv)  {
		cv.drawText(str, x, y, mPaint);
	}
	
	/**
	 * 
	 * @param bm
	 */
	public void setBitmapMgr(BitmapMgr bm) {
		mBitmapMgr = bm;
	}
	
	/**
	 * 
	 * @return
	 */
	public float getCurrentX() {
		return mCurrentX;
	}
	
	/**
	 * 
	 * @param x
	 */
	public void setCurrentX(float x) {
		mCurrentX = x;
	}
	
	/**
	 * 
	 * @return
	 */
	public float getCurrentY() {
		return mCurrentY;
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setCurrentY(float y) {
		mCurrentY = y;
	}
	
	/**
	 * 
	 * @return
	 */
	public ORIENTATION getPlayerState() {
		return mPlayerState;
	}
	
	/**
	 * 
	 * @param orient
	 */
	public void setPlayerState(ORIENTATION orient) {
		mPlayerState = orient;
	}
}
