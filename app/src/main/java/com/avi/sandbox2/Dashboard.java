package com.avi.sandbox2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Button button = (Button) findViewById(R.id.button_logout);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences sharedPreferences = getSharedPreferences(Welcome.MyPref, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(Dashboard.this,Welcome.class);
                startActivity(intent);
            }
        });

    }
    /*public void logout (View view){
        SharedPreferences sharedPreferences = getSharedPreferences(Welcome.MyPref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);

    }*/

}
