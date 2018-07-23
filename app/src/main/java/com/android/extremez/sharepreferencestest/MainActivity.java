package com.android.extremez.sharepreferencestest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.meiyou.jet.myapplication.R;

public class MainActivity extends Activity {

    private Button saveData;
    private Button restoreData;
    private EditText reg_account;
    private EditText reg_password;
    private EditText reg_age;
    private RadioButton reg_merried;
    private Context context;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext();

        findViewById(R.id.btn_grid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, GridActivity.class));
            }
        });
    }


}
