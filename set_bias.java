package ch.nicolassauter.set_bias;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        constraintSet = new ConstraintSet();
        constraintLayout = findViewById(R.id.id_MainActivity);
        constraintSet.clone(constraintLayout);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                constraintSet.setHorizontalBias(button.getId(), 0.1f);
                constraintSet.applyTo(constraintLayout);
            }
        });

    }


}
