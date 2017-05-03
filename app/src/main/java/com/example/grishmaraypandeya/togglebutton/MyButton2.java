package com.example.grishmaraypandeya.togglebutton;

import android.widget.EditText;

/**
 * Created by Grishma Ray Pandeya on 03.05.2017.
 */

public class MyButton2 implements Runnable {
    private String str;

    public String MyButton2() {
        return str;
    }

    public void run () {
        str = "Button Released";
    }
}
