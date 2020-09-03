package android.example.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import static java.lang.Thread.yield;

public class MyService extends Service {

    private final IBinder mBinder = new LocalBinder();
    private int i_  = 0;

    public MyService() {
    }

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public int zaehlen() {
        this.i_ ++;
        return i_;
    }

    private void warten() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

////////////////////////////////////////////////////////////////////////////////////////////////////

package android.example.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView ausgabe;
    private MyService mService = null;
    private ServiceConnection mConection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.LocalBinder binder = (MyService.LocalBinder) iBinder;
            mService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ausgabe = findViewById(R.id.textView_ausgabe);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ServiceBeenden();
    }

    public void onClick_Service(View view) {
        ServiceStarten();
        if (mService != null) {
            try {
                ausgabe.setText(String.valueOf(mService.zaehlen()));
            } catch (Exception e) {
                Toast.makeText(this, "ging nicht", Toast.LENGTH_SHORT).show();
                ;
            }
        }
    }

    public void onClick_Stop_Service(View view) {
        ServiceBeenden();
    }

    //**************************************************************************

    //Hilfsfunktionen
    private void ServiceStarten(){
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, mConection, Context.BIND_AUTO_CREATE);
    }

    private void ServiceBeenden(){
        if (mService != null) {
            unbindService(mConection);
            mService = null;
        }
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="android.example.service">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <service
            android:name=".MyService"
            android:enabled="true"
            android:exported="true" />
    </application>

</manifest>