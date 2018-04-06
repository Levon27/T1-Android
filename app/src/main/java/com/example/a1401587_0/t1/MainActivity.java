package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnMemes)
    public void Memes(){
        Uri uri = Uri.parse("https://www.google.com.br/search?q=jojo's_dank_memes&source=lnms&tbm=isch");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    @OnClick(R.id.btnAlarme)
    public void Alarme(){
        Intent intent = new Intent(this,AlarmeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnSMS)
    public void Sms(){
        Intent intent = new Intent(this,MensagemActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.btnMapa)
    public void Mapa(){

    }
    public void debug(String s){
        Toast.makeText(getApplicationContext(),
                s,
                Toast.LENGTH_SHORT)
                .show();
    }
}
