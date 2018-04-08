package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistroActivity extends Activity {
    @BindView(R.id.etNumero) EditText etNumero;
    @BindView(R.id.etNome) EditText etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.btnRegistrar)
    public void registra(){

        String num = etNumero.getText().toString();
        String nome = etNome.getText().toString();

        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        intent.putExtra(ContactsContract.Intents.Insert.NAME, nome);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, num);

        startActivity(intent);

        //debug("criou novo contato");
        debug(num+" "+nome);
        finish();

    }


    public void debug(String s){
        Toast.makeText(getApplicationContext(),
                s,
                Toast.LENGTH_SHORT)
                .show();
    }

    public void debug(Integer s){
        Toast.makeText(getApplicationContext(),
                s,
                Toast.LENGTH_SHORT)
                .show();
    }
}
