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
        RdesktopNative.setUsername("kidfolk");
        RdesktopNative.setPassword("xwjshow");
        int result = RdesktopNative.rdp_connect("192.168.8.47", 51, "", "xwjshow", "", "", false);
        //String str = mNative.getenv();
        text.setText(result+"");
    }
}