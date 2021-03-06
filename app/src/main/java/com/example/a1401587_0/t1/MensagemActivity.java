package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
import android.provider.ContactsContract;
import butterknife.BindView;
import android.net.Uri;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MensagemActivity extends Activity {
    @BindView(R.id.btnContato) Button btnContato;
    @BindView(R.id.btnEnviar) Button btnEnviar;
    @BindView(R.id.etContato) EditText etContato;
    @BindView(R.id.etMsg) EditText etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnContato)
    public void procuraContato(){
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(pickContactIntent, 1);
    }

    @OnLongClick(R.id.btnContato)
    public boolean registraContato(){
        Intent i = new Intent (this,RegistroActivity.class);
        startActivity(i);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        String number;
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData(); //uri: endereço de memória onde esta o resultado da busca
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                if (column == 0) {
                    number = cursor.getString(column);
                    etContato.setText(number);
                    debug(number);
                } else {
                    debug("não conseguiu pegar num");
                }
            }
        }

    }

    @OnClick(R.id.btnEnviar)
    public void enviar(){
        String number = etContato.getText().toString();  // The number on which you want to send SMS
        String msg = etMsg.getText().toString();
        Uri uri = Uri.parse("smsto:"+number);
        Intent it = new Intent(Intent.ACTION_SENDTO,uri);
        it.putExtra("sms_body", msg);
        startActivity(it);
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

