package com.avi.sandbox2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Reg extends AppCompatActivity {
    EditText FN;
    EditText SN;
    EditText mail;
    EditText psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
    }
    public void approveReg(View view){
        if (this.checkData()) {
            SharedPreferences sharedPreferences = getSharedPreferences(Welcome.MyPref, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("initialized",true);
            editor.putString("Mail",mail.getText().toString());
            editor.commit();
            Intent intent = new Intent(this, Dashboard.class);
            startActivity(intent);
        }
    }
    public boolean checkData(){
        FN = (EditText) findViewById(R.id.editText_FN);
        SN = (EditText) findViewById(R.id.editText_SN);
        mail = (EditText) findViewById(R.id.editText_mail);
        psw = (EditText) findViewById(R.id.editText_pass);
        if (FN.getText().toString().isEmpty()){
            FN.setError("Cannot be empty");
            return false;
        }
        else
            FN.setError(null);
        if (SN.getText().toString().isEmpty()){
            SN.setError("Cannot be empty");
            return false;
        }
        else
            SN.setError(null);
        if (mail.getText().toString().isEmpty()){
            mail.setError("Cannot be empty");
            return false;
        }
        else
            mail.setError(null);
        if (psw.getText().toString().isEmpty()){
            psw.setError("Cannot be empty");
            return false;
        }
        else
            psw.setError(null);
        return true;
    }
}
