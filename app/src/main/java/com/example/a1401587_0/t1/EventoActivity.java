package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalTime;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventoActivity extends Activity {
    @BindView(R.id.etTitulo)
    EditText etTitulo;

    @BindView(R.id.etLocal)
    EditText etLocal;

    @BindView(R.id.btnMarcar)
    EditText btnMarcar;

    @BindView(R.id.etHoraInicio)
    EditText etHoraInicio;

    @BindView(R.id.etHoraTerm)
    EditText etHoraTermino;

    @BindView(R.id.etMinInicio)
    EditText etMinInicio;

    @BindView(R.id.etMinTerm)
    EditText etMinTermino;

    @BindView(R.id.etSegInicio)
    EditText etSegInicio;

    @BindView(R.id.etSegTerm)
    EditText etSegTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.btnMarcar)
    public void marcar() {
        debug("clicou");
        long tempo = System.currentTimeMillis();

        long HoraInicio = Integer.parseInt(etHoraInicio.getText().toString());
        long MinInicio = Integer.parseInt(etMinInicio.getText().toString());
        long SegInicio = Integer.parseInt(etSegInicio.getText().toString());

        long HoraTerm = Integer.parseInt(etHoraTermino.getText().toString());
        long MinTerm = Integer.parseInt(etMinTermino.getText().toString());
        long SegTerm = Integer.parseInt(etSegTerm.getText().toString());

        long Inicio = tempo+(HoraInicio*3600 + MinInicio*60 + SegInicio)*1000;
        long Termino = tempo + (HoraTerm*3600 + MinTerm*60 + SegTerm)*1000;


        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, etTitulo.getText().toString())
                .putExtra(CalendarContract.Events.EVENT_LOCATION, etLocal.getText().toString())
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,Inicio)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,Termino);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            debug("marcou evento");
        } else
            debug("nao conseguiu");
    }



    public void debug(String s){
        Toast.makeText(getApplicationContext(),
                s,
                Toast.LENGTH_SHORT)
                .show();
    }
}
