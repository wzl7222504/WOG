package netsurfers.gicp.net.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ArcadeView is the main part to display graphics of the game. Extends {@link SurfaceView}
 * and implements {@link Runnable} & {@link SurfaceHolder.Callback}.This Thread ready to display graphics
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public abstract class ArcadeView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

	private Context mContext;
	
	/**
	 * Constructor function of {@link ArcadeView}
	 * @param context
	 * To use to open or create the view
	 */
	public ArcadeView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext = context;
	}
	
	/**
	 * Constructor function of {@link ArcadeView}
	 * @param context
	 * To use to open or create the view
	 * @param attrs
	 * The attribute of the view
	 */
	public ArcadeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
	}
	
	/**
	 * Constructor function of {@link ArcadeView}
	 * @param context
	 * To use to open or create the view
	 * @param attrs
	 * The attribute of the view
	 * @param defStyle
	 * Default style of the view
	 */
	public ArcadeView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		mContext = context;
	}
	
	/**
	 * Abstract function initialize
	 */
	abstract protected void initialize();
	
	/**
	 * Return the context of the view
	 */
	public Context getContex() {
		return mContext;
	}

}
