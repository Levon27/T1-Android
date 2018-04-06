package com.example.a1401587_0.t1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MensagemActivity extends Activity {
    @BindView(R.id.btnContato) Button btnContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnContato)
    public void procuraContato(){

    }
}
