package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class AsyncKlasse extends AsyncTask<Long, Integer, Void> {

    // Field
    private TextView _TextView;
    private Button _button;

    // Kontsruktor um 'TextView' Typ hier bekannt zu machen
    public AsyncKlasse(TextView textView, Button button) {
        _TextView = textView;
        _button = button;
    }

    // Backgroun-Thread:
    // *********************************************************
    @Override
    protected Void doInBackground(Long... longs) {

        for (int i = 0; i <= 10; i++) {

            // Sender
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
    }

    // UI-Thread:
    // **********************************************************

    // Empfänger:
    @Override
    protected void onProgressUpdate(Integer... values) {
        _TextView.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPreExecute() {
        _button.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        _button.setEnabled(true);
    }

    @Override
    protected void onCancelled(Void aVoid) {
    }
}
