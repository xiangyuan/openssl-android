package org.kidfolk.androidRDP;

public class RdesktopNative {

	public boolean g_redirect = false;

	public static native String getenv();
	
	public static native void setUsername(String username);
	
	public static native void setPassword(String password);

	public static native int rdp_connect(String server, int flags, String domain,
			String password, String shell, String directory, boolean g_redirect);

	public static native void rdp_main_loop();
	
	static {
		System.loadLibrary("rdesktop");
	}

}
