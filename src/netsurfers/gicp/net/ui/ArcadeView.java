package netsurfers.gicp.net.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class ArcadeView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

	private Context mContex;
	
	public ArcadeView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContex = context;
	}
	
	public ArcadeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContex = context;
	}
	
	public ArcadeView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		mContex = context;
	}
	
	abstract protected void initialize();
	
	public Context getContex() {
		return mContex;
	}

}
