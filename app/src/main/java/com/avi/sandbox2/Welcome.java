package com.avi.sandbox2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    public static final String MyPref = "myPref";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(MyPref, Context.MODE_PRIVATE);
        if (sharedPreferences.contains("initialized")) {
            Intent intent = new Intent(Welcome.this, Dashboard.class);
            startActivity(intent);
        }
        else
            setContentView(R.layout.activity_welcome);
    }
    public void Login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void Reg(View view){
        Intent intent = new Intent(this, Reg.class);
        startActivity(intent);
    }

}
