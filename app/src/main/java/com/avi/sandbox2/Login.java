package com.avi.sandbox2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText mail;
    EditText psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public boolean checkLoginData (){
        mail = (EditText) findViewById(R.id.editText_mail);
        psw = (EditText) findViewById(R.id.editText_pass);
        if (mail.getText().toString().isEmpty()){
            mail.setError("Cannot be empty");
            return false;
        }
        if (psw.getText().toString().isEmpty()){
            psw.setError("Cannot be empty");
            return false;
        }
        return true;
    }
    public void approveLogin(View view){
        if(this.checkLoginData()){
            SharedPreferences sharedPreferences = getSharedPreferences(Welcome.MyPref, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("initialized",true);
            editor.putString("Mail",mail.getText().toString());
            editor.commit();
            Intent intent = new Intent(this, Dashboard.class);
            startActivity(intent);
        }

    }
}
