package com.example.a1401587_0.t1;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class RegistroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ButterKnife.bind(this);
    }

}
