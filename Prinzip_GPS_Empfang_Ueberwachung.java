package ch.nicolassauter.gps_test_wennaus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    // 10 ist Starwert für den Timer in der if Abfrage
    volatile int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);


    }

    public void onclick_button(View v) {
        if (i == 10) {
            textView.setText("100");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    i = 0;
                    timer();
                }
            }).start();
        } else {
            // Immer wieder Nullen das Schleife wieder von vorne beginnt 3 Sekunden abzuzählen.
            i = 0;
        }
    }

    public void timer() {

        for (; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Toast.makeText(this, "Fehler!! :(", Toast.LENGTH_SHORT).show();
            }
        }
        textView.post(new Runnable() {
            @Override
            public void run() {
                // Kein Empfang mehr ¨'- - -'
                textView.setText("- - -");
                // Wieder Startwert Setzen für Neustart in onclick_button
                i = 10;
            }
        });


    }
}
