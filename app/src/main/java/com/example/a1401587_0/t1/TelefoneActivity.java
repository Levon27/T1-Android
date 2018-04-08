package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class TelefoneActivity extends Activity {
    @BindView(R.id.btnContato) Button btnContato;

    @BindView(R.id.etContato) EditText etContato;

    @BindView(R.id.btnLigar) Button btnLigar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);
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

    @OnClick(R.id.btnLigar)
    public void ligar(){
        String numero = etContato.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+numero));
        startActivity(intent);
        debug("ligou");
    }

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
