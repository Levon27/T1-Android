package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnotacaoActivity extends Activity {
    @BindView(R.id.etAssunto)
    EditText etAssunto;

    @BindView(R.id.etDescricao)
    EditText etDescricao;

    @BindView(R.id.btnMarcar)
    Button btnMarcar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacao);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnMarcar)
    public void marcar(){
        String assunto = etAssunto.getText().toString();
        String descricao = etDescricao.getText().toString();
        /*
        Intent intent = new Intent(NoteIntents.ACTION_CREATE_NOTE)
                .putExtra(NoteIntents.EXTRA_NAME, assunto)
                .putExtra(NoteIntents.EXTRA_TEXT, descricao);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        */
    }

}
