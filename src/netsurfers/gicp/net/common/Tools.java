package netsurfers.gicp.net.common;

import java.util.Random;

import netsurfers.gicp.net.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * Class tools include some tools for example message box
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class Tools {
	public static String mRandomName[][] = {
		{"’≈", "≥æ—Ô"},
		{"¿Ó", "˝à≥…"},
		{"Õı", "ƒΩª™"},
		{"’‘", "…ŸÀß"},
		{"∂Œ", "¿÷¿÷"},
		{"œÙ", "ÃÏ"},
		{"¡ı", "–•"},
		{"…Í", "∞¡"},
		{"ƒΩ»›", "Œ‰"},
		{"≈∑—Ù", "¡÷"},
		{"¡Ó∫¸", "∑Â"}
	};
	static Random mRandom = new Random();
	
	/**
	 * You can get a random number from 0 to max value
	 * @param maxvalue
	 * The max of the random number
	 * @return
	 * Return a random number
	 */
	public static int getRandom(int maxvalue){
		return mRandom.nextInt(maxvalue);
	}
	
	/**
	 * Start a new activity which include action view
	 * @param ctx
	 * The context of this activity
	 * @param url
	 * The URI of this activity
	 */
	static public void launchBrowser(Context ctx, String url) {
    	ctx.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));   
    }
    
    /**
     * Message box will be created
     * @param ctx
     * The context of this toast
     * @param text
     * The text of this toast
     */
    public static void MessageBox( final Context ctx, final String text) {
    	Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();
    }
    
    /**
     * Helper Alert will be created
     * @param ctx
     * The context of this alert dialog
     * @param title
     * The title of this alert dialog
     * @param message
     * The message of this alert dialog
     */
    public static void AlertDialog(final Context ctx, final CharSequence title, final CharSequence message) {
		new AlertDialog.Builder(ctx)
		.setIcon(R.drawable.icon)
		.setTitle(title)
		.setMessage(message)
		.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
		})
		.show();
    }
}
