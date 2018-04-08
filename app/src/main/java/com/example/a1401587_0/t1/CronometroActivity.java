package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CronometroActivity extends Activity {
    @BindView(R.id.btnIniciar)
    Button brnCrono;

    @BindView(R.id.etHoras)
    EditText etHoras;
    @BindView(R.id.etMin)
    EditText etMin;
    @BindView(R.id.etSegundo)
    EditText etSegundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnIniciar)
    public void  inicia(){
        int horas = Integer.parseInt(etHoras.getText().toString());
        int minutos = Integer.parseInt(etMin.getText().toString());
        int segundos = Integer.parseInt(etSegundo.getText().toString());

        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Tempo acabou")
                .putExtra(AlarmClock.EXTRA_LENGTH, horas*3600+minutos*60+segundos)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
