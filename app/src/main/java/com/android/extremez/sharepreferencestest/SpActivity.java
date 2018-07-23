package com.android.extremez.sharepreferencestest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.meiyou.jet.myapplication.R;

public class SpActivity extends Activity {

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
        setContentView(R.layout.signup);
        context = this.getApplicationContext();

        saveData = (Button) findViewById(R.id.reg_signup);
        reg_account = (EditText) findViewById(R.id.reg_accountText);
        reg_age = (EditText) findViewById(R.id.reg_ageText);
        reg_merried = (RadioButton) findViewById(R.id.merried);
        reg_password = (EditText) findViewById(R.id.reg_passwordText);
        restoreData = (Button) findViewById(R.id.load);


    }


    /**
     * 测试 sp
     */
    private void test() {
//        SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
//        editor.putInt("uid", 234234234);
//        editor.apply();

        //BIGData
        String data = "aHR0cDovL3d3dzEudGM3MTEuY29tL3Rvb2wvQkFTRTY0Lmh0bWh0dHA6Ly93d3cxLnRjNzExLmNvbS90b29sL0JBU0U2NC5odG1odHRwOi8vd3d3MS50YzcxMS5jb20vdG9vbC9CQVNFNjQuaHRtaHR0cDovL3d3dzEudGM3MTEuY29tL3Rvb2wvQkFTRTY0Lmh0bWh0dHA6Ly93d3cxLnRjNzExLmNvbS90b29sL0JBU0U2NC5odG1odHRwOi8vd3d3MS50YzcxMS5jb20vdG9vbC9CQVNFNjQuaHRtaHR0cDovL3d3dzEudGM3MTEuY29tL3Rvb2wvQkFTRTY0Lmh0bWh0dHA6Ly93d3cxLnRjNzExLmNvbS90b29sL0JBU0U2NC5odG1odHRwOi8vd3d3MS50YzcxMS5jb20vdG9vbC9CQVNFNjQuaHRtaHR0cDovL3d3dzEudGM3MTEuY29tL3Rvb2wvQkFTRTY0Lmh0bWh0dHA6Ly93d3cxLnRjNzExLmNvbS90b29sL0JBU0U2NC5odG1odHRwOi8vd3d3MS50YzcxMS5jb20vdG9vbC9CQVNFNjQuaHRtaHR0cDovL3d3dzEudGM3MTEuY29tL3Rvb2wvQkFTRTY0Lmh0bWh0dHA6Ly93d3cxLnRjNzExLmNvbS90b29sL0JBU0U2NC5odG1odHRwOi8vd3d3MS50YzcxMS5jb20vdG9vbC9CQVNFNjQuaHRtaHR0cDovL3d3dzEudGM3MTEuY29tL3Rvb2wvQkFTRTY0Lmh0bWh0dHA6Ly93d3cxLnRjNzExLmNvbS90b29sL0JBU0U2NC5odG1odHRwOi8vd3d3MS50YzcxMS5jb20vdG9vbC9CQVNFNjQuaHRt";
        for (int i = 0; i < 100; i++) {
            SharedPreferencesUtil.saveString("zzkey" + i, data, context);
        }

        SharedPreferencesUtil.saveString("uid", 234234234 + "", context);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 100; i++) {
                    final int finalI = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SharedPreferencesUtil.saveInt("time", finalI, context);
                            Log.e(TAG, "run: " + finalI);
                            String all = getAll();
                            Log.e(TAG, "run: " + all);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }).run();
                }
                testSp();

//                SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
//                editor.putString("Account", reg_account.getText().toString());
//                editor.putInt("age", Integer.valueOf(reg_age.getText().toString()));
//                editor.putBoolean("married", reg_merried.isChecked());
//                editor.putString("Password", reg_password.getText().toString());
//                editor.apply();
            }
        });


        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences pref = getSharedPreferences(SharedPreferencesUtil.SHARED_PREFERENCE, MODE_PRIVATE);
//                String s = pref.getAll().toString();
//                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                Intent startIntent = new Intent(SpActivity.this, MyService.class);
                startService(startIntent);
            }
        });

    }

    void testSp() {
        SharedPreferencesUtil.saveString("Account", reg_account.getText().toString(), context);
        SharedPreferencesUtil.saveInt("age", Integer.valueOf(reg_age.getText()
                .toString()), context);
        SharedPreferencesUtil.saveBoolean(context, "married", reg_merried.isChecked());
        SharedPreferencesUtil.saveString("Password", reg_password.getText().toString(), context);
    }

    String getAll() {
        SharedPreferences pref = getSharedPreferences(SharedPreferencesUtil.SHARED_PREFERENCE, MODE_PRIVATE);
        String s = pref.getAll().toString();
        return s;
    }
}
