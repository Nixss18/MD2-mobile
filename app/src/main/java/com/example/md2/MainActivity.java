package com.example.md2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.AlertDialog.Builder;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button2;
    String TAG = "MD2";
    private static final String[] names = new String[]{
      "Raivis Tarakanovs", "Niks Grigors", "Linards Sadovskis"
    };
    private boolean[] clicked = new boolean[names.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2= (Button) findViewById(R.id.button2);
    }
    public void onButtonClickMain(View view){
        Log.d(TAG, "I clicked it");
        Intent activityIntent = new Intent(this, Activity2.class);
        startActivity(activityIntent);
    }


    public void showDialog(View v){
       AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
       alertDialog.setTitle("Group 3")
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(MainActivity.this, "You clicked cancel", Toast.LENGTH_LONG).show();

                   }
               });


        alertDialog.setMultiChoiceItems(names, clicked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                switch (which) {
                    case 0:
                        if(isChecked) {
                            Toast.makeText(MainActivity.this, "Clicked on Raivis", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Unclicked on Raivis", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 1:
                        if(isChecked){
                            Toast.makeText(MainActivity.this, "Clicked on Niks", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Unclicked on Niks", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 2:
                        if(isChecked){
                            Toast.makeText(MainActivity.this, "Clicked on Linards", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Unclicked on Linards", Toast.LENGTH_LONG).show();
                        }
                        break;
                }
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
        alert.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "You clicked Ok", Toast.LENGTH_LONG).show();
                Boolean close = false;
                if(close){
                    alert.dismiss();
                }
            }
        });
    }
}