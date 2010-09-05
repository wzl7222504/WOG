package netsurfers.gicp.net.ui;

import netsurfers.gicp.net.common.Constants;
import netsurfers.gicp.net.common.Tools;

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
	private int mCurX=0;
	
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
		mContext = context;
		holder = this.getHolder();
		holder.addCallback(this);
		mPaint = new Paint();
		this.setFocusable(true);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Tools.MessageBox(mContext, "Hello world!");
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
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
		return super.onKeyUp(keyCode, event);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.dispatchDraw(canvas);
		mPaint.setColor(Color.RED);
		canvas.drawRect(new RectF(mCurX-100, mCurX-100, mCurX, mCurX), mPaint);
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
                    	mCurX++;
                    	if(mCurX>Constants.SCREEM_WIDTH+100)mCurX=0;
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
