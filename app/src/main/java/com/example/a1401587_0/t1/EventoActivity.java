package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.EditText;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;

public class EventoActivity extends Activity {
    @BindView(R.id.etTitulo)
    EditText etTitulo;

    @BindView(R.id.etLocal)
    EditText etLocal;

    @BindView(R.id.btnMarcar)
    EditText btnMarcar;

    @BindView(R.id.etInicio)
    EditText etInicio;

    @BindView(R.id.etTermino)
    EditText etTermino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
    }

    @OnClick (R.id.btnMarcar)
    public void marcar() {
        Calendar inicio = Calendar.getInstance();
        Calendar termino = Calendar.getInstance();
        etInicio.getText().toString();


        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, etTitulo.getText().toString())
                .putExtra(CalendarContract.Events.EVENT_LOCATION, etLocal.getText().toString());
                //.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, )
                //.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, );

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
