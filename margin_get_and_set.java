package ch.nicolassauter.zugrifmarginbias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ViewGroup.MarginLayoutParams lp;
    private int i_leftMargin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        lp = (ViewGroup.MarginLayoutParams) button.getLayoutParams();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i_leftMargin = lp.leftMargin;
                // Info
                Toast.makeText(MainActivity.this, String.valueOf(i_leftMargin), Toast.LENGTH_SHORT).show();

                lp.setMargins(i_leftMargin + 400, 0, 0, 0);
                // Very important!!!
                button.requestLayout();
            }
        });

    }

}
