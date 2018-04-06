package com.example.a1401587_0.t1;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class MapaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        ButterKnife.bind(this);

    }
}
