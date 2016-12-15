package com.example.wahyu.myapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wahyu.myapplication.R;

public class MainActivity extends Activity {

    private static final String TAG = "login Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Menjalankan onCreate dalam LoginActivity");
    }

    public void btnLoginClicked(View v){
               Intent pindahActivityIntent = new Intent(this, Drawer.class);
                startActivity(pindahActivityIntent);
            }
}
