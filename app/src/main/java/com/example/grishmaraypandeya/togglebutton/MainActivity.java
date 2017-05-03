package com.example.grishmaraypandeya.togglebutton;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {



    Handler UIHandler;
    private EditText EDITTEXT;
    private ToggleButton BUTTON;
    Thread thread1;
    String myString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UIHandler = new Handler();
        BUTTON = (ToggleButton)findViewById(R.id.toggleButton);
        EDITTEXT = (EditText) findViewById(R.id.editText);

        final MyButton mb = new MyButton();

        final MyButton2 mb2 = new MyButton2();



        BUTTON.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton butonView, boolean isChecked) {
                if(isChecked) {
                    new Thread(mb).start();
                    UIHandler.post(new updateUI(mb.MyButton()));

                } else {
                    new Thread(mb2).start();
                    UIHandler.post(new updateUI(mb2.MyButton2()));
                }
            }
        });

    }

    class updateUI implements Runnable {

        private String msg;

        public updateUI(String str) {
            this.msg = str;
        }

        public void run() {
            EDITTEXT.setText(msg);

        }
    }




}
