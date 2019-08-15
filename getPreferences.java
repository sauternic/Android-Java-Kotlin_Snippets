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

        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        sp.edit().putString("meinWert",textView.getText().toString());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        String str_meinWert = sp.getString("meinWert","nichts");
        textView.setText(str_meinWert);
    }
}
