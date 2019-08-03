package ch.nicolassauter.dynamischeslayout;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    ConstraintSet mConstraintSet;
    ConstraintLayout mConstraintLayout;
    ViewGroup.MarginLayoutParams lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConstraintSet = new ConstraintSet();
        mConstraintLayout = findViewById(R.id.root); // root id von activity_main.xml
        mConstraintSet.clone(mConstraintLayout);

        button = findViewById(R.id.button);

        lp = (ViewGroup.MarginLayoutParams)button.getLayoutParams();
    }

    public void onClick_button(View v) {

        //mConstraintSet.setHorizontalBias(R.id.button,0.5f);
        //mConstraintSet.applyTo(mConstraintLayout); // set new constraints to ConstraintLayout

        int i = lp.leftMargin;
        setMargins(button,i,0,0,0);
    }

    public void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }
}
