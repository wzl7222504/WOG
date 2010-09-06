package netsurfers.gicp.net.ui;

import netsurfers.gicp.net.common.Constants;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameView extends ArcadeView {

	private Context mContext;
	private SurfaceHolder holder;
	private Paint mPaint;
	private Thread mThread;
	public Constants.PLAYER_STATE mPlayerState;
	private float mCurX=160;
	private float mCurY=240;
	
	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext = context;
		holder = this.getHolder();
		holder.addCallback(this);
		mPaint = new Paint();
		this.setFocusable(true);
	}
	
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
		holder = this.getHolder();
		holder.addCallback(this);
		mPaint = new Paint();
		this.setFocusable(true);
	}
	
	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		mContext = getContext();
		holder = this.getHolder();
		holder.addCallback(this);
		mPaint = new Paint();
		this.setFocusable(true);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		mPlayerState = Constants.PLAYER_STATE.NOTHING;
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder surfaceholder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		initialize();
		mThread = new Thread(this);
		mThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mThread.stop();
		while (true) try {
            mThread.join();
            break ;
       } catch(Exception e) {
    	   e.printStackTrace();
    	   Log.e("ERROR GameView-destroyed: ", e.toString());
       }
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch(keyCode) {
			case KeyEvent.KEYCODE_DPAD_DOWN:
				mPlayerState = Constants.PLAYER_STATE.DOWN;
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT:
				mPlayerState = Constants.PLAYER_STATE.LEFT;
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				mPlayerState = Constants.PLAYER_STATE.UP;
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				mPlayerState = Constants.PLAYER_STATE.RIGHT;
				break;
			case KeyEvent.KEYCODE_BACK:
				System.exit(0);
				break;
			default:
				break;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch(keyCode) {
			case KeyEvent.KEYCODE_DPAD_DOWN:
				mPlayerState = Constants.PLAYER_STATE.NOTHING;
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT:
				mPlayerState = Constants.PLAYER_STATE.NOTHING;
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				mPlayerState = Constants.PLAYER_STATE.NOTHING;
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				mPlayerState = Constants.PLAYER_STATE.NOTHING;
				break;
			default:
				break;
	}
		return super.onKeyUp(keyCode, event);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		float x = event.getX();
		float y = event.getY();
		switch(event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if((x-Constants.SCREEM_HALF_WIDTH) > 3F*(y-Constants.SCREEM_HALF_HEIGHT) && (x-Constants.SCREEM_HALF_WIDTH) >= -3*(y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.PLAYER_STATE.RIGHT;
			else if(-3F*(x-Constants.SCREEM_HALF_WIDTH) > (y-Constants.SCREEM_HALF_HEIGHT) && 3F*(x-Constants.SCREEM_HALF_WIDTH) >= (y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.PLAYER_STATE.UP;
			else if((x-Constants.SCREEM_HALF_WIDTH) < 3*(y-Constants.SCREEM_HALF_HEIGHT) && (x-Constants.SCREEM_HALF_WIDTH) <= -3F*(y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.PLAYER_STATE.LEFT;
			else if(-3F*(x-Constants.SCREEM_HALF_WIDTH) < (y-Constants.SCREEM_HALF_HEIGHT) && 3F*(x-Constants.SCREEM_HALF_WIDTH) <= (y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.PLAYER_STATE.DOWN;
			else 
				mPlayerState = Constants.PLAYER_STATE.NOTHING;
			break;
		case MotionEvent.ACTION_MOVE:
			if((x-Constants.SCREEM_HALF_WIDTH) > 3F*(y-Constants.SCREEM_HALF_HEIGHT) && (x-Constants.SCREEM_HALF_WIDTH) >= -3*(y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.PLAYER_STATE.RIGHT;
			else if(-3F*(x-Constants.SCREEM_HALF_WIDTH) > (y-Constants.SCREEM_HALF_HEIGHT) && 3F*(x-Constants.SCREEM_HALF_WIDTH) >= (y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.PLAYER_STATE.UP;
			else if((x-Constants.SCREEM_HALF_WIDTH) < 3*(y-Constants.SCREEM_HALF_HEIGHT) && (x-Constants.SCREEM_HALF_WIDTH) <= -3F*(y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.PLAYER_STATE.LEFT;
			else if(-3F*(x-Constants.SCREEM_HALF_WIDTH) < (y-Constants.SCREEM_HALF_HEIGHT) && 3F*(x-Constants.SCREEM_HALF_WIDTH) <= (y-Constants.SCREEM_HALF_HEIGHT))
				mPlayerState = Constants.PLAYER_STATE.DOWN;
			else 
				mPlayerState = Constants.PLAYER_STATE.NOTHING;
			break;
		case MotionEvent.ACTION_UP:
			mPlayerState = Constants.PLAYER_STATE.NOTHING;
			break;
		}
		return super.onTouchEvent(event);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.dispatchDraw(canvas);
		mPaint.setColor(Color.GREEN);
		float x=40-mCurX%40;
		float y=40-mCurY%40;
		float count = (Constants.SCREEM_HALF_HEIGHT+Constants.SCREEM_HALF_WIDTH+40F)/2;
		for(int i = 0;i<count;++i) {
			canvas.drawLine(x-40F, -Constants.SCREEM_HALF_WIDTH+(i-2)*20F+y, Constants.SCREEM_WIDTH_DEFAULT+x, (i-1)*20F+y, mPaint);
			canvas.drawLine(x-40F, (i-1)*20F+y, Constants.SCREEM_WIDTH_DEFAULT+x, -Constants.SCREEM_HALF_WIDTH+(i-2)*20F+y, mPaint);
		}
		mPaint.setColor(Color.RED);
		canvas.drawRect(new RectF(Constants.SCREEM_HALF_WIDTH-10F, Constants.SCREEM_HALF_HEIGHT-10F,
			Constants.SCREEM_HALF_WIDTH+10F, Constants.SCREEM_HALF_HEIGHT+10F), mPaint);
	}
	
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
                    		mCurY--;
                    		break;
                    	case DOWN:
                    		mCurY++;
                    		break;
                    	case LEFT:
                    		mCurX--;
                    		break;
                    	case RIGHT:
                    		mCurX++;
                    		break;
                    	}
                    	onDraw(canvas);
                    	holder.unlockCanvasAndPost(canvas);
                    }
                    frameTick = System.currentTimeMillis();
                }
        } catch ( Exception e ) {
        	e.printStackTrace();
        	Log.e("ERROR GameView-run: ", e.toString());
        }
	}
}
