package ch.nicolassauter.testgetpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("1000");
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sh = getPreferences(MODE_PRIVATE);
        sh.edit().putString("meinWert",textView.getText().toString()).apply();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getPreferences(MODE_PRIVATE);
        textView.setText(sh.getString("meinWert","Nichts?"));
    }
}
