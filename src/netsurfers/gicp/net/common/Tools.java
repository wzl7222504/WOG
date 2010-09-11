package netsurfers.gicp.net.common;

import java.util.Random;

import netsurfers.gicp.net.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

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
	
	public static int getRandom(int maxvalue){
		return mRandom.nextInt(maxvalue);
	}
	
	static public void launchBrowser(Context ctx, String url) {
    	ctx.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));   
    }
    
    
    public static void MessageBox( final Context ctx, final String text) {
    	Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();
    }
    
    /**
     * Helper Alert
     * @param title
     * @param message
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
