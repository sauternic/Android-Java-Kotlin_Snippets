package ch.nicolassauter.inputdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick_button(View v) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Der Titel");
        alertDialogBuilder.setMessage("Bla bla bla bla bal und bla.");

        //**** EditText is a prompt field! *****************
        final EditText editText = new EditText(this);
        // Specify the type of input expected
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        // editText to alertDialogBuilder
        alertDialogBuilder.setView(editText);
        //**** End EditText prompt field *******************

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        alertDialogBuilder.create().show();


    }

}

// In Kotlin &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
package android.example.myapplication

import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val aDB = AlertDialog.Builder(this)
                .setTitle("Der Titel")
                .setMessage("Bla bla bla")


        //**** EditText is a prompt field! *****************
        val eT = EditText(this)
        eT.inputType = InputType.TYPE_CLASS_TEXT
        aDB.setView(eT)
        //**** End EditText prompt field *******************


        // set dialog message
        aDB
                .setCancelable(false)
                .setPositiveButton("OK") { dialog, id -> Log.d("TAG", "Result: ${eT.text}") }
                .setNegativeButton("Cancel") { dialog, id -> dialog.cancel() }
                .create().show()
    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&