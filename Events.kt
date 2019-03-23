******************************MainActivity.kt***************************************************

package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Anzeige1 = findViewById<TextView>(R.id.textView)
        val Knopf1 = findViewById<Button>(R.id.button)
        val Knopf2 = findViewById<Button>(R.id.button2)

        Knopf1.setOnClickListener { Anzeige1.setText(R.string.String_Plus) }

        Knopf2.setOnClickListener { Anzeige1.setText(R.string.String_Minus) }


    }
}

************************************************************************************************

************************MainActivity.java*******************************************************
//Das gleich wie oben in Java:

package com.example.myapplication;

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

        final TextView Anzeige1 = findViewById(R.id.textView);
        Button Knopf1 = findViewById(R.id.button);
        Button Knopf2 = findViewById(R.id.button2);

        Knopf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anzeige1.setText(R.string.String_Plus);
            }

        });

        Knopf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anzeige1.setText(R.string.String_Minus);
            }

        });


    }
}

