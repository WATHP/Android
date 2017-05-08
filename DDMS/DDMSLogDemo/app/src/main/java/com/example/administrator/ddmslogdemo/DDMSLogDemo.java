package com.example.administrator.ddmslogdemo;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class DDMSLogDemo extends Activity {
    private static final String ACTIVITY_TAG="LogDemo";
    private Button bt;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.v(DDMSLogDemo.ACTIVITY_TAG, "This is Verbose.");
                Log.d(DDMSLogDemo.ACTIVITY_TAG, "This is Debug.");
                Log.i(DDMSLogDemo.ACTIVITY_TAG, "This is Information");
                Log.w(DDMSLogDemo.ACTIVITY_TAG, "This is Warnning.");
                Log.e(DDMSLogDemo.ACTIVITY_TAG, "This is Error.");
            }
        }); }
}
