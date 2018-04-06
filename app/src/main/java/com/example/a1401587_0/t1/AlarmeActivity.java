package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.TimePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlarmeActivity extends Activity {
    @BindView(R.id.tpHorario) TimePicker tpHorario;
    @BindView(R.id.btnDefine) Button btnDefine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarme);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnDefine)
    public void Define(){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM).putExtra(AlarmClock.EXTRA_MESSAGE, "Acorda vagabundo")
                .putExtra(AlarmClock.EXTRA_HOUR,tpHorario.getCurrentHour() )
                .putExtra(AlarmClock.EXTRA_MINUTES, tpHorario.getCurrentMinute());


        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

    }
}
