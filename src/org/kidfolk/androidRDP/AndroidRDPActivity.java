package org.kidfolk.androidRDP;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidRDPActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView text = (TextView) findViewById(R.id.text);
		setUsername("kidfolk");
		setPassword("xwjshow");
		int result = rdp_connect("192.168.3.115", 51, "",
				"", "", "", false);
		if (result != 0) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					rdp_main_loop();
				}

			});
			thread.start();
		}
		// String str = RdesktopNative.getenv();
		text.setText(result + "");
	}

	private static native String getenv();

	private static native void setUsername(String username);

	private static native void setPassword(String password);

	private static native int rdp_connect(String server, int flags,
			String domain, String password, String shell, String directory,
			boolean g_redirect);

	private static native void rdp_main_loop();
	
	private static native Byte[] getBitmapBytesFormNative(int x,int y,int width,int height,Byte[] data);

	static {
		System.loadLibrary("rdesktop");
	}
}