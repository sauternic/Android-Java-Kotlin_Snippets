package com.example.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AsyncKlasse asyncKlasse = new AsyncKlasse(textView);
                // Parameter Übergabe... beliebig viele Longs oder keine.
                asyncKlasse.execute(5L, 4L, 6L);

            }
        });
    }

    // Inner Class
    private class AsyncKlasse extends AsyncTask<Long, Integer, String[]> {

        private TextView _textView;

        AsyncKlasse(TextView textView) {
            _textView = textView;
        }

        // region Background-Worker-Thread:
        // *********************************************************
        @Override
        protected String[] doInBackground(Long... longs) {

            for (int i = 0; i <= 10; i++) {

                // Transmitter progress
                publishProgress(i);

                //region sleep
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //endregion
            }
            return null;
        }// endregion


        // region UI-Thread:
        // **********************************************************

        // Receiver Progress:
        @Override
        protected void onProgressUpdate(Integer... values) {
            _textView.setText(String.valueOf(values[0]));
        }

        // After Background Thread
        @Override
        protected void onPostExecute(String[] strings) {
        }

        // Befor Background Thread
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onCancelled(String[] strings) {
        } //endregion
    }
}
