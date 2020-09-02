package android.example.brodcast1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Ausgabe_Hello_World;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ausgabe_Hello_World = findViewById(R.id.textView_hello_world);
    }

    public void onClick_Senden(View view) {
        Intent intent = new Intent("ch.nicolassauter.BROTCAST_BEISPIEL");
        intent.putExtra("Nachricht", "Von mir gesendete Nachricht");
        sendBroadcast(intent);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            Ausgabe_Hello_World.setText(intent.getStringExtra("Nachricht"));
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("ch.nicolassauter.BROTCAST_BEISPIEL");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}