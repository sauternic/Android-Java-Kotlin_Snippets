******************************manifest.xml******************************************************

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.myapplication"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-sdk
        android:minSdkVersion="26"
        android:targetSdkVersion="28" />

    <!--Diese Zeile kommt neu rein(Berechtigung!!!)-->
	<uses-permission-sdk-23 android:name="android.permission.VIBRATE" />

    <application..........
	
	
************************************************************************************************


******************************MainActivity.kt***************************************************

package com.example.myapplication

import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button)

        button1.setOnClickListener {
            val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

            //deprecated:
            //vibrator.vibrate(2000);

            //New:
            vibrator.vibrate(VibrationEffect.createOneShot(2000, VibrationEffect.DEFAULT_AMPLITUDE))
        }
    }

}


************************************************************************************************


************************MainActivity.java*******************************************************

package com.example.myapplication;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

                //deprecated:
                //vibrator.vibrate(2000);

                //New:
                vibrator.vibrate(VibrationEffect.createOneShot(2000,VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
    }
	
}
