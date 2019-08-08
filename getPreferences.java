package ch.nicolassauter.pref2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText textFeld1;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFeld1 = findViewById(R.id.textFeld1);

        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();

        textFeld1.setText(sharedPreferences.getString("InhaltTextfeld1", ""));

    }

    @Override
    protected void onPause() {
        super.onPause();

        editor.putString("InhaltTextfeld1",textFeld1.getText().toString());
        // Very Important!
		editor.apply();
    }
}
